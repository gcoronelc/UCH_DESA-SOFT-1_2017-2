package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Administrador;

public interface DaoAdministrador {

    public List<Administrador> list();

    public String insert(Administrador administrador);

    public Administrador get(Integer id);

    public String update(Administrador administrador);

    public String delete(String id);
}
