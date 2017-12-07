package pe.egcc.condominio.model;

import org.springframework.jdbc.core.PreparedStatementSetter;

public class UsuarioModel {

	private int idpersona;
	private String usuario;
	private String clave;
	private int idrol;
	private int estado;
	
	
public UsuarioModel() {
	// TODO Auto-generated constructor stub
}


public int getIdpersona() {
	return idpersona;
}


public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
}


public String getUsuario() {
	return usuario;
}


public void setUsuario(String usuario) {
	this.usuario = usuario;
}


public String getClave() {
	return clave;
}


public void setClave(String clave) {
	this.clave = clave;
}


public int getIdrol() {
	return idrol;
}


public void setIdrol(int idrol) {
	this.idrol = idrol;
}


public int getEstado() {
	return estado;
}


public void setEstado(int estado) {
	this.estado = estado;
}


public Object[] toArrayInsert() {
	Object[] rowData= {idpersona,usuario,clave,idrol};
	return rowData;
	
}


}
