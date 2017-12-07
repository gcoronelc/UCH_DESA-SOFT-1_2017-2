package pe.egcc.condominio.model;

import org.springframework.jdbc.core.PreparedStatementSetter;

public class PersonaModel {

  private int idpersona;
  private int idtpersona;
  private String apellido;
  private String nombre;
  private String dni;
  private String email;
  private String telefono;
  private String direccion;
  private int idrol;

  public PersonaModel() {
  }

  public int getIdpersona() {
    return idpersona;
  }

  public void setIdpersona(int idpersona) {
    this.idpersona = idpersona;
  }

  public int getIdtpersona() {
    return idtpersona;
  }

  public void setIdtpersona(int idtpersona) {
    this.idtpersona = idtpersona;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public int getIdrol() {
    return idrol;
  }
  
  public void setIdrol(int idrol) {
    this.idrol = idrol;
  }

public Object[] toArrayInsert() {
	Object[] rowData= {idpersona,apellido,nombre,dni,email,telefono,direccion};
	return rowData;
}
  
}
