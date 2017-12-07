package pe.java.service;

import java.util.List;
import pe.java.hibernate.Visita;

public interface VisitaService {

    public List<Visita> list();

    public String insert(Visita visita);

    public Visita get(Integer id);

    public String update(Visita visita);

    public String delete(String id);
}
