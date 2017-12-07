package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Cuota;
import pe.java.model.dao.DaoCuota;

public class DaoCuotaImpl implements DaoCuota{
    
    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Cuota> list() {
        String s = "FROM Cuota";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Cuota> list = query.list();
        return list;
    }

    @Override
    public String insert(Cuota cuota) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(cuota);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Cuota get(Integer id) {
        Cuota cuota = (Cuota) session.get(Cuota.class, id);
        return cuota;
    }

    @Override
    public String update(Cuota cuota) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(cuota);
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
