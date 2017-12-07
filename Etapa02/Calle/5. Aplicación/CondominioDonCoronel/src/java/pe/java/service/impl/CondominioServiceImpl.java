package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Condominio;
import pe.java.model.dao.DaoCondominio;
import pe.java.model.dao.impl.DaoCondominioImpl;
import pe.java.service.CondominioService;

public class CondominioServiceImpl implements CondominioService{

    //IoC
    private DaoCondominio daoCondominio;

    public void setDaoCondominio(DaoCondominioImpl daoCondominioImpl) {
        this.daoCondominio = daoCondominioImpl;
    }
    
    @Override
    public List<Condominio> list() {
        List<Condominio> list = daoCondominio.list();
        return list;
    }

    @Override
    public String insert(Condominio c) {
        String result = daoCondominio.insert(c);
        return result;
    }

    @Override
    public Condominio get(Integer id) {
        Condominio condominio = daoCondominio.get(id);
        return condominio;
    }

    @Override
    public String update(Condominio c) {
        String result = daoCondominio.update(c);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}