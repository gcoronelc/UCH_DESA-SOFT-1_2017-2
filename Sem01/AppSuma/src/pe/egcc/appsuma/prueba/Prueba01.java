package pe.egcc.appsuma.prueba;

import pe.egcc.appsuma.service.MateService;

public class Prueba01 {
	
	public static void main(String[] args) {
		
		// Datos
		int n1 = 10;
		int n2 = 30;
		
		// Proceso
		MateService service = new MateService();
		int suma = service.sumar(n1, n2);
		
		// Reporte
		System.out.println("Suma: " + suma);
		
	}

}
