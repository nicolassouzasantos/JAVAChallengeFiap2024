package br.com.fiap.projeto.resource;

import br.com.fiap.projeto.dao.OficinaDAO;
import br.com.fiap.projeto.entity.Oficina;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/oficinas")
public class OficinaResource {

    private OficinaDAO oficinaDAO = new OficinaDAO();

    @GET
    @Path("/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOficina(@PathParam("cnpj") String cnpj) {
        try {
            Oficina oficina = oficinaDAO.buscarPorCnpj(cnpj);
            if (oficina != null) {
                return Response.ok(oficina).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Oficina não encontrada").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar oficina").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOficina(Oficina oficina) {
        try {
            oficinaDAO.inserir(oficina);
            return Response.status(Response.Status.CREATED).entity("Oficina criada com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao criar oficina").build();
        }
    }

    @PUT
    @Path("/{cnpj}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOficina(@PathParam("cnpj") String cnpj, Oficina oficina) {
        try {
            oficina.setCnpj(cnpj);
            oficinaDAO.atualizar(oficina);
            return Response.ok("Oficina atualizada com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar oficina").build();
        }
    }

    @DELETE
    @Path("/{cnpj}")
    public Response deleteOficina(@PathParam("cnpj") String cnpj) {
        try {
            oficinaDAO.deletar(cnpj);
            return Response.noContent().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar oficina").build();
        }
    }
}

