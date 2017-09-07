package pe.egcc.app.prueba;

import pe.egcc.app.model.MateModel;
import pe.egcc.app.service.MateService;

public class Prueba01 {
 
    public static void main(String[] args) {
        // Datos
        MateModel model = new MateModel(8, 3);
        
        // Proceso
        MateService service = new MateService();
        model = service.procesar(model);
        
        // Reporte
        System.out.println("INPUT");
        System.out.println("Num 1: " + model.getNum1());
        System.out.println("Num 2: " + model.getNum2());
        System.out.println("OUTPUT");
        System.out.println("Suma: " + model.getSuma());
        System.out.println("Resta: " + model.getResta());
    }
}
