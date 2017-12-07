package pe.egcc.app.model;

public class Persona {

	private Integer PERSONA;
	private Integer TIPOPERSONA;
	private String NOMBRE;
	private String APELLIDO;
	private String DNI;
	private String TELEFONO;
	private String DIRECCION;
	private String EMAIL;
	private Integer ROL;

  	public Persona() {
  	}

	public Integer getPERSONA() {
		return PERSONA;
	}
	
	public void setPERSONA(Integer pERSONA) {
		PERSONA = pERSONA;
	}
	
	public Integer getTIPOPERSONA() {
		return TIPOPERSONA;
	}
	
	public void setTIPOPERSONA(Integer tIPOPERSONA) {
		TIPOPERSONA = tIPOPERSONA;
	}
	
	public String getNOMBRE() {
		return NOMBRE;
	}
	
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	
	public String getAPELLIDO() {
		return APELLIDO;
	}
	
	public void setAPELLIDO(String aPELLIDO) {
		APELLIDO = aPELLIDO;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public String getTELEFONO() {
		return TELEFONO;
	}
	
	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}
	
	public String getDIRECCION() {
		return DIRECCION;
	}
	
	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}
	
	public String getEMAIL() {
		return EMAIL;
	}
	
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	
	public Integer getROL() {
		return ROL;
	}
	
	public void setROL(Integer rOL) {
		ROL = rOL;
	}

}