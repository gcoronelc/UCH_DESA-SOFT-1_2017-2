package pe.egcc.eureka.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pe.egcc.eureka.db.AccesoDB;
import pe.egcc.eureka.service.spec.EurekaServiceSpec;

public class EurekaServiceImpl implements EurekaServiceSpec {

  @Override
  public List<Map<String, Object>> conMovimientos(String cuenta) {
    List<Map<String, Object>> lista = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select cuencodigo, monenombre,"
          + "cuensaldo,cuenestado,movinumero,"
          + "movifecha,moviimporte,tipocodigo,"
          + "tiponombre from v_movimiento "
          + "where cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      lista = JdbcUtil.rsToList(rs);
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("Error en la consulta.");
    } finally {
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }
    return lista;
  }

}
