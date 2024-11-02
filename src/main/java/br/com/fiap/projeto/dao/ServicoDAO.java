package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Oficina;
import br.com.fiap.projeto.entity.Servico;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicoDAO {

    // Método para inserir um novo serviço
    public void inserir(Servico servico) throws SQLException {
        String sql = "INSERT INTO SERVICO (ID_SERVICO, TIPO_SERVICO, DURACAO, DELIVERY, OFICINA_CNPJ) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, servico.getIdServico());
            stmt.setString(2, servico.getTipoServico());
            stmt.setString(3, servico.getDuracao());
            stmt.setString(4, String.valueOf(servico.getDelivery()));
            stmt.setString(5, servico.getOficina().getCnpj());

            stmt.executeUpdate();
        }
    }

    // Método para buscar um serviço pelo ID
    public Servico buscarPorId(int idServico) throws SQLException {
        String sql = "SELECT * FROM SERVICO WHERE ID_SERVICO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idServico);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Oficina oficina = new OficinaDAO().buscarPorCnpj(rs.getString("OFICINA_CNPJ"));
                return new Servico(
                        rs.getInt("ID_SERVICO"),
                        rs.getString("TIPO_SERVICO"),
                        rs.getString("DURACAO"),
                        rs.getString("DELIVERY").charAt(0),
                        oficina
                );
            }
        }
        return null;
    }

    // Método para atualizar um serviço
    public void atualizar(Servico servico) throws SQLException {
        String sql = "UPDATE SERVICO SET TIPO_SERVICO = ?, DURACAO = ?, DELIVERY = ?, OFICINA_CNPJ = ? WHERE ID_SERVICO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, servico.getTipoServico());
            stmt.setString(2, servico.getDuracao());
            stmt.setString(3, String.valueOf(servico.getDelivery()));
            stmt.setString(4, servico.getOficina().getCnpj());
            stmt.setInt(5, servico.getIdServico());

            stmt.executeUpdate();
        }
    }

    // Método para deletar um serviço
    public void deletar(int idServico) throws SQLException {
        String sql = "DELETE FROM SERVICO WHERE ID_SERVICO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idServico);
            stmt.executeUpdate();
        }
    }
}
