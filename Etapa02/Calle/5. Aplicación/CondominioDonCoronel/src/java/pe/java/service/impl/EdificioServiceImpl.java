package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Edificio;
import pe.java.model.dao.DaoEdificio;
import pe.java.model.dao.impl.DaoEdificioImpl;
import pe.java.service.EdificioService;

public class EdificioServiceImpl implements EdificioService {

    //IoC
    private DaoEdificio daoEdificio;

    public void setDaoEdificio(DaoEdificioImpl daoEdificioImpl) {
        this.daoEdificio = daoEdificioImpl;
    }

    @Override
    public List<Edificio> list() {
        List<Edificio> list = daoEdificio.list();
        return list;
    }

    @Override
    public String insert(Edificio edificio) {
        String result = daoEdificio.insert(edificio);
        return result;
    }

    @Override
    public Edificio get(Integer id) {
        Edificio edificio = daoEdificio.get(id);
        return edificio;
    }

    @Override
    public String update(Edificio edificio) {
        String result = daoEdificio.update(edificio);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
