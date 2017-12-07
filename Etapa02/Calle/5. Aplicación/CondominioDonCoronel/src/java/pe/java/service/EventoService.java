package pe.java.service;

import java.util.List;
import pe.java.hibernate.Evento;

public interface EventoService {

    public List<Evento> list();

    public String insert(Evento evento);

    public Evento get(Integer id);

    public String update(Evento evento);

    public String delete(String id);
}
