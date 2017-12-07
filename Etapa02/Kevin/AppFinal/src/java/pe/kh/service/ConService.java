/*
<%-- 
                                                                                                     
 o   o                o          o    o                      8                             .oPYo.    
 8  .P                           8    8                      8                             8    8    
o8ob'  .oPYo. o    o o8 odYo.   o8oooo8 o    o .oPYo. o    o 8oPYo. o    o .oPYo. .oPYo.   8         
 8  `b 8oooo8 Y.  .P  8 8' `8    8    8 8    8 .oooo8 8    8 8    8 8    8 .oooo8 Yb..     8         
 8   8 8.     `b..d'  8 8   8    8    8 8    8 8    8 8    8 8    8 8    8 8    8   'Yb.   8    8    
 8   8 `Yooo'  `YP'   8 8   8    8    8 `YooP' `YooP8 `YooP8 8    8 `YooP' `YooP8 `YooP'   `YooP' 88 
:..::..:.....:::...:::....::..:::..:::..:.....::.....::....8 ..:::..:.....::.....::.....::::.....:..:
::::::::::::::::::::::::::::::::::::::::::::::::::::::::ooP'.::::::::::::::::::::::::::::::::::::::::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::...::::::::::::::::::::::::::::::::::::::::::

    Proyecto    : KH-Condominio
    Creacion    : 30-nov-2017, 1:36:18
    Autor       : Kevin Huayhuas Cariapaza
--%>
 */
package pe.kh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.kh.model.Obligacion;
import pe.kh.model.Persona;


/**
 *
 * @author Kevin
 */
@Service
public class ConService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> consultarMovimiento(String tmovimiento) {
        String sql = "select * from consultaMovimiento where tmovimiento_nombre=? or inmueble_codigo=?";

