package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Residente;
import pe.java.model.dao.DaoResidente;
import pe.java.model.dao.impl.DaoResidenteImpl;
import pe.java.service.ResidenteService;

public class ResidenteServiceImpl implements ResidenteService {

    //IoC
    private DaoResidente daoResidente;

    public void setDaoResidente(DaoResidenteImpl daoResidenteImpl) {
        this.daoResidente = daoResidenteImpl;
    }

    @Override
    public List<Residente> list() {
        List<Residente> list = daoResidente.list();
        return list;
    }

    @Override
    public String insert(Residente residente) {
        String result = daoResidente.insert(residente);
        return result;
    }

    @Override
    public Residente get(Integer id) {
        Residente residente = daoResidente.get(id);
        return residente;
    }

    @Override
    public String update(Residente residente) {
        String result = daoResidente.update(residente);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
