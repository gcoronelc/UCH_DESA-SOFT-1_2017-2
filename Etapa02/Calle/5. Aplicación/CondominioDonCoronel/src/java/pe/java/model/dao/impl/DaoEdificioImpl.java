package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Edificio;
import pe.java.model.dao.DaoEdificio;

public class DaoEdificioImpl implements DaoEdificio{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Edificio> list() {
        String s = "FROM Edificio";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Edificio> list = query.list();
        return list;
    }

    @Override
    public String insert(Edificio edificio) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(edificio);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Edificio get(Integer id) {
        Edificio edificio = (Edificio) session.get(Edificio.class, id);
        return edificio;
    }

    @Override
    public String update(Edificio edificio) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(edificio);
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
