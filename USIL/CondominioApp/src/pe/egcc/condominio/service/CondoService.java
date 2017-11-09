package pe.egcc.condominio.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CondoService extends AbstractDBSupport {

  @Transactional(propagation=Propagation.REQUIRED,
      rollbackFor=Exception.class)
  public void generaCuotaMant(int anio, int mes, int idpersona){
    
    // Los immuebles
    String sql = "select i.idinmueble, ti.mantenimiento "
        + "from tinmueble ti "
        + "join inmueble i "
        + "on ti.idtinmueble = i.idtinmueble "
        + "where ti.mantenimiento > 0";
    
    List<Map<String,Object>> lstImuebles;
    lstImuebles = jdbcTemplate.queryForList(sql);
    
    // Fecha
    String fecha = anio + "-" + mes + "-01";
    
    // Proceso
    sql = "insert into obligacion(idtobligacion,idinmueble, "
        + "anio,mes,fvence,importe,fecha,audidpersona) values "
        + "(2,?,?,?, last_day(?), ?, sysdate(), ?)";
    for (Map<String,Object> r : lstImuebles) {
      Object[] args = {
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
  
  
}
