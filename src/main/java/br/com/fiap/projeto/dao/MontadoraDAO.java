package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Automovel;
import br.com.fiap.projeto.entity.Montadora;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MontadoraDAO {

    // Método para inserir uma nova montadora
    public void inserir(Montadora montadora) throws SQLException {
        String sql = "INSERT INTO MONTADORA (ID_MONTADORA, CNPJ, NOME, AUTOMOVEL_PLACA) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, montadora.getIdMontadora());
            stmt.setString(2, montadora.getCnpj());
            stmt.setString(3, montadora.getNome());
            stmt.setString(4, montadora.getAutomovel().getPlaca());

            stmt.executeUpdate();
        }
    }

    // Método para buscar uma montadora pelo ID
    public Montadora buscarPorId(int idMontadora) throws SQLException {
        String sql = "SELECT * FROM MONTADORA WHERE ID_MONTADORA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMontadora);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Automovel automovel = new AutomovelDAO().buscarPorPlaca(rs.getString("AUTOMOVEL_PLACA"));
                return new Montadora(
                        rs.getInt("ID_MONTADORA"),
                        rs.getString("CNPJ"),
                        rs.getString("NOME"),
                        automovel
                );
            }
        }
        return null;
    }

    // Método para atualizar uma montadora
    public void atualizar(Montadora montadora) throws SQLException {
        String sql = "UPDATE MONTADORA SET CNPJ = ?, NOME = ?, AUTOMOVEL_PLACA = ? WHERE ID_MONTADORA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, montadora.getCnpj());
            stmt.setString(2, montadora.getNome());
            stmt.setString(3, montadora.getAutomovel().getPlaca());
            stmt.setInt(4, montadora.getIdMontadora());

            stmt.executeUpdate();
        }
    }

    // Método para deletar uma montadora
    public void deletar(int idMontadora) throws SQLException {
        String sql = "DELETE FROM MONTADORA WHERE ID_MONTADORA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMontadora);
            stmt.executeUpdate();
        }
    }
}
