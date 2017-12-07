package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Pago;
import pe.java.model.dao.DaoPago;
import pe.java.model.dao.impl.DaoPagoImpl;
import pe.java.service.PagoService;

public class PagoServiceImpl implements PagoService {

    //IoC
    private DaoPago daoPago;

    public void setDaoPago(DaoPagoImpl daoPagoImpl) {
        this.daoPago = daoPagoImpl;
    }

    @Override
    public List<Pago> list() {
        List<Pago> list = daoPago.list();
        return list;
    }

    @Override
    public String insert(Pago pago) {
        String result = daoPago.insert(pago);
        return result;
    }

    @Override
    public Pago get(Integer id) {
        Pago pago = daoPago.get(id);
        return pago;
    }

    @Override
    public String update(Pago pago) {
        String result = daoPago.update(pago);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
