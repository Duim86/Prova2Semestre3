package br.com.uniamerica.prova2.segunda_prova.connection;

import java.sql.*;

public class ConnectionFactory {
  public static Connection getConnection(){
    String url="jdbc:mysql://localhost:3306/db_filmes?createDatabaseIfNotExist=true";
    String user="root";
    String password="admin";

    try {
      return  DriverManager.getConnection(url,user,password);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }
  public static void close(Connection connection){
    try {
      if(connection != null) {
        connection.close();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public static void close(Connection connection, Statement stmt){
    close(connection);
    try {
      if(stmt != null) {
        stmt.close();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
  public static void close(Connection connection, Statement stmt, ResultSet rs){
    close(connection, stmt);
    try {
      if(rs != null) {
        rs.close();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
}
