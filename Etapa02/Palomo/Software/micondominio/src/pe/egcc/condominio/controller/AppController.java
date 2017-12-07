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
public class AppController {

 
  
  @RequestMapping(value="main.htm", method=RequestMethod.GET)
  public String main(HttpSession session){
    
    String destino;
    
    if(session.getAttribute("usuario") == null){
      destino = "index";
    } else {
      destino = "main";
    }
    
    return destino;   
  }
   
  
  
  @RequestMapping(value="registroPro.htm", method=RequestMethod.GET)
  public String registroPropietario(){  
    String destino;
      destino = "mantPropietario";
      return destino;
  }
 
  
  
  
}
