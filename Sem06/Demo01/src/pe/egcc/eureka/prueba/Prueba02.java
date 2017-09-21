package pe.egcc.eureka.prueba;

import java.util.List;
import java.util.Map;

import pe.egcc.eureka.service.impl.EurekaServiceImpl;
import pe.egcc.eureka.service.spec.EurekaServiceSpec;


public class Prueba02 {

  
  public static void main(String[] args) {
    
    try {
      // Dato
      String cuenta = "00100002";
      // Proceso
      EurekaServiceSpec service = new EurekaServiceImpl();
      List<Map<String,Object>> lista = service.conMovimientos(cuenta);
      // Reporte
      for(Map<String,Object> r: lista){
        System.out.println(
            r.get("movinumero").toString() 
            + " - " + r.get("moviimporte").toString());
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
