package pe.egcc.condominio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.service.personaService;

@Controller
public class AppPersonaController {
@Autowired
personaService service;


	@RequestMapping(value="verPropietario.htm", method=RequestMethod.POST)
	public String verPropietario(Model model){
		List<Map<String, Object>> lista;
	    lista = service.traerPersonas();
	    model.addAttribute("lista", lista);
		return "mantPropietario";
	}
	
	@RequestMapping(value="nuevo.htm",method=RequestMethod.GET)
	public String nuevo(){
		return "nuevoPropietario";
	}
	
	@RequestMapping(value="registra.htm",method=RequestMethod.POST)
	public String registrarPropietario(
			@RequestParam("apellido") String ape,
			 @RequestParam("nombre") String nom,
			 @RequestParam("dni") String dni,
			 @RequestParam("email") String mail,
			 @RequestParam("telefono") String tel,
			 @RequestParam("direccion") String dir,
			 Model model){

		try {
			PersonaModel bean = new PersonaModel();
			bean.setApellido(ape);
			bean.setNombre(nom);
			bean.setDni(dni);
			bean.setEmail(mail);
			bean.setTelefono(tel);
			bean.setDireccion(dir);
			service.insertarPropietario(bean);
			model.addAttribute("mensaje", "Propietario Registrado");
		}catch(Exception e){
			model.addAttribute("mensaje", "Error");
		}
		return "mantPropietario";
	}
	
}
