package pe.egcc.app.prueba;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.app.model.Persona;
import pe.egcc.app.service.LogonService;

public class Prueba01 {       
  
  public static void main(String[] args) {
    
    try {
      String contexto = "/pe/egcc/app/prueba/context.xml";
      BeanFactory factory = new ClassPathXmlApplicationContext(contexto);
      
      LogonService service = factory.getBean(LogonService.class);
        
      Persona bean  = service.validar("gustavo", "gustavo");
            
      System.out.println("Usuario: " + bean.getPERSONA());
     } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
  
}
