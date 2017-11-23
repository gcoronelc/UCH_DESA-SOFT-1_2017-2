package pe.egcc.condominio.model;

import java.util.Date;

public class Obligacion {

	private Integer id;
	private Integer inmueble;
	private String codigo;
	private Integer torre;
	private Integer piso;
	private String descripcion;
	private Integer obligacion;
	private String nomobligacion;
	private Integer anio;
	private Integer mes;
	private Date vencimiento;
	private Double importe;
	private String pagada;

	public Obligacion() {
	}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getInmueble() {
    return inmueble;
  }

  public void setInmueble(Integer inmueble) {
    this.inmueble = inmueble;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public Integer getTorre() {
    return torre;
  }

  public void setTorre(Integer torre) {
    this.torre = torre;
  }

  public Integer getPiso() {
    return piso;
  }

  public void setPiso(Integer piso) {
    this.piso = piso;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Integer getObligacion() {
    return obligacion;
  }

  public void setObligacion(Integer obligacion) {
    this.obligacion = obligacion;
  }

  public String getNomobligacion() {
    return nomobligacion;
  }

  public void setNomobligacion(String nomobligacion) {
    this.nomobligacion = nomobligacion;
  }

  public Integer getAnio() {
    return anio;
  }

  public void setAnio(Integer anio) {
    this.anio = anio;
  }

  public Integer getMes() {
    return mes;
  }

  public void setMes(Integer mes) {
    this.mes = mes;
  }

  public Date getVencimiento() {
    return vencimiento;
  }

  public void setVencimiento(Date vencimiento) {
    this.vencimiento = vencimiento;
  }

  public Double getImporte() {
    return importe;
  }

  public void setImporte(Double importe) {
    this.importe = importe;
  }

  public String getPagada() {
    return pagada;
  }

  public void setPagada(String pagada) {
    this.pagada = pagada;
  }

	

}
