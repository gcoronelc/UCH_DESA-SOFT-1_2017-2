package pe.egcc.condominio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MoviService {
	
	  @Autowired
	  private JdbcTemplate jdbcTemplate;

	  public List<String> leerInmueble() {

	    String sql = "SELECT NOMBRE FROM tinmueble " + 
	    		"where MANTENIMIENTO > 0";

	    List<String> lista;
	    lista = jdbcTemplate.queryForList(sql, String.class);

	    return lista;
	    
	  }
	  
	  public List<Map<String,Object>> leerMovimiento(String inmueble){
	    
	    String sql = "SELECT tm.ACCION TIPOINMUEBLE, o.IDOBLIGACION OBLIGACION, i.DESCRIPCION INMUEBLE, m.IMPORTE PAGO, " + 
	    		"p.NOMBRE PROPIETARIO, m.FECHA FECHA FROM movimiento m " + 
	    		"inner join tmovimiento tm on tm.IDTMOVIMIENTO = m.IDTMOVIMIENTO and tm.ACCION = 'INGRESO' " + 
	    		"inner join obligacion o on o.IDOBLIGACION = m.IDOBLIGACION " + 
	    		"inner join tobligacion tob on tob.IDTOBLIGACION = o.IDTOBLIGACION " + 
	    		"inner join persona p on p.IDPERSONA = m.AUDIDPERSONA " + 
	    		"inner join inmueble i on i.IDINMUEBLE = m.IDINMUEBLE " + 
	    		"inner join tinmueble ti on ti.IDTINMUEBLE = i.IDTINMUEBLE " + 
	    		"where tob.IDTOBLIGACION = 2 and ti.NOMBRE = ?";
	    
	    List<Map<String,Object>> lista;
	    lista = jdbcTemplate.queryForList(sql, inmueble);
	    
	    return lista;
	    
	  }


}
