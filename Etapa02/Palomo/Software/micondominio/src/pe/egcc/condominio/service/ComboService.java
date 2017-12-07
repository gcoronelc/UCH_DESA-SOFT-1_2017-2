package pe.egcc.condominio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.condominio.dao.espec.ComboDaoEspec;
import pe.egcc.condominio.dao.impl.ComboDaoImpl;

@Service
public class ComboService {

	@Autowired
	ComboDaoEspec daoEspec;
	
	public ComboService() {
		daoEspec=new ComboDaoImpl();
	}
	
	public List<Map<String, Object>>traerTPropietarios(){
		return daoEspec.traerTPropietarios();
	}
	
	public List<Map<String, Object>>traerTipoInmueble(){
		return daoEspec.traerTipoInmueble();
	}
	
	public List<Map<String, Object>>traerTorre(){
		return daoEspec.traerTorre();
	}
	
	public List<Map<String, Object>>traerPersonas(){
		return daoEspec.traerPersonas();
	}
	
	
}
