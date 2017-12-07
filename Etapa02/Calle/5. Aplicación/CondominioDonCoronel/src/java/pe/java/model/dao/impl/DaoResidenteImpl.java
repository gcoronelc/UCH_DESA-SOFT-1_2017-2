package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Residente;
import pe.java.model.dao.DaoResidente;

public class DaoResidenteImpl implements DaoResidente{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Residente> list() {
        String s = "FROM Residente";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Residente> list = query.list();
        return list;
    }

    @Override
    public String insert(Residente residente) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(residente);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Residente get(Integer id) {
        Residente residente = (Residente) session.get(Residente.class, id);
        return residente;
    }

    @Override
    public String update(Residente residente) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(residente);
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
