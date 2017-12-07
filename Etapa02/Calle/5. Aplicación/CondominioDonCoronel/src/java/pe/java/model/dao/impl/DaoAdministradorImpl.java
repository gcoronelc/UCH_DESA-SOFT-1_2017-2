package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Administrador;
import pe.java.model.dao.DaoAdministrador;

public class DaoAdministradorImpl implements DaoAdministrador{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Administrador> list() {
        String s = "FROM Administrador";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Administrador> list = query.list();
        return list;
    }

    @Override
    public String insert(Administrador administrador) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(administrador);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Administrador get(Integer id) {
        Administrador administrador = (Administrador) session.get(Administrador.class, id);
        return administrador;
    }

    @Override
    public String update(Administrador administrador) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(administrador);
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
