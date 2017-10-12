package demo02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba01 {

  public static void main(String[] args) {
    
    String contexto = "/demo02/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);
    
    MateController control;
    // control = (MateController) beanFactory.getBean("control");
    control = beanFactory.getBean("control",MateController.class);
    
    
    System.out.println("6 + 7 = " + control.sumar(6, 7));
  }
}
