package br.com.fiap.projeto.resource;

import br.com.fiap.projeto.dao.MontadoraDAO;
import br.com.fiap.projeto.entity.Montadora;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/montadoras")
public class MontadoraResource {

    private MontadoraDAO montadoraDAO = new MontadoraDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMontadora(@PathParam("id") int id) {
        try {
            Montadora montadora = montadoraDAO.buscarPorId(id);
            if (montadora != null) {
                return Response.ok(montadora).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Montadora não encontrada").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar montadora").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMontadora(Montadora montadora) {
        try {
            montadoraDAO.inserir(montadora);
            return Response.status(Response.Status.CREATED).entity("Montadora criada com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao criar montadora").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMontadora(@PathParam("id") int id, Montadora montadora) {
        try {
            montadora.setIdMontadora(id);
            montadoraDAO.atualizar(montadora);
            return Response.ok("Montadora atualizada com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar montadora").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMontadora(@PathParam("id") int id) {
        try {
            montadoraDAO.deletar(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar montadora").build();
        }
    }
}
