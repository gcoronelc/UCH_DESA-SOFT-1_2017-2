package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.model.UsuarioModel;
import pe.egcc.condominio.service.UsuarioService;
import pe.egcc.condominio.service.personaService;

public class PruebaInsertarUsuario {
	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		UsuarioService service;
	    service = beanFactory.getBean(UsuarioService.class);
	    
	    //datos
	    int idpersona=11;
	    String usuario="fredy";
	    String clave="fredy";
	    int idrol=1;
		try {
		    service = beanFactory.getBean(UsuarioService.class);
			UsuarioModel bean = new UsuarioModel();
			//bean.setIdtpersona(2);
			bean.setIdpersona(idpersona);
			bean.setUsuario(usuario);
			bean.setClave(clave);
			bean.setIdrol(idrol);
			service.insertarUsuario(bean);
			System.out.println("Registro ok!!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.out.println(":(");
		}

	}
}
