package pe.egcc.app.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CursoService extends AbstractDBSupport{
  
  public List<Map<String,Object>> conResumenCurso(String ciclo){
    // Preparando el query
    String sql = "select   periodo, ciclo, idtarifa, nomtarifa, "
            + "idcurso, nomcurso, horas, secciones, vacdisp, "
            + "vactotal, matriculados, precio, pagohora, "
            + "ingresos, pagoprof, utilidad  "
            + "from V_RESUMEN_CURSO "
            + "where ciclo = ? ";
    // Ejecutando el query
    List<Map<String,Object>> lista;
    lista = jdbcTemplate.queryForList(sql, ciclo);
    // Retornar resultado
    return lista;
  }
  
  
}
