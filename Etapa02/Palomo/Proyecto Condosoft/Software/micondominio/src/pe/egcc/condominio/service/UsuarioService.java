package pe.egcc.condominio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.condominio.dao.espec.UsuarioDaoEspec;
import pe.egcc.condominio.dao.impl.UsuarioDaoImpl;
import pe.egcc.condominio.model.UsuarioModel;

@Service
public class UsuarioService {
	@Autowired
	UsuarioDaoEspec daoEspec;

	public UsuarioService() {
		daoEspec = new UsuarioDaoImpl();
	}

	public List<Map<String, Object>> traerUsuario() {
		return daoEspec.traerLista();
	}

	public void insertarUsuario(UsuarioModel bean) {
		daoEspec.insertar(bean);
	}
	
	public void actualizar(UsuarioModel bean){
		daoEspec.actualizar(bean);
	}
	
}
