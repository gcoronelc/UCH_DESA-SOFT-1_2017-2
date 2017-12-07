package pe.egcc.condominio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.condominio.dao.espec.InmuebleDaoEspec;
import pe.egcc.condominio.dao.impl.InmuebleDaoImpl;
import pe.egcc.condominio.model.InmuebleModel;

@Service
public class InmuebleService {

	@Autowired
	InmuebleDaoEspec daoEspec;

	public InmuebleService() {
		daoEspec = new InmuebleDaoImpl();
	}

	public List<Map<String, Object>> traerInmueblePropietario(int idpersona) {
		return daoEspec.listaInmueblePropietario(idpersona);
	}

	public List<Map<String, Object>> traerInmbuebles() {
		return daoEspec.traerLista();
	}
	
	public void insertarInmueble(InmuebleModel bean){
		daoEspec.insertar(bean);
	}
}
