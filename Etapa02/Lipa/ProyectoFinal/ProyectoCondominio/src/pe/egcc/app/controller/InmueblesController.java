package pe.egcc.app.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import pe.egcc.app.service.InmueblesService;

@Controller
public class InmueblesController {
	
	@Autowired 
	private InmueblesService inmueblesService;
	
	// MAPEA PÁGINA DE REGISTRO DE INMUEBLES
	
	@RequestMapping(value="registraInmueble.htm", method=RequestMethod.GET)
	public String registraInmueble(Model model){
		
		List<String> torres = inmueblesService.leeTorre();
		List<String> tipoinmuebles = inmueblesService.leeTipoInmueble();
	    
	    model.addAttribute("torres", torres);
	    model.addAttribute("tipoinmuebles", tipoinmuebles);
		
	    return "registraInmueble";
	}
	
	// CONSULTA DE PISOS EN BASE A LA TORRE
	  
	@RequestMapping(value="consultarPiso.htm", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody String consultarPiso(
		@RequestParam("torre") String torre){
			    
	    List<Map<String,Object>> buscaPiso; 
	    buscaPiso = inmueblesService.buscaPiso(torre);
			    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(buscaPiso);
			    
	    return textJson;
	}
	
	// REGISTRO DE INMUEBLES
	  
	@RequestMapping(value="guardaInmueble.htm", 
	      method=RequestMethod.POST)
	public @ResponseBody String registra(
		  @RequestParam("tipoinmueble") String tipoinmueble,
	      @RequestParam("dni") String dni,
	  	  @RequestParam("piso") String piso,
	  	  @RequestParam("descripcion") String descripcion){
	  String destino;
	  try {
		   inmueblesService.guardaInmueble(tipoinmueble, dni, piso, descripcion);;
		   destino = "Inmueble registrado correctamente";
	  }
	  catch(Exception e) {
		   e.printStackTrace();
		   destino = "error en el registro";
	  }
	  return destino;
	}
	
	// REGISTRO DE MANTENIMIENTO
	
	@RequestMapping(value="registraManteInmueble.htm", method=RequestMethod.GET)
	public String registraManteInmueble(){
		return "registraManteInmueble";
	}
	  
	  @RequestMapping(value="registraMante.htm", 
		      method=RequestMethod.POST)
		  public @ResponseBody String registraMante(
			  @RequestParam("dni") String dni,
		      @RequestParam("obligacion") String obligacion,
		  	  @RequestParam("descripcion") String descripcion){
		  String destino;
		  try {
		   inmueblesService.creaMovimiento(dni, obligacion, descripcion);
		   destino = "Registrado correctamente";
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		   destino = "error en el registro";
		  }
		  return destino;
		}
}