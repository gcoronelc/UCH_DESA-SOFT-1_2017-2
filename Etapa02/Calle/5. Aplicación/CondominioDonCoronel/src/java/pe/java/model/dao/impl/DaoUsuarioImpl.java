package pe.java.model.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.java.hibernate.Usuario;
import pe.java.model.dao.DaoUsuario;

public class DaoUsuarioImpl implements DaoUsuario{

    private Session session;
    private Transaction tx;
    
    //IoC
    //Inyectando la dependencia por metodo set
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    
    @Override
    public List<Usuario> list() {
        String s = "FROM Usuario";
        
        session.beginTransaction().commit();
        Query query = session.createQuery(s);
        List<Usuario> list = query.list();
        return list;
    }

    @Override
    public String insert(Usuario usuario) {
        String result = null;
        
        tx = session.beginTransaction();
        try {
            session.persist(usuario);
            tx.commit();
        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }
        return result;
    }

    @Override
    public Usuario get(Integer id) {
        Usuario usuario = (Usuario) session.get(Usuario.class, id);
        return usuario;
    }

    @Override
    public String update(Usuario usuario) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.clear();
            session.update(usuario);
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
