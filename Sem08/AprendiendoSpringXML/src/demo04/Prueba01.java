package demo04;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba01 {

  public static void main(String[] args) {
    
    String contexto = "/demo04/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);
    
    MateController control;
    control = beanFactory.getBean(MateController.class);
    
    
    System.out.println("6 + 7 = " + control.sumar(6, 7));
  }
}
