package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Queja;
import pe.java.model.dao.DaoQueja;
import pe.java.model.dao.impl.DaoQuejaImpl;
import pe.java.service.QuejaService;

public class QuejaServiceImpl implements QuejaService {

    //IoC
    private DaoQueja daoQueja;

    public void setDaoQueja(DaoQuejaImpl daoQuejaImpl) {
        this.daoQueja = daoQuejaImpl;
    }

    @Override
    public List<Queja> list() {
        List<Queja> list = daoQueja.list();
        return list;
    }

    @Override
    public String insert(Queja queja) {
        String result = daoQueja.insert(queja);
        return result;
    }

    @Override
    public Queja get(Integer id) {
        Queja queja = daoQueja.get(id);
        return queja;
    }

    @Override
    public String update(Queja queja) {
        String result = daoQueja.update(queja);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
