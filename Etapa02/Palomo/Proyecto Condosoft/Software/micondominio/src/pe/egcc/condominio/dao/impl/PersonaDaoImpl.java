package pe.egcc.condominio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.condominio.dao.espec.PersonaDaoEspec;
import pe.egcc.condominio.model.InmuebleModel;
import pe.egcc.condominio.model.PersonaModel;

@Repository
public class PersonaDaoImpl implements PersonaDaoEspec {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> traerLista() {
		List<Map<String, Object>> lista;
		String sql = "select idpersona,idtpersona,apellido,nombre,dni,"
				+ "email,telefono, direccion from persona where idtpersona=2";
		lista = jdbcTemplate.queryForList(sql);
		return lista;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void insertar(PersonaModel bean) {
		String sql = "insert into persona(idpersona,idtpersona,apellido,nombre,dni," + "email,telefono, direccion) "
				+ "values(?,2,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, bean.toArrayInsert());
	}

	@Override
	public void actualizar(PersonaModel bean) {
		String sql = "update persona set apellido=?, nombre=?, "
				+ "dni=?, email=?, telefono=? ,direccion=? where idpersona=?";
		jdbcTemplate.update(sql, bean.getApellido(), bean.getNombre(), bean.getDni(), bean.getEmail(),
				bean.getTelefono(), bean.getDireccion(), bean.getIdpersona());
	}

	@Override
	public void eliminar(PersonaModel bean) {
		String sql = "delete from persona where idpersona=? ";
		jdbcTemplate.update(sql, bean.getIdpersona());
	}

	@Override
	public void desactivarEstado(PersonaModel bean) {
		String sql = "update persona set estado=1";
		// jdbcTemplate.update(sql,bean.get)

	}

	@Override
	public PersonaModel mapRow(ResultSet rs) throws SQLException {
		PersonaModel bean = new PersonaModel();
		bean.setIdpersona(rs.getInt("idpersona"));
		bean.setIdtpersona(rs.getInt("idtpersona"));
		bean.setApellido(rs.getString("apellido"));
		bean.setNombre(rs.getString("nombre"));
		bean.setDni(rs.getString("email"));
		bean.setTelefono(rs.getString("telefono"));
		bean.setDireccion(rs.getString("direccion"));
		return bean;
	}

}
