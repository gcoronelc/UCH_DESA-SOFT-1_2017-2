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

import pe.egcc.app.service.AlquilerService;

@Controller
public class AlquilerController {
	
	@Autowired 
	private AlquilerService alquilerService;

	// MAPEA PÁGINA DE REGISTRO DE ALQUILER
	
	@RequestMapping(value="registroAlquiler.htm", method=RequestMethod.GET)
	public String registroAlquiler(Model model){
		
		List<String> auditorios = alquilerService.leeAuditorio();
	    
	    model.addAttribute("auditorios", auditorios);
		
	    return "registroAlquiler";
	}
	
	// CONSULTA DE INMUEBLES
	  
	@RequestMapping(value="consultaTorre.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarTorre(
	      @RequestParam("auditorio") String auditorio){
			    
	    List<Map<String,Object>> buscaTorre; 
	    buscaTorre = alquilerService.buscaTorre(auditorio);
			    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(buscaTorre);
			    
	    return textJson;
	  }
	  
	// CONSULTA DE IMPORTES
	  
	@RequestMapping(value="consultaPiso.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarPiso(
	      @RequestParam("auditorio") String auditorio){
				    
	    List<Map<String,Object>> buscaPiso; 
	    buscaPiso = alquilerService.buscaPiso(auditorio);
				    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(buscaPiso);
				    
	    return textJson;
	  }
	
	

}
