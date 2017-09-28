package pe.egcc.eureka.service.spec;

import java.util.List;
import java.util.Map;

import pe.egcc.eureka.model.VentaModel;

public interface VentaServiceSpec {

  void registrarVenta( VentaModel ventaModel );
  
  List<Map<String, Object>> conVentas();
  
  List<Map<String, Object>> conResumen();
  
}
