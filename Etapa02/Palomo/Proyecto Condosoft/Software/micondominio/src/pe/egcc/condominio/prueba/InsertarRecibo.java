package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.InmuebleModel;
import pe.egcc.condominio.model.ReciboModel;
import pe.egcc.condominio.service.InmuebleService;
import pe.egcc.condominio.service.ReciboService;

public class InsertarRecibo {
	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		ReciboService service;
	    service = beanFactory.getBean(ReciboService.class);


		try {
		    service = beanFactory.getBean(ReciboService.class);
			ReciboModel bean = new ReciboModel();
			bean.setIdrecibo(3);
			bean.setIdtobligacion(1);
			bean.setCodigo("f9-405s");
			bean.setAnio(2017);
			bean.setMes(3);
			bean.setFecVen("2017-11-30");
			bean.setImporte(500);
			service.insertar(bean);
			System.out.println("Registro ok!!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.out.println("alv :V");
		}

	}
}
