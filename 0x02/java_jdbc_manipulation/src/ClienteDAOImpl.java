//package src;

import org.jetbrains.annotations.NotNull;

import java.sql.*;

import static java.lang.System.out;

public class ClienteDAOImpl implements ClienteDAO {
  @Override
  public Connection connect(String urlConexao) {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(urlConexao);
      System.out.println("Connection to SQLite has been established.");

    } catch (SQLException e) {
      out.println(e.getMessage());
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        out.println(e.getMessage());
      }
    }
    return connection;
  }

  @Override
  public void createTable(String urlConexao) {
    StringBuffer sql = new StringBuffer();
    sql.append("CREATE TABLE IF NOT EXISTS cliente (");
    sql.append(("id integer PRIMARY KEY , "));
    sql.append(("nome text NOT NULL, "));
    sql.append(("idade integer, "));
    sql.append(("cpf text NOT NULL, "));
    sql.append(("rg text "));
    sql.append(")");

    try (Connection conn = DriverManager.getConnection(urlConexao);
        Statement statement = conn.createStatement()) {
      statement.execute(sql.toString());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void insert(String url_conexao, @NotNull Cliente cliente) {
    String sql = "INSERT INTO cliente(nome,idade, cpf, rg) VALUES(?,?,?,?)";
    try (Connection conn = connect(url_conexao);
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
      preparedStatement.setString(1, cliente.getNome());
      preparedStatement.setInt(2, cliente.getIdade());
      preparedStatement.setString(3, cliente.getCpf());
      preparedStatement.setString(4, cliente.getRg());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void selectAll(String urlConexao) {
    String sql = "SELECT id, nome, idade, cpf, rg FROM cliente";
    try (Connection conn = this.connect(urlConexao);
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql)) {
      while (resultSet.next()) {
        System.out.printf(
            "id %d \t nome %s \t  idade %d \t cpf %s \t rg %s \t",
            resultSet.getInt("id"),
            resultSet.getString("nome"),
            resultSet.getInt("idade"),
            resultSet.getString("cpf"),
            resultSet.getString("rg"));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void update(String urlConexao, int id, String name, Integer idade) {
    String sql = "UPDATE cliente SET nome = ? , + idade = ?    WHERE id = ?";

    try (Connection conn = this.connect(urlConexao);
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
      preparedStatement.setString(1, name);
      preparedStatement.setInt(2, idade);
      preparedStatement.setInt(3, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void delete(String urlConexao, int id) {
    String sql = "DELETE FROM cliente WHERE id = ?";
    try (Connection conn = this.connect(urlConexao);
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
