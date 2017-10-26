package pe.egcc.app.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import pe.egcc.app.model.Usuario;

@Service
public class LogonService extends AbstractDBSupport {

  public Usuario validar(String usuario, String clave) {
    Usuario bean = null;
    try {

      String sql = "select idpersona,idrol," 
          + "usuario,estado from usuario " 
          + "where usuario = ? "
          + "and clave = HashBytes('SHA1',?)";
      
      bean = jdbcTemplate.queryForObject(sql, 
          new BeanPropertyRowMapper<Usuario>(Usuario.class), 
          usuario, clave);
      
    } catch (EmptyResultDataAccessException e) {
      
      e.printStackTrace();
      
      throw new RuntimeException("Error datos");      
     
    }
    return bean;
  }

}
