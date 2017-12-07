package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Departamento;
import pe.java.model.dao.DaoDepartamento;

public class DaoDepartamentoImpl implements DaoDepartamento{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    
    @Override
    public List<Departamento> list() {
        String s = "FROM Departamento";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Departamento> list = query.list();
        return list;
    }

    @Override
    public String insert(Departamento departamento) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(departamento);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Departamento get(Integer id) {
        Departamento departamento = (Departamento) session.get(Departamento.class, id);
        return departamento;
    }

    @Override
    public String update(Departamento departamento) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(departamento);
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
