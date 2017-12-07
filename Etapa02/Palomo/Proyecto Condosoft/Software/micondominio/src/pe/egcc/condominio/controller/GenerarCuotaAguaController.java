package pe.egcc.condominio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenerarCuotaAguaController {

	@RequestMapping(value="verCoutaAgua.htm", method=RequestMethod.GET)
	public String vercoutaAgua(){
		return "mantCuotaAgua";
	}
	@RequestMapping(value="registrarCoutaAgua.htm", method=RequestMethod.GET)
	public String verRecibo(){
		return "recibo";
	}
}
