package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.service.personaService;


public class PruebaInsertarPropietario {
	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		personaService service;
	    service = beanFactory.getBean(personaService.class);


		try {
		    service = beanFactory.getBean(personaService.class);
			PersonaModel bean = new PersonaModel();
			//bean.setIdtpersona(2);
			bean.setApellido("ccama condori");
			bean.setNombre("fredy");
			bean.setDni("98261738");
			bean.setEmail("fredy@gmail.com");
			bean.setTelefono("987654321");
			bean.setDireccion("los alisos");
			service.insertarPropietario(bean);
			System.out.println("Registro ok!!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.out.println("alv :V");
		}

	}
}

