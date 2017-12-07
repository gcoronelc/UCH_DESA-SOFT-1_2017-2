package pe.java.service;

import java.util.List;
import pe.java.hibernate.Cuota;

public interface CuotaService {

    public List<Cuota> list();

    public String insert(Cuota cuota);

    public Cuota get(Integer id);

    public String update(Cuota cuota);

    public String delete(String id);
}
