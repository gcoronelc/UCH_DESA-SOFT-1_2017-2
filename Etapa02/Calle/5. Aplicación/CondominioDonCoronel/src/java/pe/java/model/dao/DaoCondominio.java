package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Condominio;

public interface DaoCondominio {
    
    public List<Condominio> list();

    public String insert(Condominio c);

    public Condominio get(Integer id);

    public String update(Condominio c);

    public String delete(String id);
    
}
