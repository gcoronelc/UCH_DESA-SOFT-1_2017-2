package pe.java.service;

import java.util.List;
import pe.java.hibernate.Queja;

public interface QuejaService {

    public List<Queja> list();

    public String insert(Queja queja);

    public Queja get(Integer id);

    public String update(Queja queja);

    public String delete(String id);
}
