package br.com.bettertech.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.bettertech.DAO.ResultadoreqDAO;

import java.util.List;

@Path("/resultadoreq")
public class ResultadoreqResource {
    private ResultadoreqDAO resultadoreqDAO;

    public ResultadoreqResource() {
        resultadoreqDAO = new ResultadoreqDAO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionarResultadoreq(Resultadoreq resultadoreq) {
        resultadoreqDAO.adicionar(resultadoreq);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarResultadoreqPorId(@PathParam("id") int id) {
        Resultadoreq resultadoreq = resultadoreqDAO.buscarPorId(id);

        if (resultadoreq != null) {
            return Response.ok(resultadoreq).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarTodosResultadoreqs() {
        List<Resultadoreq> resultadoreqs = resultadoreqDAO.buscarTodos();
        return Response.ok(resultadoreqs).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarResultadoreq(@PathParam("id") int id, Resultadoreq resultadoreq) {
        Resultadoreq existingResultadoreq = resultadoreqDAO.buscarPorId(id);

        if (existingResultadoreq != null) {
            resultadoreq.setId(id);
            resultadoreqDAO.atualizar(resultadoreq);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirResultadoreq(@PathParam("id") int id) {
        Resultadoreq existingResultadoreq = resultadoreqDAO.buscarPorId(id);

        if (existingResultadoreq != null) {
            resultadoreqDAO.excluir(id);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

