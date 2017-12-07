package pe.egcc.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.egcc.app.service.ReportesService;

@Controller
public class ReportesController {

	  @Autowired
	  private ReportesService reportesService;
	  
	// Reporte Cuenta Inmuebles

	  @RequestMapping(value="reporteCuentaInmueble.htm", method=RequestMethod.GET)
	  public String reporteCuentaInmueble(Model model){
	    
	    List<String> inmuebles = reportesService.leerInmuebles();
	    
	    model.addAttribute("inmuebles", inmuebles);
	    
	    return "reporteCuentaInmueble";
	  }
	  
	  
	  @RequestMapping(value="consultarCuentaInmueble.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarCuentaInmueble(
	      @RequestParam("inmueble") String inmueble){
	    
	    List<Map<String,Object>> cuentaInmueble; 
	    cuentaInmueble = reportesService.leerReporteInmueble(inmueble);
	    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(cuentaInmueble);    
	    return textJson;
	  }
	  
	 // Reporte Cuenta Propietario
	  
	  @RequestMapping(value="reporteCuentaPropietario.htm", method=RequestMethod.GET)
	  public String reporteCuentaPropietario(){
	    
	    return "reporteCuentaPropietario";
	  }
	  
	  @RequestMapping(value="consultarCuentaPropietario.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarCuentaPropietario(
	      @RequestParam("propietario") String propietario){
	    
	    List<Map<String,Object>> cuentaPropietario; 
	    cuentaPropietario = reportesService.leerReportePropietario(propietario);
	    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(cuentaPropietario);    
	    return textJson;
	  }	  
	  
	 // Reporte Mensual
	  
	  @RequestMapping(value="reporteMensual.htm", method=RequestMethod.GET)
	  public String reporteMensual(){
	    
	    return "reporteMensual";
	  }
	  
	  @RequestMapping(value="consultarReporteMensual.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarReporteMensual(
	      @RequestParam("mes") String mes){
	    
	    List<Map<String,Object>> reporteMensual; 
	    reporteMensual = reportesService.leerReporteMensual(mes);
	    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(reporteMensual);    
	    return textJson;
	  }	  
	  
	 // Estado Financiero 
	  
	  @RequestMapping(value="reporteEstadoFinanciero.htm", method=RequestMethod.GET)
	  public String reporteEstadoFinanciero(Model model){
	    
	    List<String> torres = reportesService.leerTorres();
	    
	    model.addAttribute("torres", torres);
	    
	    return "reporteEstadoFinanciero";
	  }
	  
	  
	  @RequestMapping(value="consultarEstadoFinanciero.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarEstadoFinanciero(
	      @RequestParam("torre") String torre){
	    
	    List<Map<String,Object>> cuentaTorre; 
	    cuentaTorre = reportesService.leerEstadoFinanciero(torre);
	    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(cuentaTorre);    
	    return textJson;
	  }	  

}
