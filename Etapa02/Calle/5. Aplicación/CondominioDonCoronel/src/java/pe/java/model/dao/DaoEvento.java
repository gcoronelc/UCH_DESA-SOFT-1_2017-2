package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Evento;

public interface DaoEvento {

    public List<Evento> list();

    public String insert(Evento evento);

    public Evento get(Integer id);

    public String update(Evento evento);

    public String delete(String id);
}
