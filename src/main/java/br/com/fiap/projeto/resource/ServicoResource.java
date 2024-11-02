package br.com.fiap.projeto.resource;

import br.com.fiap.projeto.dao.ServicoDAO;
import br.com.fiap.projeto.entity.Servico;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/servicos")
public class ServicoResource {

    private ServicoDAO servicoDAO = new ServicoDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServico(@PathParam("id") int id) {
        try {
            Servico servico = servicoDAO.buscarPorId(id);
            if (servico != null) {
                return Response.ok(servico).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Serviço não encontrado").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar serviço").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createServico(Servico servico) {
        try {
            servicoDAO.inserir(servico);
            return Response.status(Response.Status.CREATED).entity("Serviço criado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao criar serviço").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateServico(@PathParam("id") int id, Servico servico) {
        try {
            servico.setIdServico(id);
            servicoDAO.atualizar(servico);
            return Response.ok("Serviço atualizado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar serviço").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteServico(@PathParam("id") int id) {
        try {
            servicoDAO.deletar(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar serviço").build();
        }
    }
}
