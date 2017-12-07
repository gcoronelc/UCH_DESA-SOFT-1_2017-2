package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.model.UsuarioModel;
import pe.egcc.condominio.service.UsuarioService;
import pe.egcc.condominio.service.personaService;

public class PruebaActualizarUsuario {
	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		UsuarioService service;
		
		String usuario="fredy";
		String clave="fredy";

		
		try {
			service = beanFactory.getBean(UsuarioService.class);
			UsuarioModel bean = new UsuarioModel();					
			bean.setUsuario(usuario);
			bean.setClave(clave);
			bean.setIdpersona(11);
			service.actualizar(bean);
			System.out.println("Actualizacion Ok");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
