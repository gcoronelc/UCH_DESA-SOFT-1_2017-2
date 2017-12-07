package pe.egcc.condominio.dao.espec;

import java.util.List;
import java.util.Map;

import pe.egcc.condominio.model.ComboModel;

public interface ComboDaoEspec extends RowMapper<ComboModel> {
	List<Map<String, Object>> traerTPropietarios();
	List<Map<String, Object>> traerTipoInmueble();
	List<Map<String, Object>> traerTorre();
	List<Map<String, Object>> traerPersonas();
}
