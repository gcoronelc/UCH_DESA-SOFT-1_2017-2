package pe.egcc.condominio.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import pe.egcc.condominio.model.Persona;

@Service
public class LogonService extends AbstractDBSupport{

  public Persona validarUsuario(String usuario, String clave){
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
      
      bean = jdbcTemplate.queryForObject(sql, 
          new BeanPropertyRowMapper<Persona>(Persona.class),
          usuario, clave);
      
    } catch (EmptyResultDataAccessException e) {
      throw new RuntimeException("Datos incorrectos.");
    }
    
    // Fin del proceso
    return bean;
  }
  
}
