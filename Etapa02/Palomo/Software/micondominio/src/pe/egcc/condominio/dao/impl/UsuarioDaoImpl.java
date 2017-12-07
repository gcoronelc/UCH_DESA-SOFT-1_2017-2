package pe.egcc.condominio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.egcc.condominio.dao.espec.UsuarioDaoEspec;
import pe.egcc.condominio.model.InmuebleModel;
import pe.egcc.condominio.model.UsuarioModel;

@Repository
public class UsuarioDaoImpl implements UsuarioDaoEspec{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> traerLista() {
		List<Map<String, Object>> lista;
		
		String sql="select u.idpersona,p.nombre,p.apellido,u.usuario,r.nombre from usuario u "
				+ "join persona p on p.idpersona=u.idpersona "
				+ "join rol r on r.idrol=u.idrol ";
		lista=jdbcTemplate.queryForList(sql);
		return lista;
	}

	@Override
	public void insertar(UsuarioModel bean) {
	String sql="insert into usuario(idpersona,usuario,clave,idrol,estado)"
			+ " values (?,?,SHA(?),?,1)";
	jdbcTemplate.update(sql,bean.toArrayInsert());
		
	}

	@Override
	public void actualizar(UsuarioModel bean) {	
		String sql="update usuario set usuario=?, clave=SHA(?) where idpersona=?";
		jdbcTemplate.update(sql,bean.getUsuario(),bean.getClave(),bean.getIdpersona());
	}

	@Override
	public void eliminar(UsuarioModel bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UsuarioModel mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
