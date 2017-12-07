package pe.egcc.condominio.model;

import java.util.Date;

public class ReciboModel {
	private Integer idrecibo;
	private Integer idtobligacion;
	private String codigo;
	private Integer anio;
	private Integer mes;
	private String fecVen;
	private double importe;

	public ReciboModel() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdrecibo() {
		return idrecibo;
	}

	public void setIdrecibo(Integer idrecibo) {
		this.idrecibo = idrecibo;
	}

	public Integer getIdtobligacion() {
		return idtobligacion;
	}

	public void setIdtobligacion(Integer idtobligacion) {
		this.idtobligacion = idtobligacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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



	public String getFecVen() {
		return fecVen;
	}

	public void setFecVen(String fecVen) {
		this.fecVen = fecVen;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Object[] toArrayInsert() {
		Object[] rowData= {idrecibo,idtobligacion,codigo,anio,mes,fecVen,importe};
		return rowData;
	}
	
}
