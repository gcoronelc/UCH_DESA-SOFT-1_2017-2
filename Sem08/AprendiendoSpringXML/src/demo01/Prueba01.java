package demo01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba01 {

  public static void main(String[] args) {
    
    String contexto = "/demo01/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);
    
    MateService service;
    service = (MateService) beanFactory.getBean("mateService");

    System.out.println("6 + 7 = " + service.sumar(6, 7));
  }
}
