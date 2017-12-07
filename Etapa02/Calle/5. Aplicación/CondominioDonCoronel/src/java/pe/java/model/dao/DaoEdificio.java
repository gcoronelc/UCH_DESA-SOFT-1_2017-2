package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Edificio;

public interface DaoEdificio {

    public List<Edificio> list();

    public String insert(Edificio edificio);

    public Edificio get(Integer id);

    public String update(Edificio edificio);

    public String delete(String id);
}
