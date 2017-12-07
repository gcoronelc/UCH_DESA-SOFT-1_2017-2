package pe.egcc.condominio.prueba;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.service.InmuebleService;
import pe.egcc.condominio.service.personaService;

public class PruebainmubleTraerLista {
	public static void main(String[] args) {
		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		InmuebleService service;
	    service = beanFactory.getBean(InmuebleService.class);
	    
	 
	    List<Map<String,Object>> lista;
	    lista = service.traerInmbuebles();
	    
	    for (Map<String, Object>r: lista) {
		      System.out.println(r.get("idinmueble") 
			          + " | " + r.get("nomtinmueble")
			          + " | " + r.get("nomtorre")
		          + " | " + r.get("piso")
		          + " | " + r.get("numero")
		          + " | " + r.get("descripcion")
		          + " | " + r.get("activo")
		          + " | " + r.get("nombre")
		          + " | " + r.get("apellido")
		          + " | " + r.get("agua")
		          + " | " + r.get("mante")
		          + " | " + r.get("cmante"));
		    }
	}
}
