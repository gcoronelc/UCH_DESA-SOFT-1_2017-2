package pe.egcc.eureka.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AccesoDB {
  
  // Parámetros de conexión
  private static final String CN_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  private static final String CN_URL = "jdbc:sqlserver://localhost:1433;" +  
	         "databaseName=ventas;user=sa;password=123456";
  private static final String CN_USER = "sa";
  private static final String CN_PASS = "123456";
  
  
  private AccesoDB() {
  }

  public static Connection getConnection() throws SQLException {
    Connection cn = null;
    try {

      // Cargar el driver a memoria
      Class.forName(CN_DRIVER).newInstance();
      // Obtener el objeto Connection
      cn = DriverManager.getConnection(CN_URL, CN_USER, CN_PASS);
    } catch (SQLException e) {
      throw e;
    } catch (ClassNotFoundException e) {
      throw new SQLException("ERROR, no se encuentra el driver.");
    } catch (Exception e) {
      throw new SQLException("ERROR, no se tiene acceso al servidor.");
    }
    return cn;
  }

}
