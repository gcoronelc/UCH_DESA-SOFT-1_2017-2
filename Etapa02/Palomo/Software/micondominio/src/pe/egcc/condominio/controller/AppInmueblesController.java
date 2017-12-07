package pe.egcc.condominio.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.condominio.model.InmuebleModel;
import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.service.InmuebleService;

@Controller
public class AppInmueblesController {
	@Autowired
	InmuebleService service;

	
	
	@RequestMapping(value = "verPropiedades.htm", method = RequestMethod.GET)
	public String mispropiedades(@RequestParam("idpersona") int idpersona,HttpSession session,Model model) 
	{
		try {
			List<Map<String, Object>> lista;
			lista=service.traerInmueblePropietario(idpersona);
			session.setAttribute("lista", lista);
			session.setAttribute("idpersona", idpersona);
			
		} catch (Exception e) {
			model.addAttribute("error", "No tiene propiedades");
		}
		return "listaPropiedades";
	}
	
	@RequestMapping(value="mantInmueble.htm",method=RequestMethod.GET)
	public String mantInmueble(){
		return "mantInmueble";
	}
	
	@RequestMapping(value="nuevoInmueble.htm",method=RequestMethod.GET)
	public String nuevoInmueble(){
		return "nuevoInmueble";
	}

	
	@RequestMapping(value="verInmueble.htm",method=RequestMethod.GET)
	public String verInmueble(Model model){		
		List<Map<String, Object>> lista;
		lista=service.traerInmbuebles();
		model.addAttribute("lista",lista);
		
		return "mantInmueble";
	}
	
	@RequestMapping(value="registraInmueble.htm",method=RequestMethod.POST)
	public String registrarPropietario(
			@RequestParam("piso") int piso,
			 @RequestParam("numero") int numero,
			 @RequestParam("descripcion") String descripcion,
			 @RequestParam("cbopropietario") int idpersona,
			 @RequestParam("cbotinmueble") int idinmueble,
			 @RequestParam("cbotorre") int idtorre,
			 Model model){

		try {
			InmuebleModel bean=new InmuebleModel();
			bean.setPiso(piso);
			bean.setNumero(numero);
			bean.setDescripcion(descripcion);
			bean.setIdpersona(idpersona);
			bean.setIdinmueble(idinmueble);
			bean.setIdtorre(idtorre);
			service.insertarInmueble(bean);
			model.addAttribute("mensaje", "Inmueble Registrado");
		}catch(Exception e){
			model.addAttribute("mensaje", "Error");
		}
		return "mantInmueble";
	}
	
	
	
}
