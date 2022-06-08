package java_jdbc;

import java.sql.*;

import static java.lang.System.*;

public class ConnectionSQLite {
  private static void initConnection() {
    String url = "jdbc:sqlite:sqlite_database_2022.db";
    try (Connection connection = DriverManager.getConnection(url)) {

      out.println("Conexão realizada !!!!");

    } catch (SQLException e) {
      out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    initConnection();
  }
}
