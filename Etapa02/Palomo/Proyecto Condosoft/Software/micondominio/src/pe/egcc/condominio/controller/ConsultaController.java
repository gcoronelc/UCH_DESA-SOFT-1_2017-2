package pe.egcc.condominio.controller;

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

import pe.egcc.condominio.service.MoviService;

@Controller
public class ConsultaController {
	
	  @Autowired
	  private MoviService moviService;

	  @RequestMapping(value="consutarM.htm", method=RequestMethod.GET)
	  public String consutarM(Model model){
	    
	    List<String> inmuebles = moviService.leerInmueble();
	    
	    model.addAttribute("inmuebles", inmuebles);
	    
	    return "consutarM";
	  }
	  
	  
	  @RequestMapping(value="consultarMovimiento.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consulta(
	      @RequestParam("inmueble") String inmueble){
	    
	    List<Map<String,Object>> consultaMov; 
	    consultaMov = moviService.leerMovimiento(inmueble);
	    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(consultaMov);    
	    return textJson;
	  }
	  
	  

}
