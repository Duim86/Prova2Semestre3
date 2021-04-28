package br.com.uniamerica.prova2.segunda_prova.db;

import br.com.uniamerica.prova2.segunda_prova.connection.ConnectionFactory;
import br.com.uniamerica.prova2.segunda_prova.model.Filmes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmesDAO {

  public static void criaTabelaFilmes() {
    String sql = "CREATE TABLE IF NOT EXISTS filmes(\n" +
            "    filmes_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
            "    nome VARCHAR(256) NOT NULL,\n" +
            "    descrição TEXT,\n" +
            "    diretor VARCHAR(256),\n" +
            "    atores VARCHAR(256),\n" +
            "    genero VARCHAR(256),\n" +
            "    cinema_id BIGINT NOT NULL,\n" +
            "  CONSTRAINT cinema_fk" +
            "  FOREIGN KEY (cinema_id)\n" +
            "  REFERENCES cinema (`cinema_id`));";
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)){

      ps.execute();
      System.out.println("Tabela Produto criada com sucesso!");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static List<Filmes> selectAll() {

    String sql = "SELECT filmes_id, filmes.nome, descrição, diretor, atores, genero, cinema_id FROM filmes ";
    List<Filmes> filmesList = new ArrayList<>();
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        filmesList.add(new Filmes(
                rs.getLong("filmes_id"),
                rs.getString("nome"),
                rs.getString("descrição"),
                rs.getString("diretor"),
                rs.getString("atores"),
                rs.getString("genero"),
                rs.getLong("cinema_id")));
      }
      return filmesList;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}