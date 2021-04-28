package br.com.uniamerica.prova2.segunda_prova.model;

import java.util.Arrays;
import java.util.Objects;

public class Cinema {

  private Long cinema_id;

  private String nome;
  private String rua;
  private Long numero;
  private String complemento;
  private String bairro;
  private String cidade;
  private String estado;

  // Constructor


  public Cinema() {
  }

  public Cinema(Long cinema_id, String nome, String rua, Long numero, String complemento, String bairro, String cidade, String estado) {
    this.cinema_id = cinema_id;
    this.nome = nome;
    this.rua = rua;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
  }

  public Long getCinema_id() {
    return cinema_id;
  }

  public void setCinema_id(Long cinema_id) {
    this.cinema_id = cinema_id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cinema cinema = (Cinema) o;
    return Objects.equals(cinema_id, cinema.cinema_id) && Objects.equals(nome, cinema.nome) && Objects.equals(rua, cinema.rua) && Objects.equals(numero, cinema.numero) && Objects.equals(complemento, cinema.complemento) && Objects.equals(bairro, cinema.bairro) && Objects.equals(cidade, cinema.cidade) && Objects.equals(estado, cinema.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cinema_id, nome, rua, numero, complemento, bairro, cidade, estado);
  }
}