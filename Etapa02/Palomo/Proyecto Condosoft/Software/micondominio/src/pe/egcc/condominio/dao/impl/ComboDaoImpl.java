package pe.egcc.condominio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.egcc.condominio.dao.espec.ComboDaoEspec;
import pe.egcc.condominio.model.ComboModel;

@Repository
public class ComboDaoImpl implements ComboDaoEspec {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> traerTPropietarios() {

		List<Map<String, Object>> lista;

		String sql = "select idtpersona codigo,nomtpersona nombre from tpersona";
		lista = jdbcTemplate.queryForList(sql);

		return lista;
	}

	@Override
	public List<Map<String, Object>> traerTipoInmueble() {
		
		List<Map<String, Object>> lista = null;
		String sql = "select idtinmueble codigo, nomtinmueble nombre from tinmueble";
		lista = jdbcTemplate.queryForList(sql);
		return lista;
	}

	@Override
	public List<Map<String, Object>> traerTorre() {
		
		List<Map<String, Object>> lista = null;
		String sql = "select idtorre codigo, nomtorre nombre from torre";
		lista = jdbcTemplate.queryForList(sql);

		return lista;
	}

	@Override
	public ComboModel mapRow(ResultSet rs) throws SQLException {
		return null;
	}

	@Override
	public List<Map<String, Object>> traerPersonas() {
		List<Map<String, Object>> lista=null;
		String sql="select idpersona codigo, nombre nombre from persona";
		lista=jdbcTemplate.queryForList(sql);
		
		return lista;
	}

}
