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
import pe.egcc.app.model.Persona;
import pe.egcc.app.service.LogonService;
import pe.egcc.app.service.CondoService;

@Controller
public class AppController {
	
	@Autowired 
	private LogonService logonService;
	@Autowired
	private CondoService condoService;

	// MAPEA EL INDEX
	
	@RequestMapping(value="index.htm", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	// MAPEA PÁGINA DE NUEVO USUARIO
	
	@RequestMapping(value="nuevousu.htm", method=RequestMethod.GET)
	public String nuevousu(Model model){
		
		List<String> tpersonas = condoService.leerTipoPersona();
		List<String> tusuarios = condoService.leerTipoUsuario();
	    
	    model.addAttribute("tpersonas", tpersonas);
	    model.addAttribute("tusuarios", tusuarios);
		
	    return "nuevousu";
	}
	
	// MAPEA LA PÁGINA DE REGISTRO DE PAGOS
	
	@RequestMapping(value="registro.htm", method=RequestMethod.GET)
	public String registro(){
		return "registro";
	}
	
	// MAPEA LA PÁGINA DE MOVIMIENTOS
	
	@RequestMapping(value="consult.htm", method=RequestMethod.GET)
	  public String consult(Model model){
	    
	    List<String> inmuebles = condoService.leerInmueble();
	    
	    model.addAttribute("inmuebles", inmuebles);
	    
	    return "consult";
	  }
	
	// MAPEA LA PÁGINA DE MOVIMIENTOS
	
	@RequestMapping(value="listausu.htm", method=RequestMethod.GET)
	  public String listausu(Model model){
		    
	    List<String> tusuarios = condoService.leerTipoUsuario();
		    
	    model.addAttribute("tusuarios", tusuarios);
	    
	    return "listausu";
	  }
	
	// VALIDACIÓN DEL LOGIN
	
	@RequestMapping(value="ingresar.htm", method=RequestMethod.POST)
	  public String ingresar(
	      @RequestParam("usuario") String usuario, 
	      @RequestParam("clave") String clave,
	      Model model,
	      HttpSession session){
	    
	    String destino;
	    
	    try {
	      
	      Persona bean = logonService.validar(usuario, clave);
	      
	      session.setAttribute("usuario", bean);
	      destino = "main";
	      
	    } catch (Exception e) {
	    
	      model.addAttribute("error", e.getMessage());
	      destino = "index";
	    }
	    
	    return destino;
	  }
	
	// OPCIÓN DE CERRAR SESIÓN
	
	@RequestMapping(value="salir.htm", method=RequestMethod.GET)
	  public String salir(HttpSession session){
		  session.invalidate();
		  return "index";
	  }
	
	// MAPEA EL MAIN
	
	@RequestMapping(value="main.htm", method=RequestMethod.GET)
	  public String main(){
		  return "main";
	  }
	  
	 
	// REGISTRO DE PAGOS 
	  
	@RequestMapping(value="registra.htm", 
		      method=RequestMethod.POST)
		  public @ResponseBody String registra(
			  @RequestParam("dni") String dni,
		      @RequestParam("obligacion") String obligacion,
		  	  @RequestParam("descripcion") String descripcion){
		  String destino;
		  try {
		   condoService.creaMovimiento(dni, obligacion, descripcion);
		   destino = "Registrado correctamente";
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		   destino = "error en el registro";
		  }
		  return destino;
		}
	  
	  
	// CONSULTA DE MOVIMIENTOS
	  
	@RequestMapping(value="consultar.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultar(
	      @RequestParam("inmueble") String inmueble){
	    
	    List<Map<String,Object>> consultarMovimiento; 
	    consultarMovimiento = condoService.consultarMovimiento(inmueble);
	    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(consultarMovimiento);
	    
	    return textJson;
	  }
	
	// CONSULTA USUARIOS
	  
	@RequestMapping(value="consultarUsuario.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarUsuario(
	      @RequestParam("tipousuario") String tipousuario){
		    
	    List<Map<String,Object>> consultarUsuario; 
	    consultarUsuario = condoService.consultarUsuario(tipousuario);
		    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(consultarUsuario);
	    
	    return textJson;
	  }
	  
	// CONSULTA DE OBLIGACIONES
	  
	@RequestMapping(value="consultarObli.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarObli(
	      @RequestParam("dni") String dni){
		    
	    List<Map<String,Object>> buscaObligacion; 
	    buscaObligacion = condoService.buscaObligacion(dni);
		    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(buscaObligacion);
		    
	    return textJson;
	  }
	  
	// CONSULTA DE INMUEBLES
	  
	@RequestMapping(value="consultarInmueble.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarInmueble(
	      @RequestParam("obligacion") String obligacion){
			    
	    List<Map<String,Object>> buscaInmueble; 
	    buscaInmueble = condoService.buscaInmueble(obligacion);
			    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(buscaInmueble);
			    
	    return textJson;
	  }
	  
	// CONSULTA DE IMPORTES
	  
	@RequestMapping(value="consultarImporte.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarImporte(
	      @RequestParam("obligacion") String obligacion){
				    
	    List<Map<String,Object>> buscaImporte; 
	    buscaImporte = condoService.buscaImporte(obligacion);
				    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(buscaImporte);
				    
	    return textJson;
	  }
	  
	// CONSULTA DE FECHA DE INICIO
	  
	@RequestMapping(value="consultarFechaI.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarFechaI(
	      @RequestParam("obligacion") String obligacion){
				    
	    List<Map<String,Object>> buscaFechaI; 
	    buscaFechaI = condoService.buscaFechaI(obligacion);
					    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(buscaFechaI);
					    
	    return textJson;
	  }
	  
	// CONSULTA DE FECHA DE INICIO
	  
	@RequestMapping(value="consultarFechaF.htm", method=RequestMethod.POST, produces="application/json")
	  public @ResponseBody String consultarFechaF(
	      @RequestParam("obligacion") String obligacion){
					    
	    List<Map<String,Object>> buscaFechaF; 
	    buscaFechaF = condoService.buscaFechaF(obligacion);
						    
	    Gson gson  = new Gson();
	    String textJson = gson.toJson(buscaFechaF);
						    
	    return textJson;
	  }
	
	// REGISTRO DE USUARIOS 
	  
	@RequestMapping(value="registraUsuario.htm", 
			      method=RequestMethod.POST)
		  public @ResponseBody String registraUsuario(
			  @RequestParam("nombre") String nombre,
		      @RequestParam("apellidos") String apellidos,
		  	  @RequestParam("dni") String dni,
		  	  @RequestParam("telefono") String telefono,
		      @RequestParam("direccion") String direccion,
		  	  @RequestParam("email") String email,
		  	  @RequestParam("tipopersona") String tipopersona,
		      @RequestParam("tipousuario") String tipousuario,
		  	  @RequestParam("usuario") String usuario,
		  	  @RequestParam("clave") String clave){
			  String destino;
			  try {
			   condoService.creaUsuario(nombre, apellidos, dni, telefono, direccion, email, 
					   					tipopersona, tipousuario, usuario, clave);
			   destino = "Registrado correctamente";
			  }
			  catch(Exception e) {
			   e.printStackTrace();
			   destino = "error en el registro";
			  }
			  return destino;
			}
}
