package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Automovel;
import br.com.fiap.projeto.entity.Servico;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutomovelDAO {

    // Método para inserir um novo automóvel
    public void inserir(Automovel automovel) throws SQLException {
        String sql = "INSERT INTO AUTOMOVEL (PLACA, ANO, MODELO, MOTORIZACAO, SERVICO_ID_SERVICO) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, automovel.getPlaca());
            stmt.setInt(2, automovel.getAno());
            stmt.setString(3, automovel.getModelo());
            stmt.setDouble(4, automovel.getMotorizacao());
            stmt.setInt(5, automovel.getServico().getIdServico());

            stmt.executeUpdate();
        }
    }

    // Método para buscar um automóvel pela placa
    public static Automovel buscarPorPlaca(String placa) throws SQLException {
        String sql = "SELECT * FROM AUTOMOVEL WHERE PLACA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Servico servico = new ServicoDAO().buscarPorId(rs.getInt("SERVICO_ID_SERVICO"));
                return new Automovel(
                        rs.getString("PLACA"),
                        rs.getInt("ANO"),
                        rs.getString("MODELO"),
                        rs.getDouble("MOTORIZACAO"),
                        servico
                );
            }
        }
        return null;
    }

    // Método para atualizar um automóvel
    public static void atualizar(Automovel automovel) throws SQLException {
        String sql = "UPDATE AUTOMOVEL SET ANO = ?, MODELO = ?, MOTORIZACAO = ?, SERVICO_ID_SERVICO = ? WHERE PLACA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, automovel.getAno());
            stmt.setString(2, automovel.getModelo());
            stmt.setDouble(3, automovel.getMotorizacao());
            stmt.setInt(4, automovel.getServico().getIdServico());
            stmt.setString(5, automovel.getPlaca());

            stmt.executeUpdate();
        }
    }

    // Método para deletar um automóvel
    public static void deletar(String placa) throws SQLException {
        String sql = "DELETE FROM AUTOMOVEL WHERE PLACA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placa);
            stmt.executeUpdate();
        }
    }
}
