package pe.egcc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.egcc.app.model.VentaModel;
import pe.egcc.app.service.VentaService;

@Controller
public class AppController {
	
	@Autowired
	private VentaService ventaService;

	
	@RequestMapping(value="index.egcc", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	
	@RequestMapping(value="procesar.egcc", method=RequestMethod.POST)
	public String procesar(
			@ModelAttribute VentaModel ventaModel, 
			Model model){
		
		ventaModel = ventaService.procesar(ventaModel);
		model.addAttribute("panchito", ventaModel);
		
		return "index";
	}
	
	
}
