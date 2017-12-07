package pe.java.hibernate;

import java.util.Date;

public class Visita  implements java.io.Serializable {

     private Integer id;
     private Departamento departamento;
     private String nombres;
     private String apellidoPat;
     private String apellidoMat;
     private String dni;
     private Date fecha;

    public Visita() {
    }

    public Visita(Departamento departamento, String nombres, String apellidoPat, String apellidoMat, String dni, Date fecha) {
       this.departamento = departamento;
       this.nombres = nombres;
       this.apellidoPat = apellidoPat;
       this.apellidoMat = apellidoMat;
       this.dni = dni;
       this.fecha = fecha;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidoPat() {
        return this.apellidoPat;
    }
    
    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }
    public String getApellidoMat() {
        return this.apellidoMat;
    }
    
    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


