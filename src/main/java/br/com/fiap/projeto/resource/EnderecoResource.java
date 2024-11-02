package br.com.fiap.projeto.resource;

import br.com.fiap.projeto.dao.EnderecoDAO;
import br.com.fiap.projeto.entity.Endereco;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/enderecos")
public class EnderecoResource {

    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEndereco(@PathParam("id") int id) {
        try {
            Endereco endereco = enderecoDAO.buscarPorId(id);
            if (endereco != null) {
                return Response.ok(endereco).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Endereço não encontrado").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar endereço").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEndereco(Endereco endereco) {
        try {
            enderecoDAO.inserir(endereco);
            return Response.status(Response.Status.CREATED).entity("Endereço criado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao criar endereço").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEndereco(@PathParam("id") int id, Endereco endereco) {
        try {
            endereco.setEnderecoId(id);
            enderecoDAO.atualizar(endereco);
            return Response.ok("Endereço atualizado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar endereço").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEndereco(@PathParam("id") int id) {
        try {
            enderecoDAO.deletar(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar endereço").build();
        }
    }
}
