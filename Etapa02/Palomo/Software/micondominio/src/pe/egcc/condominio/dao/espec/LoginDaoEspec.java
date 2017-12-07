package pe.egcc.condominio.dao.espec;

import pe.egcc.condominio.model.PersonaModel;

public interface LoginDaoEspec extends RowMapper<PersonaModel> {
	
	PersonaModel validar(String usuario, String clave);
	
}
