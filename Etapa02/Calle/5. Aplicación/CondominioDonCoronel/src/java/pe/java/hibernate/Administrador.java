package pe.java.hibernate;
// Generated Nov 18, 2013 3:36:23 PM by Hibernate Tools 3.2.1.GA



/**
 * Administrador generated by hbm2java
 */
public class Administrador  implements java.io.Serializable {


     private Integer id;
     private Usuario usuario;
     private Condominio condominio;

    public Administrador() {
    }

    public Administrador(Usuario usuario, Condominio condominio) {
       this.usuario = usuario;
       this.condominio = condominio;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Condominio getCondominio() {
        return this.condominio;
    }
    
    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }




}


