package pe.egcc.condominio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.egcc.condominio.dao.espec.InmuebleDaoEspec;
import pe.egcc.condominio.model.InmuebleModel;

@Repository
public class InmuebleDaoImpl implements InmuebleDaoEspec {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> traerLista() {
		List<Map<String, Object>> lista;
		String sql = "select i.idinmueble,i.piso,i.codigo,p.nombre,p.apellido,i.descripcion,i.idpersona,"
				+ "i.idtinmueble,z.nombre,i.idtorre,t.nombre, i.activo,z.agua,z.mantenimiento from inmueble i "
				+ "join torre t on t.idtorre=i.idtorre " + "join persona p on p.idpersona=i.idpersona "
				+ "join tinmueble z on z.idtinmueble=i.idtinmueble";
		lista = jdbcTemplate.queryForList(sql);

		return lista;
	}

	@Override
	public void insertar(InmuebleModel bean) {
		String sql = "insert into inmueble(idinmueble,piso,numero,"
				+ "descripcion,idpersona,idtinmueble,idtorre,activo)"
				+ " values (?,?,?,?,?,?,?,1)";
		jdbcTemplate.update(sql, bean.toArrayInsert());

	}

	@Override
	public void actualizar(InmuebleModel bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(InmuebleModel bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public InmuebleModel mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> listaInmueblePropietario(int idpersona) {
		List<Map<String, Object>> lista = null;
		try {
			String sql = "select i.idinmueble,i.piso,i.numero,p.nombre,p.apellido,i.descripcion,i.idpersona,"
					+ "i.idtinmueble,z.nomtinmueble,i.idtorre,t.nomtorre, i.activo from inmueble i "
					+ "join torre t on t.idtorre=i.idtorre " + "join persona p on p.idpersona=i.idpersona "
					+ "join tinmueble z on z.idtinmueble=i.idtinmueble" + " where i.idpersona=?";
			lista = jdbcTemplate.queryForList(sql, idpersona);
		} catch (EmptyResultDataAccessException e) {
			throw new RuntimeException("no se encontraron inmuebles");
		}

		return lista;
	}

}
