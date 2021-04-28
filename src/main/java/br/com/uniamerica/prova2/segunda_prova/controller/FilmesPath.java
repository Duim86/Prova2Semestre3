package br.com.uniamerica.prova2.segunda_prova.controller;

import br.com.uniamerica.prova2.segunda_prova.db.CinemaDAO;
import br.com.uniamerica.prova2.segunda_prova.db.FilmesDAO;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/filmes")
public class FilmesPath {

  @GET
  @Path("")
  @Produces("application/json")
  public Response listar() {
    return Response.ok(new Gson().toJson(FilmesDAO.selectAll())).build();
  }

  @GET
  @Path("criatabela")
  @Produces("application/json")
  public Response criaTabelaFilmes() {
    FilmesDAO.criaTabelaFilmes();
    return Response.ok(new Gson().toJson("Tabela filmes criada com sucesso!")).build();
  }
}

