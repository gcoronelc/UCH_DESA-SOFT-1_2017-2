package pe.java.service;

import java.util.List;
import pe.java.hibernate.Condominio;

public interface CondominioService {
    
    public List<Condominio> list();

    public String insert(Condominio c);

    public Condominio get(Integer id);

    public String update(Condominio c);

    public String delete(String id);
    
}
