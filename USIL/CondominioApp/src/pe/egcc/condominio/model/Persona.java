package pe.egcc.condominio.model;

public class Persona {

  private Integer idpersona;
  private Integer idtpersona;
  private String nombre;
  private String apellido;
  private String dni;
  private String telefono;
  private String direccion;
  private String email;
  private Integer idrol;

  public Persona() {
  }

  public Integer getIdpersona() {
    return idpersona;
  }

  public void setIdpersona(Integer idpersona) {
    this.idpersona = idpersona;
  }

  public Integer getIdtpersona() {
    return idtpersona;
  }

  public void setIdtpersona(Integer idtpersona) {
    this.idtpersona = idtpersona;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getIdrol() {
    return idrol;
  }

  public void setIdrol(Integer idrol) {
    this.idrol = idrol;
  }

}
