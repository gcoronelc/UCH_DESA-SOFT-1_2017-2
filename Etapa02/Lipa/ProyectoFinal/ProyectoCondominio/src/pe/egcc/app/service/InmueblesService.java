package pe.egcc.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
public class InmueblesService extends AbstractDBSupport{
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,
		      rollbackFor=Exception.class)
	
	// LEE LAS TORRES
	  
		public List<String> leeTorre() {

		String sql = "select NOMBRE from TORRE where TORRE in (1,2,3,4) ";

		List<String> lista;
		lista = jdbcTemplate.queryForList(sql, String.class);

		    return lista;
		    
		  }
		
	// LEE TIPOS DE INMUEBLES
		  
		public List<String> leeTipoInmueble() {

		String sql = "select NOMBRE from TIPOINMUEBLE where TIPOINMUEBLE in (2,3,4) ";

		List<String> lista;
		lista = jdbcTemplate.queryForList(sql, String.class);

		    return lista;
			    
		  }

	// CONSULTA QUE BUSCA LOS PISOS EN BASE A LA TORRE SELECCIONADA
		
		public List<Map<String,Object>> buscaPiso(String torre){
		    
		String sql = " select p.DESCRIPCION "
					+ " from PISO p "
					+ " inner join TORRE t on p.TORRE = t.TORRE "
					+ " where t.NOMBRE = ? ";
				    
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, torre);
			    
		   return lista;
				    
		}
		
	// LLAMA AL PROCEMIENTO ALMACENADO QUE GUARDA LOS INMUEBLES
		
		public void guardaInmueble(String tipoinmueble, String dni, String piso, String descripcion){
		
		Object[] args = {tipoinmueble, dni, piso, descripcion};
		String sql = "{call usp_guardaInmueble(?,?,?,?)}";
		args = new Object[]{
	           tipoinmueble,
	           dni,
	           piso,
	           descripcion
			};
			jdbcTemplate.update(sql, args);
		}
		
		// CONSULTA QUE BUSCA LAS OBLIGACIONES QUE TIENE UNA PERSONA EN RAZÓN A SU DNI
		
		public List<Map<String,Object>> buscaObligacion(String dni){
		    
			String sql = " select o.OBLIGACION "
						+ " from OBLIGACION o "
						+ " inner join PERSONA p on o.PERSONA = p.PERSONA "
						+ " where p.DNI = ? and o.REALIZADO = 0 and o.TIPOOBLIGACION = 2";
				    
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, dni);
			    
		   return lista;
				    
		}
		
		// CONSULTA QUE BUSCA LOS INMUEBLES EN RAZÓN A LA OBLIGACIÓN
		
		public List<Map<String,Object>> buscaInmueble(String obligacion){
			    
			String sql = " select I.INMUEBLE, I.DESCRIPCION, o.FECHA, o.FVENCE "
						+ " from INMUEBLE I "
						+ " inner join OBLIGACION o on o.INMUEBLE = i.INMUEBLE "
						+ " where o.OBLIGACION = ?";
				    
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, obligacion);
				    
		   return lista;
				    
		}	
		
		// CONSULTA QUE BUSCA EL IMPORTE EN RAZÓN A LA OBLIGACIÓN
		
		public List<Map<String,Object>> buscaImporte(String obligacion){
				    
			String sql = " select IMPORTE from OBLIGACION where OBLIGACION = ? ";
					    
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, obligacion);
					    
		   return lista;
				    
		}
		
		// CONSULTA QUE BUSCA LA FECHA DE INICIO DE UNA OBLIGACIÓN
		
		public List<Map<String,Object>> buscaFechaI(String obligacion){
					    
			String sql = " select FECHA from OBLIGACION where OBLIGACION = ? ";
						    
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, obligacion);
						    
		   return lista;
					    
		}
		
		// CONSULTA QUE BUSCA LA FECHA DE VENCIMIENTO DE UNA OBLIGACIÓN
		
		public List<Map<String,Object>> buscaFechaF(String obligacion){
						    
			String sql = " select FVENCE from OBLIGACION where OBLIGACION = ? ";
							    
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, obligacion);
							    
		   return lista;
						    
		}
		
		// LLAMA AL PROCEMIENTO ALMACENADO QUE REGISTRA LOS PAGOS
		
		public void creaMovimiento(String dni, String obligacion, String descripcion){
		
		Object[] args = {dni, obligacion, descripcion};
		String sql = "{call usp_registroMantenimiento(?,?,?)}";
		args = new Object[]{
	           dni,
		       obligacion,
		       descripcion
			};
			jdbcTemplate.update(sql, args);
		}
		
		
}
