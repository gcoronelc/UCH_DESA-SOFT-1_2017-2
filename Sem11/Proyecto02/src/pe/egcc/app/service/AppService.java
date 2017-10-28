package pe.egcc.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<String> leerPeriodos() {

    String sql = "select distinct left(idciclo,4) periodo " + "from ciclo order by 1 desc";

    List<String> lista;
    lista = jdbcTemplate.queryForList(sql, String.class);

    return lista;
    
  }
  
  public List<Map<String,Object>> leerMejoresCursos(String periodo){
    
    String sql = "select periodo, ciclo, idcurso, nomcurso,"
        + "secciones, matriculados from v_mejor_curso "
        + "where periodo = ? order by 2, 3 ";
    
    List<Map<String,Object>> lista;
    lista = jdbcTemplate.queryForList(sql, periodo);
    
    return lista;
    
  }

}
