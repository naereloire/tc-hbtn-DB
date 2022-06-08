package java_jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import static java.lang.System.out;

public class PrintJDBCDrivers {
  public static void main(String[] args) {
    Enumeration<Driver> drivers = DriverManager.getDrivers();
    while (drivers.hasMoreElements())
      out.printf(
              "Nome: %s %n",
          drivers.nextElement().getClass().getSimpleName());
  }
}
