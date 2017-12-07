package pe.egcc.condominio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.condominio.dao.espec.ReciboDaoEspec;
import pe.egcc.condominio.dao.impl.ReciboDaoImpl;
import pe.egcc.condominio.model.ReciboModel;

@Service
public class ReciboService {

	@Autowired
	private ReciboDaoEspec daoEspec;
	
	public ReciboService() {
	daoEspec=new ReciboDaoImpl();
	}
	
	public void insertar(ReciboModel bean){
		daoEspec.insertar(bean);
	}
}
