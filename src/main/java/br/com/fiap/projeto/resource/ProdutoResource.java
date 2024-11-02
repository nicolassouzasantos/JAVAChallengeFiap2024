package br.com.fiap.projeto.resource;

import br.com.fiap.projeto.dao.ProdutoDAO;
import br.com.fiap.projeto.entity.Produto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/produtos")
public class ProdutoResource {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduto(@PathParam("codigo") long codigo) {
        try {
            Produto produto = produtoDAO.buscarPorCodigo(codigo);
            if (produto != null) {
                return Response.ok(produto).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Produto não encontrado").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar produto").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduto(Produto produto) {
        try {
            produtoDAO.inserir(produto);
            return Response.status(Response.Status.CREATED).entity("Produto criado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao criar produto").build();
        }
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduto(@PathParam("codigo") long codigo, Produto produto) {
        try {
            produto.setCodProduto(codigo);
            produtoDAO.atualizar(produto);
            return Response.ok("Produto atualizado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar produto").build();
        }
    }

    @DELETE
    @Path("/{codigo}")
    public Response deleteProduto(@PathParam("codigo") long codigo) {
        try {
            produtoDAO.deletar(codigo);
            return Response.noContent().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar produto").build();
        }
    }
}
