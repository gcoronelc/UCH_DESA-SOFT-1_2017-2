package pe.java.service;

import java.util.List;
import pe.java.hibernate.Edificio;

public interface EdificioService {

    public List<Edificio> list();

    public String insert(Edificio edificio);

    public Edificio get(Integer id);

    public String update(Edificio edificio);

    public String delete(String id);
}
