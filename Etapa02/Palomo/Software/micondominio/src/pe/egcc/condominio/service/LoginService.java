package pe.egcc.condominio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.condominio.dao.espec.LoginDaoEspec;
import pe.egcc.condominio.model.PersonaModel;



@Service
public class LoginService {
	
	@Autowired
	private LoginDaoEspec loginDaoEspec;

	public PersonaModel validar(String usuario, String clave) {
		
		PersonaModel bean = loginDaoEspec.validar(usuario, clave);
		if (bean == null) {
			throw new RuntimeException("datos incorrectos");
		}
		return bean;
	}
}
