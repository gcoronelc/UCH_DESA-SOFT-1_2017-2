package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Pago;

public interface DaoPago {

    public List<Pago> list();

    public String insert(Pago pago);

    public Pago get(Integer id);

    public String update(Pago pago);

    public String delete(String id);
}
