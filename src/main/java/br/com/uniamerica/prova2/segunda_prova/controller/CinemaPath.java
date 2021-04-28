package br.com.uniamerica.prova2.segunda_prova.controller;

import br.com.uniamerica.prova2.segunda_prova.db.CinemaDAO;
import br.com.uniamerica.prova2.segunda_prova.model.Filmes;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cinema")
public class CinemaPath {

  @GET
  @Path("")
  @Produces("application/json")
  public Response listar() {
    return Response.ok(new Gson().toJson(CinemaDAO.selectAll())).build();
  }

  @GET
  @Path("criatabela")
  @Produces("application/json")
  public Response criaTabelaCinema() {
    CinemaDAO.criaTabelaCinema();
    return Response.ok(new Gson().toJson("Tabela cinema criada com sucesso!")).build();
  }

  @GET
  @Path("/{id}")
  @Produces("application/json")

  public Response buscar(@PathParam("id") Long id)  {
    List<Filmes> listaUser = CinemaDAO.allCinemaFilms(id);
    return Response.ok(new Gson().toJson(listaUser)).build();
  }
}





