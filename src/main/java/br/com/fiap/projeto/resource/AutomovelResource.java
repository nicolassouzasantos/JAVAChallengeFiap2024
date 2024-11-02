package br.com.fiap.projeto.resource;

import br.com.fiap.projeto.dao.AutomovelDAO;
import br.com.fiap.projeto.entity.Automovel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/automoveis")
public class AutomovelResource {

    private AutomovelDAO automovelDAO = new AutomovelDAO();

    @GET
    @Path("/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomovel(@PathParam("placa") String placa) {
        try {
            Automovel automovel = automovelDAO.buscarPorPlaca(placa);
            if (automovel != null) {
                return Response.ok(automovel).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Automóvel não encontrado").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar automóvel").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAutomovel(Automovel automovel) {
        try {
            automovelDAO.inserir(automovel);
            return Response.status(Response.Status.CREATED).entity("Automóvel criado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao criar automóvel").build();
        }
    }

    // Outros métodos (PUT, DELETE) conforme necessário
}
