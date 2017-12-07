package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Departamento;
import pe.java.model.dao.DaoDepartamento;
import pe.java.model.dao.impl.DaoDepartamentoImpl;
import pe.java.service.DepartamentoService;

public class DepartamentoServiceImpl implements DepartamentoService {

    //IoC
    private DaoDepartamento daoDepartamento;

    public void setDaoDepartamento(DaoDepartamentoImpl daoDepartamentoImpl) {
        this.daoDepartamento = daoDepartamentoImpl;
    }

    @Override
    public List<Departamento> list() {
        List<Departamento> list = daoDepartamento.list();
        return list;
    }

    @Override
    public String insert(Departamento departamento) {
        String result = daoDepartamento.insert(departamento);
        return result;
    }

    @Override
    public Departamento get(Integer id) {
        Departamento departamento = daoDepartamento.get(id);
        return departamento;
    }

    @Override
    public String update(Departamento departamento) {
        String result = daoDepartamento.update(departamento);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
