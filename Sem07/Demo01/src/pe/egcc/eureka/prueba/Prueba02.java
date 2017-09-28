package pe.egcc.eureka.prueba;

import java.util.List;
import java.util.Map;

import pe.egcc.eureka.model.VentaModel;
import pe.egcc.eureka.service.impl.VentaServiceImpl;
import pe.egcc.eureka.service.spec.VentaServiceSpec;


public class Prueba02 {

  
  public static void main(String[] args) {
    
    try {
      // Dato
      VentaModel model = new VentaModel("Gustavo","PROGRAMACION", "SPRING BOOT", 15);
      // Proceso
      VentaServiceSpec service = new VentaServiceImpl();
      service.registrarVenta(model);
      // Reporte
      System.out.println("ID: " + model.getIdventa());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
