package pe.java.service;

import java.util.List;
import pe.java.hibernate.Administrador;

public interface AdministradorService {

    public List<Administrador> list();

    public String insert(Administrador administrador);

    public Administrador get(Integer id);

    public String update(Administrador administrador);

    public String delete(String id);
}
