package pe.egcc.condominio.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.service.LoginService;
@Controller
public class AppLoginController {

	 @Autowired
	  private LoginService loginService;
	
	@RequestMapping(value="index.htm", method=RequestMethod.GET)
	  public String index(){
	    return "index";
	  }
	  
	  @RequestMapping(value="ingresar.htm", method=RequestMethod.POST)
	  public String ingresar(
	      @RequestParam("usuario") String usuario,
	      @RequestParam("clave") String clave,
	      HttpSession session,
	      Model model
	      ){
	    
	    String destino;
	    
	    try {

	    	
	      PersonaModel bean = loginService.validar(usuario, clave);
	      session.setAttribute("usuario", bean);
	      destino = "main";
	    } catch (Exception e) {
	      model.addAttribute("error", e.getMessage());
	      destino = "index";
	    }
	    
	    return destino;
	    
	  }
	  
	  @RequestMapping(value="salir.htm", method=RequestMethod.GET)
	  public String salir(
	      HttpSession session
	      ){
	    
	    session.invalidate();
	    
	    return "index";
	    
	  }
	
}
