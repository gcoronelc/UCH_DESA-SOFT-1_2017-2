package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.InmuebleModel;
import pe.egcc.condominio.service.InmuebleService;

public class PruebainsertarInmueble {
	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		InmuebleService service;
	    service = beanFactory.getBean(InmuebleService.class);


		try {
		    service = beanFactory.getBean(InmuebleService.class);
			InmuebleModel bean = new InmuebleModel();
			bean.setPiso(2);
			bean.setNumero(103);
			bean.setDescripcion("oficina de fredy");
			bean.setIdpersona(3);
			bean.setIdtinmueble(3);
			bean.setIdtorre(2);
			service.insertarInmueble(bean);
			System.out.println("Registro ok!!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.out.println("alv :V");
		}

	}
}
