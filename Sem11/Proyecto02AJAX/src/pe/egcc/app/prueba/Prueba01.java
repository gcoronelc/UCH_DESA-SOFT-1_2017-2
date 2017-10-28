package pe.egcc.app.prueba;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.app.service.AppService;

public class Prueba01 {
  
  
  public static void main(String[] args) {
    
    String contexto = "/pe/egcc/app/prueba/context.xml";
    BeanFactory beanFactory;
    beanFactory= new ClassPathXmlApplicationContext(contexto);
    
    AppService appService;
    appService = beanFactory.getBean(AppService.class);
    
    List<String> lista = appService.leerPeriodos();
    
    for (String periodo : lista) {
      System.out.println(periodo);
    }
    
  }

}
