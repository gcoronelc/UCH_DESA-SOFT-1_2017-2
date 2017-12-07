package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.service.personaService;

public class PruebaEliminarPersona {
	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		personaService service;		
		
		try {
			service = beanFactory.getBean(personaService.class);
			PersonaModel bean = new PersonaModel();						
			bean.setIdpersona(11);	
			service.eliminarPropietario(bean);
			System.out.println("Actualizacion Ok");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
