package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Cuota;
import pe.java.model.dao.DaoCuota;
import pe.java.model.dao.impl.DaoCuotaImpl;
import pe.java.service.CuotaService;

public class CuotaServiceImpl implements CuotaService{

    //IoC
    private DaoCuota daoCuota;

    public void setDaoCuota(DaoCuotaImpl daoCuotaImpl) {
        this.daoCuota = daoCuotaImpl;
    }
    
    @Override
    public List<Cuota> list() {
        List<Cuota> list = daoCuota.list();
        return list;
    }

    @Override
    public String insert(Cuota cuota) {
        String result = daoCuota.insert(cuota);
        return result;
    }

    @Override
    public Cuota get(Integer id) {
        Cuota cuota = daoCuota.get(id);
        return cuota;
    }

    @Override
    public String update(Cuota cuota) {
        String result = daoCuota.update(cuota);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
