package br.com.uniamerica.prova2.segunda_prova.model;

import java.util.Objects;

public class Filmes {
  private Long filmes_id;
  private String nome;
  private String descricao;
  private String diretor;
  private String atores;
  private String genero;
  private Long cinema_id;

  public Filmes() {
  }

  public Filmes(Long filmes_id, String nome, String descricao, String diretor, String atores, String genero, Long cinema_id) {
    this.filmes_id = filmes_id;
    this.nome = nome;
    this.descricao = descricao;
    this.diretor = diretor;
    this.atores = atores;
    this.genero = genero;
    this.cinema_id = cinema_id;
  }

  public Long getFilmes_id() {
    return filmes_id;
  }

  public void setFilmes_id(Long filmes_id) {
    this.filmes_id = filmes_id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getDiretor() {
    return diretor;
  }

  public void setDiretor(String diretor) {
    this.diretor = diretor;
  }

  public String getAtores() {
    return atores;
  }

  public void setAtores(String atores) {
    this.atores = atores;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Long getCinema_id() {
    return cinema_id;
  }

  public void setCinema_id(Long cinema_id) {
    this.cinema_id = cinema_id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Filmes filmes = (Filmes) o;
    return Objects.equals(filmes_id, filmes.filmes_id) && Objects.equals(nome, filmes.nome) && Objects.equals(descricao, filmes.descricao) && Objects.equals(diretor, filmes.diretor) && Objects.equals(atores, filmes.atores) && Objects.equals(genero, filmes.genero) && Objects.equals(cinema_id, filmes.cinema_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filmes_id, nome, descricao, diretor, atores, genero, cinema_id);
  }
}
