package pe.egcc.condominio.prueba;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.service.personaService;

public class Prueba03 {
	public static void main(String[] args) {
		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		personaService service;
	    service = beanFactory.getBean(personaService.class);
	    
	 
	    List<Map<String,Object>> lista;
	    lista = service.traerPersonas();
	    
	    for (Map<String, Object>r: lista) {
		      System.out.println(r.get("idpersona")
		          + " - " + r.get("nombre")
		          + " - " + r.get("apellido")
		          + " - " + r.get("dni")
		          + " - " + r.get("email"));
		    }

	}
}
