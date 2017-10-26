package pe.egcc.app.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.app.service.CursoService;

@Controller
public class AppController {

  @Autowired
  private CursoService cursoService;
  
  @RequestMapping(value = "index.htm", method = RequestMethod.GET)
  public String index(){
    return "index";
  }
  
  
  @RequestMapping(value = "consultar.htm", method = RequestMethod.POST)
  public String consultar(
          @RequestParam("ciclo") String ciclo,
          Model model){
    
    // Proceso
    List<Map<String,Object>> lista;
    lista = cursoService.conResumenCurso(ciclo);
    
    // Reporte
    if(lista.isEmpty()){
      model.addAttribute("mensaje", "No existe la cuenta " + ciclo + ".");
    }else{
      model.addAttribute("lista", lista);
    }
    
    return "index";
  }
  
  
  
}
