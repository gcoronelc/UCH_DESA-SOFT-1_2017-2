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
import pe.egcc.condominio.model.UsuarioModel;
import pe.egcc.condominio.service.UsuarioService;

@Controller
public class AppUsuarioController {

	@Autowired
	UsuarioService service;
	
	@RequestMapping(value="usuario.htm",method=RequestMethod.GET)
	public String usuario(){
		
		return "mantUsuario";
	}
	
	@RequestMapping(value="nuevoUsuario.htm", method=RequestMethod.GET)
	public String nuevoUsuario(){
		return "nuevoUsuario";
	}
	
	@RequestMapping(value="verUsuario.htm", method=RequestMethod.POST)
	public String verUsuarios(Model model){
		List<Map<String, Object>> lista;
	    lista = service.traerUsuario();
	    model.addAttribute("lista", lista);
		return "mantUsuario";
	}
	
	
	@RequestMapping(value="registraUsuario.htm",method=RequestMethod.POST)
	public String registrarPropietario(
			@RequestParam("persona") int persona,
			 @RequestParam("usuario") String usuario,
			 @RequestParam("clave") String clave,
			 @RequestParam("rol") int idrol,
			 Model model){

		try {
			UsuarioModel bean = new UsuarioModel();
			bean.setIdpersona(persona);	
			bean.setUsuario(usuario);
			bean.setClave(clave);
			bean.setIdrol(idrol);
			service.insertarUsuario(bean);
			model.addAttribute("mensaje", "Usuario Registrado");
		}catch(Exception e){
			model.addAttribute("mensaje", "Error");
		}
		return "mantUsuario";
	}
	
}
