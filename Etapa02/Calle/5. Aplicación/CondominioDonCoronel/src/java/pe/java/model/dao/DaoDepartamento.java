package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Departamento;

public interface DaoDepartamento {
    public List<Departamento> list();

    public String insert(Departamento departamento);

    public Departamento get(Integer id);

    public String update(Departamento departamento);

    public String delete(String id);
}
