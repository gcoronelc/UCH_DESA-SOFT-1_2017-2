package pe.egcc.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
public class CondoService extends AbstractDBSupport{
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,
		      rollbackFor=Exception.class)
	
	// LLAMA AL PROCEMIENTO ALMACENADO QUE REGISTRA LOS PAGOS
	
	public void creaMovimiento(String dni, String obligacion, String descripcion){
	
	Object[] args = {dni, obligacion, descripcion};
	String sql = "{call registropago(?,?,?)}";
	args = new Object[]{
           dni,
	       obligacion,
	       descripcion
		};
		jdbcTemplate.update(sql, args);
	}
	
	// LEE TIPO DE INMUEBLE
	  
	public List<String> leerInmueble() {

	String sql = "select NOMBRE from TIPOINMUEBLE where MANTENIMIENTO > 0";

	List<String> lista;
	lista = jdbcTemplate.queryForList(sql, String.class);

	    return lista;
	    
	  }
	  
	// CONSULTAR LOS MOVIMIENTOS DE TIPO INGRESOS
	  
	public List<Map<String,Object>> consultarMovimiento(String inmueble){
		    
	String sql = " select tm.NOMBRE, (p.NOMBRE + ' ' + p.APELLIDO) AS NOMBRECOMPLETO, m.OBLIGACION, "
		    	+ " i.DESCRIPCION, m.IMPORTE, m.FECHA from MOVIMIENTO m "
		    	+ " inner join TIPOMOVIMIENTO tm on tm.TIPOMOVIMIENTO = m.TIPOMOVIMIENTO "
		    	+ " inner join PERSONA p on p.PERSONA = m.PERSONA "
		    	+ " inner join INMUEBLE i on i.INMUEBLE = m.INMUEBLE " 
		    	+ " inner join TIPOINMUEBLE ti on ti.TIPOINMUEBLE = i.TIPOINMUEBLE "
		    	+ " inner join OBLIGACION o on o.OBLIGACION = m.OBLIGACION "
		    	+ " inner join TIPOOBLIGACION tob on o.TIPOOBLIGACION = tob.TIPOOBLIGACION and tob.TIPOOBLIGACION = 2 " 
		    	+ " where tm.NOMBRE = 'INGRESO' and ti.NOMBRE = ? ";
		    
	List<Map<String,Object>> lista;
	lista = jdbcTemplate.queryForList(sql, inmueble);
	    
	   return lista;
		    
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
	
	// CONSULTA QUE TRAE LOS TIPOS DE PERSONA
	  
	  public List<String> leerTipoPersona() {

	    String sql = "select NOMBRE from TIPOPERSONA";

	    List<String> lista;
	    lista = jdbcTemplate.queryForList(sql, String.class);

	    return lista;
	    
	  }
	 
	// CONSULTA QUE TRAE LOS TIPOS DE USUARIOS
	  
	  public List<String> leerTipoUsuario() {

		 String sql = "select NOMBRE from ROL";

		 List<String> lista;
		 lista = jdbcTemplate.queryForList(sql, String.class);

		 return lista;
		    
	  }
	  
	// LLAMA AL PROCEMIENTO ALMACENADO QUE REGISTRA USUARIOS
		
		public void creaUsuario(String nombre, String apellidos, String dni, String telefono, String direccion,
								String email, String tipopersona, String tipousuario, String usuario, 
								String clave){
		
		Object[] args = {nombre, apellidos, dni, telefono, direccion, email, tipopersona, tipousuario, usuario, 
						clave};
		String sql = "{call usp_creausuario(?,?,?,?,?,?,?,?,?,?)}";
		args = new Object[]{
				nombre, 
				apellidos, 
				dni, 
				telefono, 
				direccion, 
				email, 
				tipopersona, 
				tipousuario, 
				usuario, 
				clave
			};
			jdbcTemplate.update(sql, args);
		}
		
	// CONSULTAR LOS USUARIOS SEGÚN EL TIPO DE USUARIO
		  
	public List<Map<String,Object>> consultarUsuario(String tipousuario){
			    
	String sql = " select TP.NOMBRE TIPOPERSONA, P.NOMBRE, P.APELLIDO, R.NOMBRE TIPOUSUARIO, U.USUARIO, U.CLAVE "
		    	+ " from PERSONA P "
		    	+ " inner join TIPOPERSONA TP ON P.TIPOPERSONA = TP.TIPOPERSONA "
		    	+ " inner join USUARIO U ON U.PERSONA = P.PERSONA "
		    	+ " inner join ROL R ON U.ROL = R.ROL " 
		    	+ " where U.ESTADO = 1 AND R.NOMBRE = ? ";
			    
	List<Map<String,Object>> lista;
	lista = jdbcTemplate.queryForList(sql, tipousuario);
		    
	   return lista;
		    
	}
	
	
	
	
}
