package pe.egcc.app.service;

import org.springframework.stereotype.Service;

import pe.egcc.app.model.VentaModel;

@Service
public class VentaService {
	
	public VentaModel procesar(VentaModel bean){
	   // Variables
		Double importe, impuesto, total;
		// Proceso
		total = bean.getPrecio() * bean.getCant();
		importe = total / 1.18;
		impuesto = total - importe;
		// Reporte
		bean.setImporte(importe);
		bean.setImpuesto(impuesto);
		bean.setTotal(total);
		return bean;
	}

}
