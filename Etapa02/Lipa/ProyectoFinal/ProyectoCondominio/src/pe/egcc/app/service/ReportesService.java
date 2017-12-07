package pe.egcc.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReportesService extends AbstractDBSupport{
	

	//Reporte Cuenta Inmuebles

	  public List<String> leerInmuebles() {

	    String sql = "SELECT NOMBRE inmuebles FROM dbo.TIPOINMUEBLE where TIPOINMUEBLE in (2,3,4,5)";

	    List<String> lista;
	    lista = jdbcTemplate.queryForList(sql, String.class);

	    return lista;
	    
	  }
	  
	  public List<Map<String,Object>> leerReporteInmueble(String inmueble){
	    
	    String sql = "select INMUEBLE,TORRE,PISO,CODIGO,PROPIETARIO,MES,PAGO,DESCRIPCION,FECHA,ESTADO"
	        + " from dbo.cuentaInmueble WHERE INMUEBLE = ? "
	    	+ "ORDER BY 2,9,5";
	    
	    List<Map<String,Object>> lista;
	    lista = jdbcTemplate.queryForList(sql, inmueble);
	    
	    return lista;
	    
	  }
	  
	//Reporte Cuenta Propietario
	  
	  public List<Map<String,Object>> leerReportePropietario(String propietario){
		    
		    String sql = "select PROPIETARIO,ANIO,MES,DESCRIPCION,SALDO,"
		        + "ESTADO from dbo.cuentaPropietario "
		        + "where DNI = ? ORDER BY FECHA ";
		    
		    List<Map<String,Object>> lista;
		    lista = jdbcTemplate.queryForList(sql, propietario);
		    
		    return lista;
		    
	  }
	  
	 //Reporte Mensual
	  
	  public List<Map<String,Object>> leerReporteMensual(String mes){
		    
		    String sql = "SELECT CONTROL,FECHAPAGO,IMPORTE,INMUEBLE,PERSONA,DESCRIPCION " + 
		    		"FROM dbo.reporteMensual WHERE MES=? "+
		    		"ORDER BY 5,2,6 ,4";
		    
		    List<Map<String,Object>> lista;
		    lista = jdbcTemplate.queryForList(sql, mes);
		    
		    return lista;
		    
	  }
	  
	  //Estado Financiero
	  public List<String> leerTorres() {

		    String sql = "SELECT NOMBRE FROM dbo.TORRE";

		    List<String> lista;
		    lista = jdbcTemplate.queryForList(sql, String.class);

		    return lista;
		    
		  }
		  
	  public List<Map<String,Object>> leerEstadoFinanciero(String torre){
		    
		    String sql = "SELECT TORRE,PISO,CONTROL,FECHAPAGO,IMPORTE,INMUEBLE,PERSONA,DESCRIPCION,ESTADO " + 
		    		"FROM dbo.estadoFinanciero WHERE TORRE=? "+
		    		"ORDER BY 1,4,6,7,2";
		    
		    List<Map<String,Object>> lista;
		    lista = jdbcTemplate.queryForList(sql, torre);
		    
		    return lista;
		    
		  }	  


}
