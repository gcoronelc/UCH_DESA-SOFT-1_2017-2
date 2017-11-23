package pe.egcc.condominio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.egcc.condominio.model.Estado;
import pe.egcc.condominio.model.Obligacion;
import pe.egcc.condominio.model.Persona;
import pe.egcc.condominio.service.CondoService;

@Controller
public class CondoController {
  
  @Autowired
  private CondoService condoService;
  
  
  
  	@RequestMapping(value="grabarObliMant.htm", 
  			method=RequestMethod.POST, produces="application/json")
	public @ResponseBody String grabarObliMant(
			@RequestParam("periodo") Integer periodo,
			@RequestParam("mes") Integer mes,
			@RequestParam("tipo") Integer tipo,
			HttpSession session
			){
  		
  		Estado estado = new Estado();
  		
  		try {
  			
  			Persona  persona = (Persona) session.getAttribute("usuario");
  			
  			condoService.creaCuotaMant(periodo, mes, persona.getIdpersona());
  			
  			estado.setCode(1);
  			estado.setMensaje("Proceso ejecutado correctamente.");
  			
		} catch (Exception e) {
			estado.setCode(-1);
  			estado.setMensaje("Error en el proceso");
		}
  		
  		Gson gson = new Gson();
  		String txtJson = gson.toJson(estado);
  		
		return  txtJson;
	}

	@RequestMapping(value="obliMantenimiento.htm", method=RequestMethod.GET)
	public String obliMantenimiento(){
		return "obliMantenimiento";
	}
	
	
	@RequestMapping(value="leerObligaciones.htm", 
	    method=RequestMethod.POST, 
	    produces="application/json")
  public @ResponseBody String leerObligaciones(
      @RequestParam("periodo") Integer periodo,
      @RequestParam("mes") Integer mes,
      @RequestParam("tipo") Integer tipo){
    
	  List<Obligacion> lista = condoService
	      .leerObligaciones(periodo, mes, tipo);
	  
	  Gson gson = new Gson();
	  String textJson = gson.toJson(lista);
    
    return textJson;
  }
  
	@RequestMapping(value="generaObligaciones.htm", 
      method=RequestMethod.POST, 
      produces="application/json")
  public @ResponseBody String generaObligaciones(
      @RequestParam("periodo") Integer periodo,
      @RequestParam("mes") Integer mes,
      @RequestParam("tipo") Integer tipo){
    
    List<Obligacion> lista = condoService
        .generaCuotaMant(periodo, mes);
    
    Gson gson = new Gson();
    String textJson = gson.toJson(lista);
    
    return textJson;
  }
	
  
	
}
