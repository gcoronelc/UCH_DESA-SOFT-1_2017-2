package pe.egcc.condominio.dao.espec;

import pe.egcc.condominio.model.PersonaModel;

public interface PersonaDaoEspec extends CrudDaoEspec<PersonaModel>,RowMapper<PersonaModel>{
	void desactivarEstado(PersonaModel bean);	
}
