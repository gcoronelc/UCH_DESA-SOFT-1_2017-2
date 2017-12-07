package pe.java.service.impl;

import java.util.List;
import pe.java.hibernate.Usuario;
import pe.java.model.dao.DaoUsuario;
import pe.java.model.dao.impl.DaoUsuarioImpl;
import pe.java.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    //IoC
    private DaoUsuario daoUsuario;

    public void setDaoUsuario(DaoUsuarioImpl daoUsuarioImpl) {
        this.daoUsuario = daoUsuarioImpl;
    }

    @Override
    public List<Usuario> list() {
        List<Usuario> list = daoUsuario.list();
        return list;
    }

    @Override
    public String insert(Usuario usuario) {
        String result = daoUsuario.insert(usuario);
        return result;
    }

    @Override
    public Usuario get(Integer id) {
        Usuario usuario = daoUsuario.get(id);
        return usuario;
    }

    @Override
    public String update(Usuario usuario) {
        String result = daoUsuario.update(usuario);
        return result;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
