package pe.java.service;

import java.util.List;
import pe.java.hibernate.Residente;

public interface ResidenteService {

    public List<Residente> list();

    public String insert(Residente residente);

    public Residente get(Integer id);

    public String update(Residente residente);

    public String delete(String id);
}
