package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Pago;
import pe.java.model.dao.DaoPago;

public class DaoPagoImpl implements DaoPago{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Pago> list() {
        String s = "FROM Pago";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Pago> list = query.list();
        return list;
    }

    @Override
    public String insert(Pago pago) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(pago);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Pago get(Integer id) {
        Pago pago = (Pago) session.get(Pago.class, id);
        return pago;
    }

    @Override
    public String update(Pago pago) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(pago);
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
