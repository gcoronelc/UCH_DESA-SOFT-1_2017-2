package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Administrador;
import pe.java.model.dao.DaoAdministrador;
import pe.java.model.dao.impl.DaoAdministradorImpl;
import pe.java.service.AdministradorService;

public class AdministradorServiceImpl implements AdministradorService{

    //IoC
    private DaoAdministrador daoAdministrador;

    public void setDaoAdministrador(DaoAdministradorImpl daoAdministradorImpl) {
        this.daoAdministrador = daoAdministradorImpl;
    }
    
    @Override
    public List<Administrador> list() {
        List<Administrador> list = daoAdministrador.list();
        return list;
    }

    @Override
    public String insert(Administrador administrador) {
        String result = daoAdministrador.insert(administrador);
        return result;
    }

    @Override
    public Administrador get(Integer id) {
        Administrador administrador = daoAdministrador.get(id);
        return administrador;
    }

    @Override
    public String update(Administrador administrador) {
        String result = daoAdministrador.update(administrador);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
