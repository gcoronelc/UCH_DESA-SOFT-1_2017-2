package pe.egcc.eureka.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pe.egcc.eureka.db.AccesoDB;
import pe.egcc.eureka.model.VentaModel;
import pe.egcc.eureka.service.spec.VentaServiceSpec;

public class VentaServiceImpl implements VentaServiceSpec {

  @Override
  public void registrarVenta(VentaModel ventaModel) {
    Connection cn = null;
    try {
      // Calculos de la venta
      calcularVenta(ventaModel);
      // Transaccion
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      // Insertar Venta
      String sql = "insert into venta(fecha,empresa,"
          + "categoria,nombre,precio,cantidad,importe,"
          + "impuesto,total,tganancia,pganancia,ganancia) "
          + "values(GETDATE(),?,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, ventaModel.getEmpresa());
      pstm.setString(2, ventaModel.getCategoria());
      pstm.setString(3, ventaModel.getNombre());
      pstm.setDouble(4, ventaModel.getPrecio());
      pstm.setInt(5, ventaModel.getCantidad());
      pstm.setDouble(6, ventaModel.getImporte());
      pstm.setDouble(7, ventaModel.getImpuesto());
      pstm.setDouble(8, ventaModel.getTotal());
      pstm.setInt(9, ventaModel.getTganancia());
      pstm.setDouble(10, ventaModel.getPganancia());
      pstm.setDouble(11, ventaModel.getGanancia());
      pstm.executeUpdate();
      pstm.close();
      // Recuperar el id
      sql = "select @@identity id";
      pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int id = rs.getInt("id");
      ventaModel.setIdventa(id);
      rs.close();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e2) {
      }
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }    
  }

  private void calcularVenta(VentaModel ventaModel) {
    
    ventaModel.setTganancia(1);
    
  }

  @Override
  public List<Map<String, Object>> conVentas() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Map<String, Object>> conResumen() {
    // TODO Auto-generated method stub
    return null;
  }

 
}