        List<Map<String, Object>> lista;
        lista = jdbcTemplate.queryForList(sql, tmovimiento, tmovimiento);
        return lista;
    }

    public String crearPago(String inmueble, String obligacion, String tmovimiento, String fecha, String importe, String descripcion,
            String audpersona) {
        String rpt;
        try {
            String sql = "insert into movimiento values(null,?,?,?,?,?,?,?);";
            jdbcTemplate.update(sql, inmueble, obligacion, tmovimiento, fecha, importe, descripcion, audpersona);
            rpt = "Exito";
        } catch (Exception e) {
            rpt = e.getMessage();
        }
        return rpt;
    }

    public List<Map<String, Object>> listaInmueble() {
        String sql = "select * from inmueble";
        List<Map<String, Object>> lista;
        lista = jdbcTemplate.queryForList(sql);
        return lista;
    }

    public List<Map<String, Object>> listaObligacion() {
        String sql = "select * from obligacion where idtobligacion = 2";
        List<Map<String, Object>> lista;
        lista = jdbcTemplate.queryForList(sql);
        return lista;
    }

    public List<Map<String, Object>> listaTMovimiento() {
        String sql = "select * from tmovimiento";
        List<Map<String, Object>> lista;
        lista = jdbcTemplate.queryForList(sql);
        return lista;
    }

    public List<Map<String, Object>> listaPersona() {
        String sql = "select * from persona";
        List<Map<String, Object>> lista;
        lista = jdbcTemplate.queryForList(sql);
        return lista;
    }

    //Generar Obligaciones //
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void creaCuotaMant(int anio, int mes, int idpersona) {

        String sql = "select count(*) cont "
                + "from obligacion "
                + "where anio = ? and mes = ? "
                + "and idtobligacion = 2";
        Object[] args = {anio, mes};
        int cont = jdbcTemplate.queryForObject(sql, args, Integer.class);
        if (cont > 0) {
            throw new RuntimeException("La obligación ya existe.");
        }

        // Los immuebles
        sql = "select i.idinmueble, ti.mantenimiento "
                + "from tinmueble ti "
                + "join inmueble i "
                + "on ti.idtinmueble = i.idtinmueble "
                + "where ti.mantenimiento > 0 "
                + "for update ";

        List<Map<String, Object>> lstImuebles;
        lstImuebles = jdbcTemplate.queryForList(sql);

        // Fecha
        String fecha = anio + "-" + mes + "-01";

        // Proceso
        sql = "insert into obligacion(idtobligacion,idinmueble, "
                + "anio,mes,fvence,importe,fecha,audidpersona) values "
                + "(2,?,?,?, last_day(?), ?, sysdate(), ?)";
        for (Map<String, Object> r : lstImuebles) {
            args = new Object[]{
                r.get("idinmueble"),
                anio,
                mes,
                fecha,
                r.get("mantenimiento"),
                idpersona
            };
            jdbcTemplate.update(sql, args);
        }

    }

    public List<Obligacion> generaCuotaMant(int anio, int mes) {

        String sql = "select count(*) cont "
                + "from obligacion "
                + "where anio = ? and mes = ? "
                + "and idtobligacion = 2";
        Object[] args = {anio, mes};
        int cont = jdbcTemplate.queryForObject(sql, args, Integer.class);
        if (cont > 0) {
            throw new RuntimeException("La obligación ya existe.");
        }

        // Los immuebles
        sql = "select i.idinmueble, ti.mantenimiento,"
                + "i.codigo, i.idtorre, i.piso, i.descripcion "
                + "from tinmueble ti "
                + "join inmueble i "
                + "on ti.idtinmueble = i.idtinmueble "
                + "where ti.mantenimiento > 0 ";

        List<Map<String, Object>> lstImuebles;
        lstImuebles = jdbcTemplate.queryForList(sql);

        // Fecha
        String fecha = anio + "-" + mes + "-01";
        sql = "select last_day(?) fecha";
        Date fechaVence = jdbcTemplate.queryForObject(sql, Date.class, fecha);

        // Proceso
        List<Obligacion> obligaciones = new ArrayList<>();
        for (Map<String, Object> r : lstImuebles) {

            Obligacion bean = new Obligacion();
            bean.setId(0);
            bean.setInmueble(Integer.parseInt(r.get("idinmueble").toString()));
            bean.setCodigo(r.get("codigo").toString());
            bean.setTorre(Integer.parseInt(r.get("idtorre").toString()));
            bean.setPiso(Integer.parseInt(r.get("piso").toString()));
            bean.setNomobligacion("MANTENIMIENTO");
            bean.setDescripcion(r.get("descripcion").toString());
            bean.setPagada("NOSE");
            bean.setAnio(anio);
            bean.setMes(mes);
            bean.setVencimiento(fechaVence);
            bean.setImporte(Double.parseDouble(r.get("mantenimiento").toString()));

            obligaciones.add(bean);

        }

        return obligaciones;
    }

    public List<Obligacion> leerObligaciones(Integer periodo, Integer mes, Integer tipo) {

        String sql = "select id,inmueble,codigo,torre,piso,descripcion, "
                + "obligacion,nomobligacion,anio,mes, "
                + "vencimiento,importe,pagada "
                + "from v_obligacion  "
                + "where anio = ? "
                + "and mes = ? "
                + "and obligacion = ? ";

        List<Obligacion> lista = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<Obligacion>(Obligacion.class), periodo, mes, tipo);

        return lista;
    }

    //LOGIN SERVICE
    public Persona validarUsuario(String usuario, String clave) {
        Persona bean = null;

        // Inicio del proceso
        try {

            String sql = "select p.idpersona, p.idtpersona, p.nombre,"
                    + "p.apellido, p.dni, p.telefono, p.direccion, "
                    + "p.email, u.idrol "
                    + "from persona p "
                    + "join usuario u "
                    + "on p.idpersona = u.idpersona "
                    + "where u.usuario = ? "
                    + "and clave = SHA(?)";

            bean = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Persona>(Persona.class),usuario, clave);

        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Datos incorrectos.");
        }

        // Fin del proceso
        return bean;
    }

}
