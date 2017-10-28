package pe.egcc.app.prueba;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.app.service.AppService;

public class Prueba02 {
  
  
  public static void main(String[] args) {
    
    String contexto = "/pe/egcc/app/prueba/context.xml";
    BeanFactory beanFactory;
    beanFactory= new ClassPathXmlApplicationContext(contexto);
    
    AppService appService;
    appService = beanFactory.getBean(AppService.class);
    
    List<Map<String,Object>> lista;
    lista = appService.leerMejoresCursos("2017");
    
    for (Map<String,Object> r : lista) {
      
      String fila = "";
      fila += r.get("ciclo") + "\t";
      fila += r.get("idcurso") + "\t";
      fila += r.get("secciones") + "\t";
      fila += r.get("matriculados") + "\t";
      
      System.out.println(fila);
    }
    
  }

}
