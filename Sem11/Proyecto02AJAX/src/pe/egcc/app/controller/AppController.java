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

import pe.egcc.app.service.AppService;

@Controller
public class AppController {
  
  @Autowired
  private AppService appService;

  @RequestMapping(value="index.htm", method=RequestMethod.GET)
  public String index(Model model){
    
    List<String> periodos = appService.leerPeriodos();
    
    model.addAttribute("periodos", periodos);
    
    return "index";
  }
  
  
  @RequestMapping(value="consultar.htm", method=RequestMethod.POST, produces="application/json")
  public @ResponseBody String consulta(
      @RequestParam("periodo") String periodo){
    
    List<Map<String,Object>> mejoresCursos; 
    mejoresCursos = appService.leerMejoresCursos(periodo);
    
    Gson gson  = new Gson();
    String textJson = gson.toJson(mejoresCursos);
    
    return textJson;
  }
  
  
  
}
