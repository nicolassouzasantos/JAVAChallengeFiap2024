package br.com.fiap.projeto.resource;

import br.com.fiap.projeto.dao.ClienteDAO;
import br.com.fiap.projeto.entity.Cliente;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/clientes")
public class ClienteResource {

    private ClienteDAO clienteDAO = new ClienteDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClientes() {
        try {
            // Implemente o método para recuperar todos os clientes
            // Por simplicidade, não implementarei aqui
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar clientes").build();
        }
    }

    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("cpf") String cpf) {
        try {
            Cliente cliente = clienteDAO.buscarPorCpf(cpf);
            if (cliente != null) {
                return Response.ok(cliente).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar cliente").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(Cliente cliente) {
        try {
            clienteDAO.inserir(cliente);
            return Response.status(Response.Status.CREATED).entity("Cliente criado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao criar cliente").build();
        }
    }

    @PUT
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCliente(@PathParam("cpf") String cpf, Cliente cliente) {
        try {
            cliente.setCpf(cpf);
            clienteDAO.atualizar(cliente);
            return Response.ok("Cliente atualizado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar cliente").build();
        }
    }

    @DELETE
    @Path("/{cpf}")
    public Response deleteCliente(@PathParam("cpf") String cpf) {
        try {
            clienteDAO.deletar(cpf);
            return Response.noContent().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar cliente").build();
        }
    }
}
