package pe.egcc.eureka.model;

public class VentaModel {
  
  // INPUT
  private String empresa;
  private String categoria;
  private String nombre;
  private int cantidad;
  
  // OUTPUT
  private int idventa;
  private double precio;
  private double importe;
  private double impuesto;
  private double total;
  private int tganancia;
  private double pganancia;
  private double ganancia;
  
  public VentaModel() {
  }

  public VentaModel(String empresa,String categoria, String nombre, int cantidad) {
    super();
    this.empresa = empresa;
    this.categoria = categoria;
    this.nombre = nombre;
    this.cantidad = cantidad;
  }
  
  public void setIdventa(int idventa) {
    this.idventa = idventa;
  }
  
  public int getIdventa() {
    return idventa;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  public double getImpuesto() {
    return impuesto;
  }

  public void setImpuesto(double impuesto) {
    this.impuesto = impuesto;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public int getTganancia() {
    return tganancia;
  }

  public void setTganancia(int tganancia) {
    this.tganancia = tganancia;
  }

  public double getPganancia() {
    return pganancia;
  }

  public void setPganancia(double pganancia) {
    this.pganancia = pganancia;
  }

  public double getGanancia() {
    return ganancia;
  }

  public void setGanancia(double ganancia) {
    this.ganancia = ganancia;
  }

  
}
