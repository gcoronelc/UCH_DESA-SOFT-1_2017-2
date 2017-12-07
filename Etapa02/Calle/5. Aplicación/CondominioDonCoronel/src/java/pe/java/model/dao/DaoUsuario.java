package pe.java.model.dao;

import java.util.List;
import pe.java.hibernate.Usuario;

public interface DaoUsuario {

    public List<Usuario> list();

    public String insert(Usuario usuario);

    public Usuario get(Integer id);

    public String update(Usuario usuario);

    public String delete(String id);
}
