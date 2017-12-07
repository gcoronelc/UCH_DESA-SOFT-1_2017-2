package pe.egcc.condominio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.condominio.dao.espec.PersonaDaoEspec;
import pe.egcc.condominio.dao.impl.PersonaDaoImpl;
import pe.egcc.condominio.model.PersonaModel;

@Service
public class personaService {

	@Autowired
	private PersonaDaoEspec daoEspec;

	public personaService() {
		daoEspec = new PersonaDaoImpl();
	}

	
	public List<Map<String, Object>> traerPersonas(){
		return daoEspec.traerLista();
	}
	
	public void insertarPropietario(PersonaModel bean){
		daoEspec.insertar(bean);
	}
	public void actualizarPropietario(PersonaModel bean){
		daoEspec.actualizar(bean);
	}
	
	public void eliminarPropietario(PersonaModel bean){
		daoEspec.eliminar(bean);
	}
}
