package app.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

  private static final String DB_NAME = "mahasiswa";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "";

  public static Connection connect() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/"+DB_NAME, DB_USER, DB_PASSWORD);
    return con;
  }

}
