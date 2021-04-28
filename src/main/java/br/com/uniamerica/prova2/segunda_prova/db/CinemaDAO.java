package br.com.uniamerica.prova2.segunda_prova.db;

import br.com.uniamerica.prova2.segunda_prova.connection.ConnectionFactory;
import br.com.uniamerica.prova2.segunda_prova.model.Cinema;
import br.com.uniamerica.prova2.segunda_prova.model.Filmes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAO {

  public static void criaTabelaCinema() {
    String sql = "CREATE TABLE IF NOT EXISTS cinema(\n" +
            "    cinema_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
            "    nome VARCHAR(40) NOT NULL,\n" +
            "    rua VARCHAR(256) NOT NULL,\n" +
            "    numero VARCHAR(256) NOT NULL,\n" +
            "    complemento VARCHAR(256),\n" +
            "    bairro VARCHAR(256) NOT NULL,\n" +
            "    cidade VARCHAR(256) NOT NULL,\n" +
            "    estado VARCHAR(256) NOT NULL\n" +
            ") ;";
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.execute();
      System.out.println("Tabela Produto criada com sucesso!");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  public static List<Cinema> selectAll() {

    String sql = "SELECT cinema_id, nome, rua, numero, complemento, bairro, cidade, estado FROM cinema ";
    List<Cinema> cinemaList = new ArrayList<>();
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        cinemaList.add(new Cinema(
                rs.getLong("cinema_id"),
                rs.getString("nome"),
                rs.getString("rua"),
                rs.getLong("numero"),
                rs.getString("complemento"),
                rs.getString("bairro"),
                rs.getString("cidade"),
                rs.getString("estado")));

      }
      return cinemaList;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<Filmes> allCinemaFilms(Long id) {
    String sql = "SELECT filmes_id, filmes.nome, descrição, diretor, atores, genero, filmes.cinema_id FROM filmes\n" +
            "INNER JOIN cinema c on filmes.cinema_id = c.cinema_id WHERE c.cinema_id = ?;";

    List<Filmes> userList = new ArrayList<>();
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setLong(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        userList.add(new Filmes(
                rs.getLong("filmes_id"),
                rs.getString("nome"),
                rs.getString("descrição"),
                rs.getString("diretor"),
                rs.getString("atores"),
                rs.getString("genero"),
                rs.getLong("cinema_id")));

      }
      ConnectionFactory.close(conn, ps, rs);
      return userList;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
