package pe.egcc.condominio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.egcc.condominio.dao.espec.LoginDaoEspec;
import pe.egcc.condominio.model.PersonaModel;

@Repository
public class LoginDaoImpl implements LoginDaoEspec{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	@Override
	public PersonaModel validar(String usuario, String clave) {
		PersonaModel bean = null;
		try {
			String sql = "select p.idpersona,p.idtpersona,p.apellido,"
					+ "p.nombre,p.dni,p.email,p.telefono,p.direccion,u.idrol " + "from persona p "
					+ "join usuario u on p.idpersona = u.idpersona " + "where p.idpersona in (select idpersona "
					+ "from usuario " + "where usuario = ? and clave = SHA(?) " + "and estado = 1)";
			bean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(PersonaModel.class), usuario, clave);
		} catch (EmptyResultDataAccessException e) {
			throw new RuntimeException("Datos incorrectos.");
		}
		return bean;
	}
	
	@Override
	public PersonaModel mapRow(ResultSet rs) throws SQLException {
		
        PersonaModel bean = new PersonaModel();
        
        bean.setIdpersona(rs.getInt("idpersona"));
        bean.setIdtpersona(rs.getInt("idtpersona"));
        bean.setApellido(rs.getString("apellidos"));
        bean.setNombre(rs.getString("nombre"));
        bean.setDni(rs.getString("dni"));
        bean.setTelefono(rs.getString("telefono"));
        bean.setDireccion(rs.getString("direccion"));        
        return bean;
	}
	

}
