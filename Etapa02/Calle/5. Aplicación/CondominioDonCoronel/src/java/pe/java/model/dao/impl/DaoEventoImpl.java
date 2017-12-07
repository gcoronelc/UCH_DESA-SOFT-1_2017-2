package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Evento;
import pe.java.model.dao.DaoEvento;

public class DaoEventoImpl implements DaoEvento{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Evento> list() {
        String s = "FROM Evento";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Evento> list = query.list();
        return list;
    }

    @Override
    public String insert(Evento evento) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(evento);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Evento get(Integer id) {
        Evento evento = (Evento) session.get(Evento.class, id);
        return evento;
    }

    @Override
    public String update(Evento evento) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(evento);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
