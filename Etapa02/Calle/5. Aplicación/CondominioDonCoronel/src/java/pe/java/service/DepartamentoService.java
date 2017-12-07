package pe.java.service;

import java.util.List;
import pe.java.hibernate.Departamento;
import pe.java.model.dao.DaoDepartamento;

public interface DepartamentoService {
    
    public List<Departamento> list();

    public String insert(Departamento departamento);

    public Departamento get(Integer id);

    public String update(Departamento departamento);

    public String delete(String id);
}
