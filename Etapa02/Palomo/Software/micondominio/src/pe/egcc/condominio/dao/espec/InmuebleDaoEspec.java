package pe.egcc.condominio.dao.espec;

import java.util.List;
import java.util.Map;

import pe.egcc.condominio.model.InmuebleModel;

public interface InmuebleDaoEspec extends CrudDaoEspec<InmuebleModel>,RowMapper<InmuebleModel> {
	List<Map<String, Object>> listaInmueblePropietario(int idpersona);
}
