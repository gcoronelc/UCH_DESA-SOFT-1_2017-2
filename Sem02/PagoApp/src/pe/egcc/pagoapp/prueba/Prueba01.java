
package pe.egcc.pagoapp.prueba;

import pe.egcc.pagoapp.model.PagoModel;
import pe.egcc.pagoapp.service.PagoService;

public class Prueba01 {
    public static void main(String[] args){
      //dato
      PagoModel model = new PagoModel(6, 20, 120.0);
      //proceso
      PagoService service = new PagoService();
      model = service.procesar(model);
      //reporte
      System.out.println("Ingresos: " + model.getIngresos());
      System.out.println("Renta : " + model.getRenta());
      System.out.println("Neto : " + model.getNeto());
    }
}
