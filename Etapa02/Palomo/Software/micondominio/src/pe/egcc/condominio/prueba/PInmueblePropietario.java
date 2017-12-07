package pe.egcc.condominio.prueba;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.service.InmuebleService;

public class PInmueblePropietario {
	public static void main(String[] args) {

		String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		InmuebleService service;
		try {
			service = beanFactory.getBean(InmuebleService.class);
			int idpro=2;
			List<Map<String, Object>> lista;
			lista=service.traerInmueblePropietario(idpro);
			for (Map<String, Object> r : lista) {
				System.out.println(r.get("idinmueble")
						+"-"+r.get("piso")+"-"+r.get("numero")+"-"+r.get("descripcion")+"-"+r.get("idtinmueble")
						+"-"+r.get("idtorre")+"-"+r.get("activo"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
