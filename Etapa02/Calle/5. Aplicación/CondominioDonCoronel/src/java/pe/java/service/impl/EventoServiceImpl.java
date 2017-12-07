package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Evento;
import pe.java.model.dao.DaoEvento;
import pe.java.model.dao.impl.DaoEventoImpl;
import pe.java.service.EventoService;

public class EventoServiceImpl implements EventoService {

    //IoC
    private DaoEvento daoEvento;

    public void setDaoEvento(DaoEventoImpl daoEventoImpl) {
        this.daoEvento = daoEventoImpl;
    }

    @Override
    public List<Evento> list() {
        List<Evento> list = daoEvento.list();
        return list;
    }

    @Override
    public String insert(Evento evento) {
        String result = daoEvento.insert(evento);
        return result;
    }

    @Override
    public Evento get(Integer id) {
        Evento evento = daoEvento.get(id);
        return evento;
    }

    @Override
    public String update(Evento evento) {
        String result = daoEvento.update(evento);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
