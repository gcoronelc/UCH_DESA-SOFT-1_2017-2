package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Visita;
import pe.java.model.dao.DaoVisita;
import pe.java.model.dao.impl.DaoVisitaImpl;
import pe.java.service.VisitaService;

public class VisitaServiceImpl implements VisitaService {

    //IoC
    private DaoVisita daoVisita;

    public void setDaoVisita(DaoVisitaImpl daoVisitaImpl) {
        this.daoVisita = daoVisitaImpl;
    }

    @Override
    public List<Visita> list() {
        List<Visita> list = daoVisita.list();
        return list;
    }

    @Override
    public String insert(Visita visita) {
        String result = daoVisita.insert(visita);
        return result;
    }

    @Override
    public Visita get(Integer id) {
        Visita visita = daoVisita.get(id);
        return visita;
    }

    @Override
    public String update(Visita visita) {
        String result = daoVisita.update(visita);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
