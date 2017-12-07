package pe.java.service;

import java.util.List;
import pe.java.hibernate.Usuario;

public interface UsuarioService {

    public List<Usuario> list();

    public String insert(Usuario usuario);

    public Usuario get(Integer id);

    public String update(Usuario usuario);

    public String delete(String id);
}
