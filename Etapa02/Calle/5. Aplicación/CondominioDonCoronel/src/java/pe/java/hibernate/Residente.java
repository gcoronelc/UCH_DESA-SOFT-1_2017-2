package pe.java.hibernate;

public class Residente implements java.io.Serializable {

    private Integer id;
    private Usuario usuario;
    private Departamento departamento;

    public Residente() {
    }

    public Residente(Usuario usuario, Departamento departamento) {
        this.usuario = usuario;
        this.departamento = departamento;
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

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
