package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Residente;

public interface DaoResidente {

    public List<Residente> list();

    public String insert(Residente residente);

    public Residente get(Integer id);

    public String update(Residente residente);

    public String delete(String id);
}
