package java_jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import static java.lang.System.out;

public class PrintJDBCDrivers {
  public static void main(String[] args) {
    Enumeration<Driver> drivers = DriverManager.getDrivers();
    while (drivers.hasMoreElements()) {
      Driver driver = drivers.nextElement();

      out.printf(
          "Nome: %s Versão: %d", driver.getClass().getName(), driver.getMajorVersion());
    }
  }
}
