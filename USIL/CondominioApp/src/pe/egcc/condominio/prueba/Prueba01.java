package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.Persona;
import pe.egcc.condominio.service.LogonService;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba01 {

  public static void main(String[] args) {

    // Instanciar contexto
    String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);

    // Acceso a la clase de servicio
    LogonService service;
    service = beanFactory.getBean(LogonService.class);
    
    // Prueba de la clase de servicio
    Persona bean = service.validarUsuario("gustavo", "gustavo");
    
    // Reporte
    System.out.println("Nombre: " + bean.getNombre());
    System.out.println("Rol: " + bean.getIdrol());
        
  }

}
