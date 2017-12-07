package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Queja;
import pe.java.model.dao.DaoQueja;

public class DaoQuejaImpl implements DaoQueja{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Queja> list() {
        String s = "FROM Queja";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Queja> list = query.list();
        return list;
    }

    @Override
    public String insert(Queja queja) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(queja);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Queja get(Integer id) {
        Queja queja = (Queja) session.get(Queja.class, id);
        return queja;
    }

    @Override
    public String update(Queja queja) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(queja);
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
