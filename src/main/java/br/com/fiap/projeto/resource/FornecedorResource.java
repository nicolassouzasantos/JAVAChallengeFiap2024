package br.com.fiap.projeto.resource;

import br.com.fiap.projeto.dao.FornecedorDAO;
import br.com.fiap.projeto.entity.Fornecedor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/fornecedores")
public class FornecedorResource {

    private FornecedorDAO fornecedorDAO = new FornecedorDAO();

    @GET
    @Path("/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFornecedor(@PathParam("cnpj") String cnpj) {
        try {
            Fornecedor fornecedor = fornecedorDAO.buscarPorCnpj(cnpj);
            if (fornecedor != null) {
                return Response.ok(fornecedor).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Fornecedor não encontrado").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar fornecedor").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFornecedor(Fornecedor fornecedor) {
        try {
            fornecedorDAO.inserir(fornecedor);
            return Response.status(Response.Status.CREATED).entity("Fornecedor criado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao criar fornecedor").build();
        }
    }

    @PUT
    @Path("/{cnpj}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFornecedor(@PathParam("cnpj") String cnpj, Fornecedor fornecedor) {
        try {
            fornecedor.setCnpj(cnpj);
            fornecedorDAO.atualizar(fornecedor);
            return Response.ok("Fornecedor atualizado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar fornecedor").build();
        }
    }

    @DELETE
    @Path("/{cnpj}")
    public Response deleteFornecedor(@PathParam("cnpj") String cnpj) {
        try {
            fornecedorDAO.deletar(cnpj);
            return Response.noContent().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar fornecedor").build();
        }
    }
}
