package pe.egcc.condominio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.egcc.condominio.dao.espec.ReciboDaoEspec;
import pe.egcc.condominio.model.ReciboModel;

@Repository
public class ReciboDaoImpl implements ReciboDaoEspec {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> traerLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(ReciboModel bean) {
		String sql = "insert into recibo(idrecibo,idtobligacion,codigo,anio,mes,"
	+ "fecVen,importe) "
				+ "values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, bean.toArrayInsert());

	}

	@Override
	public void actualizar(ReciboModel bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(ReciboModel bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public ReciboModel mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
