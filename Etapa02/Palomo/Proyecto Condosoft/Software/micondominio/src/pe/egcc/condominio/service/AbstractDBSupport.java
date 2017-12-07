package pe.egcc.condominio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDBSupport {

  @Autowired
  protected JdbcTemplate jdbcTemplate;

}
