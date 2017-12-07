package pe.egcc.condominio.dao.espec;

import java.sql.SQLException;
import java.sql.ResultSet;

public interface RowMapper<T> {
T mapRow(ResultSet rs) throws SQLException;
}
