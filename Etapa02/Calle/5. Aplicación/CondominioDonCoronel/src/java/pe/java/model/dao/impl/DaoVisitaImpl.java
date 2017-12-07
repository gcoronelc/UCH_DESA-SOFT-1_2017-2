package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Visita;
import pe.java.model.dao.DaoVisita;

public class DaoVisitaImpl implements DaoVisita{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Visita> list() {
        String s = "FROM Visita";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Visita> list = query.list();
        return list;
    }

    @Override
    public String insert(Visita visita) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(visita);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Visita get(Integer id) {
        Visita visita = (Visita) session.get(Visita.class, id);
        return visita;
    }

    @Override
    public String update(Visita visita) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(visita);
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
