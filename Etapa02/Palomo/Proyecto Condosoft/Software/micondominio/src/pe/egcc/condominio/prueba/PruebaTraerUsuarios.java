package pe.egcc.condominio.prueba;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.service.UsuarioService;
import pe.egcc.condominio.service.personaService;

public class PruebaTraerUsuarios {
	public static void main(String[] args) {
		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		UsuarioService service;
	    service = beanFactory.getBean(UsuarioService.class);
	    
	 
	    List<Map<String,Object>> lista;
	    lista = service.traerUsuario();
	    
	    for (Map<String, Object>r: lista) {
		      System.out.println(r.get("idpersona")
		          + " - " + r.get("nombre")
		          + " - " + r.get("usuario")
		          + " - " + r.get("apellido")
		          + " - " + r.get("nomrol"));
		    }

	}
}
