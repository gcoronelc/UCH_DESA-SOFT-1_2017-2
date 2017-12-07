package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.egcc.condominio.model.PersonaModel;
import pe.egcc.condominio.service.LoginService;

/**
 *
 * @author Gustavo Coronel
 */
public class PruebaLogin {

	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
	    // Accediendo a un bean
		LoginService service= beanFactory.getBean(LoginService.class);
	  //  service 	

		try {
			PersonaModel bean = service.validar("gustavo", "gustavo");
			System.out.println("nombre:" + bean.getNombre());
			System.out.println("direccion:" + bean.getDireccion());
			System.out.println("dni: " + bean.getDni());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
