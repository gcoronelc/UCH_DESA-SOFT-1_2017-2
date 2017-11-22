package pe.egcc.condominio.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.condominio.model.Obligacion;

@Service
public class CondoService extends AbstractDBSupport {

  @Transactional(propagation=Propagation.REQUIRES_NEW,
      rollbackFor=Exception.class)
  public void generaCuotaMant(int anio, int mes, int idpersona){
    
    String sql = "select count(*) cont "
        + "from obligacion "
        + "where anio = ? and mes = ? "
        + "and idtobligacion = 2";
    Object[] args = {anio, mes};
    int cont = jdbcTemplate.queryForObject(sql, args, Integer.class);
    if(cont > 0){
      throw new RuntimeException("La obligación ya existe.");
    }
    
    // Los immuebles
    sql = "select i.idinmueble, ti.mantenimiento "
        + "from tinmueble ti "
        + "join inmueble i "
        + "on ti.idtinmueble = i.idtinmueble "
        + "where ti.mantenimiento > 0 "
        + "for update ";
    
    List<Map<String,Object>> lstImuebles;
    lstImuebles = jdbcTemplate.queryForList(sql);
    
    // Fecha
    String fecha = anio + "-" + mes + "-01";
    
    // Proceso
    sql = "insert into obligacion(idtobligacion,idinmueble, "
        + "anio,mes,fvence,importe,fecha,audidpersona) values "
        + "(2,?,?,?, last_day(?), ?, sysdate(), ?)";
    for (Map<String,Object> r : lstImuebles) {
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
  
  
  public List<Obligacion> leerObligaciones( Integer periodo, Integer mes, Integer tipo){
	  
	  String sql = "select id,inmueble,codigo,torre,piso,descripcion, "
	  		+ "obligacion,nomobligacio,anio,mes, "
	  		+ "vencimiento,importe,pagada "
	  		+ "from v_obligacion  "
	  		+ "where obligacion = ?";
	  
	  List<Obligacion> lista = jdbcTemplate.query(sql,
			  new BeanPropertyRowMapper<Obligacion>(Obligacion.class), tipo);
	  
	  return lista;
  }
  
  
  
}
