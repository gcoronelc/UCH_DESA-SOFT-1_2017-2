package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.service.personaService;

public class PruebaActualizarPropietario {

	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		personaService service;
		
		String apellido="ccama";
		String nombre="fredy";
		String dni="70780371";
		String email="fredy@gmail.com";
		String telefono="986612884";
		String direccion="los alisos";
		
		try {
			service = beanFactory.getBean(personaService.class);
			PersonaModel bean = new PersonaModel();					
			bean.setApellido(apellido);
			bean.setNombre(nombre);
			bean.setDni(dni);
			bean.setEmail(email);
			bean.setTelefono(telefono);
			bean.setDireccion(direccion);	
			bean.setIdpersona(11);	
			service.actualizarPropietario(bean);
			System.out.println("Actualizacion Ok");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
}
