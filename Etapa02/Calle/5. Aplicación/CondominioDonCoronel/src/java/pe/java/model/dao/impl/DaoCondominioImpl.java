package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Condominio;
import pe.java.model.dao.DaoCondominio;

public class DaoCondominioImpl implements DaoCondominio{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Condominio> list() {
        String s = "FROM Condominio";
        Query query = session.createQuery(s);
        List<Condominio> list = query.list();
        return list;
    }

    @Override
    public String insert(Condominio c) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.persist(c);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Condominio get(Integer id) {
        Condominio condominio = (Condominio) session.get(Condominio.class, id);
        return condominio;
    }

    @Override
    public String update(Condominio c) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(c);
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
