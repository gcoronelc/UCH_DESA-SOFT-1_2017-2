package pe.egcc.condominio.dao.espec;

import java.util.List;
import java.util.Map;

public interface CrudDaoEspec<T> {
	
	
	List<Map<String, Object>> traerLista();
	
    void insertar(T bean);

    void actualizar(T bean);

    void eliminar(T bean);

}
