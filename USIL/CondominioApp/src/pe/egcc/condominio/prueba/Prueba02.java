package pe.egcc.condominio.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.condominio.model.Persona;
import pe.egcc.condominio.service.CondoService;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba02 {

  public static void main(String[] args) {

    // Instanciar contexto
    String contexto = "/pe/egcc/condominio/prueba/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);

    // Acceso a la clase de servicio
    CondoService service;
    service = beanFactory.getBean(CondoService.class);
    
    // Prueba de la clase de servicio
    try {
      service.generaCuotaMant(2017, 2, 2);  
      System.out.println("Ok");
    } catch (Exception e) {
      System.out.println("ERROR: " + e.getMessage());
    }
           
  }

}
