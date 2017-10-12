package pe.egcc.app.model;

public class VentaModel {

	// INPUT
	private Double precio;
	private Integer cant;

	// OUTPUT
	private Double importe;
	private Double impuesto;
	private Double total;

	public VentaModel() {
	}

	public VentaModel(Double precio, Integer cant) {
		super();
		this.precio = precio;
		this.cant = cant;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCant() {
		return cant;
	}

	public void setCant(Integer cant) {
		this.cant = cant;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
