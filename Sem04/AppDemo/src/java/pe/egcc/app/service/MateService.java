package pe.egcc.app.service;

import pe.egcc.app.model.MateModel;

public class MateService {

    public MateModel procesar(MateModel model){
        // Variables
        int suma, resta;
        // Proceso
        suma = model.getNum1() + model.getNum2();
        resta = model.getNum1() - model.getNum2();
        // Reporte
        model.setSuma(suma);
        model.setResta(resta);
        // Retorno
        return model;
    }

    
}
