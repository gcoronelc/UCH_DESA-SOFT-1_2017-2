package pagoapp.prueba;

import pagoapp.model.PagoModel;
import pagoapp.service.PagoService;

public class Prueba01 {

    public static void main(String[] args) {
        //Dato
        PagoModel model = new PagoModel(6, 20, 120.0);
        //Proceso
        PagoService service = new PagoService();
        model = service.procesar(model);
        //Reporte
        System.out.println("Ingresos: " + model.getIngresos());;
        System.out.println("Renta: " + model.getRenta());;
        System.out.println("Neto: " + model.getNeto());;

    }
}
