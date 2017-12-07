package pe.egcc.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlquilerService extends AbstractDBSupport {
	@Transactional(propagation=Propagation.REQUIRES_NEW,
		      rollbackFor=Exception.class)
	
	// LEE LAS TORRES
	  
		public List<String> leeAuditorio() {

		String sql = "SELECT distinct  i.CODIGO FROM INMUEBLE i " + 
				"inner join TIPOINMUEBLE ti ON ti.TIPOINMUEBLE=i.TIPOINMUEBLE " + 
				"where ti.NOMBRE = 'AUDITORIO' " + 
				"group by i.CODIGO " + 
				"having sum(ACTIVO)=0";

		List<String> lista;
		lista = jdbcTemplate.queryForList(sql, String.class);

		    return lista;
		    
	 }
	
	// CONSULTA QUE BUSCA LA TORRE
	
	public List<Map<String,Object>> buscaTorre(String auditorio){
		    
		String sql = "SELECT distinct T.NOMBRE TORRE FROM INMUEBLE i " + 
				"inner join TIPOINMUEBLE ti ON ti.TIPOINMUEBLE=i.TIPOINMUEBLE " + 
				"inner join PISO p ON p.PISO = i.PISO " + 
				"inner join TORRE t ON t.TORRE = p.TORRE " + 
				"where ti.NOMBRE = 'AUDITORIO' and i.CODIGO = ? " + 
				"group by T.NOMBRE " + 
				"having sum(ACTIVO)=0";
			    
	List<Map<String,Object>> lista;
	lista = jdbcTemplate.queryForList(sql, auditorio);
			    
	   return lista;
			    
	}	
	
	// CONSULTA QUE BUSCA EL PISO
	
	public List<Map<String,Object>> buscaPiso(String auditorio){
			    
		String sql = "SELECT distinct p.DESCRIPCION PISO FROM INMUEBLE i " + 
				"inner join TIPOINMUEBLE ti ON ti.TIPOINMUEBLE=i.TIPOINMUEBLE " + 
				"inner join PISO p ON p.PISO = i.PISO " + 
				"inner join TORRE t ON t.TORRE = p.TORRE " + 
				"where ti.NOMBRE = 'AUDITORIO' and i.CODIGO = ? " + 
				"group by p.DESCRIPCION " + 
				"having sum(ACTIVO)=0";
				    
	List<Map<String,Object>> lista;
	lista = jdbcTemplate.queryForList(sql, auditorio);
				    
	   return lista;
			    
	}

}
