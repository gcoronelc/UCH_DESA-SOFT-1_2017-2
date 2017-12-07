package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Cuota;

public interface DaoCuota {

    public List<Cuota> list();

    public String insert(Cuota cuota);

    public Cuota get(Integer id);

    public String update(Cuota cuota);

    public String delete(String id);
}
