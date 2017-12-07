package pe.java.service;

import java.util.List;
import pe.java.hibernate.Pago;

public interface PagoService {

    public List<Pago> list();

    public String insert(Pago pago);

    public Pago get(Integer id);

    public String update(Pago pago);

    public String delete(String id);
}
