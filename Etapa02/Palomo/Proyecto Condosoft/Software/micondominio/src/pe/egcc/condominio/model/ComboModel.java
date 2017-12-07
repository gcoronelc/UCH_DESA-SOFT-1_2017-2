package pe.egcc.condominio.model;

public class ComboModel {
private String codigo;
private String nombre;

public ComboModel() {
	// TODO Auto-generated constructor stub
}

public ComboModel(String codigo, String nombre){
	this.codigo = codigo;
    this.nombre = nombre;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}



}
