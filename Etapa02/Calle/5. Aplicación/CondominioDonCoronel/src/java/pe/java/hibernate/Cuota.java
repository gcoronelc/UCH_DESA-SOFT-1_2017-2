package pe.java.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Cuota implements java.io.Serializable {

    private Integer id;
    private Evento evento;
    private String monto;
    private Date termina;
    private Set pagos = new HashSet(0);

    public Cuota() {
    }

    public Cuota(Evento evento, String monto, Date termina) {
        this.evento = evento;
        this.monto = monto;
        this.termina = termina;
    }

    public Cuota(Evento evento, String monto, Date termina, Set pagos) {
        this.evento = evento;
        this.monto = monto;
        this.termina = termina;
        this.pagos = pagos;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Evento getEvento() {
        return this.evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getMonto() {
        return this.monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Date getTermina() {
        return this.termina;
    }

    public void setTermina(Date termina) {
        this.termina = termina;
    }

    public Set getPagos() {
        return this.pagos;
    }

    public void setPagos(Set pagos) {
        this.pagos = pagos;
    }
}
