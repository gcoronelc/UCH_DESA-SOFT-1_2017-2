package pe.egcc.app.prueba;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.egcc.app.service.CursoService;

public class Prueba01 {
  
  public static void main(String[] args) {

    // Instanciando el contexto
    String contexto = "/pe/egcc/app/prueba/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);

    // Accediendo a un bean
    CursoService service;
    service = beanFactory.getBean(CursoService.class);
    
    // Probando el bean
    List<Map<String,Object>> lista;
    lista = service.conResumenCurso("2017-01");
    
    
    for (Map<String, Object> r : lista) {
      System.out.println( r.get("nomcurso") + " - " 
        + r.get("matriculados") + " - " 
        + r.get("ingresos") );
    }
    
  }
  
}
