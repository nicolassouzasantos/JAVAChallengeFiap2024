package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Endereco;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {

    // Método para inserir um novo endereço
    public void inserir(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO ENDERECO (ENDERECO_ID, CIDADE, UF, CEP, RUA, NUMERO, COMPLEMENTO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, endereco.getEnderecoId());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getUf());
            stmt.setString(4, endereco.getCep());
            stmt.setString(5, endereco.getRua());
            stmt.setString(6, endereco.getNumero());
            stmt.setString(7, endereco.getComplemento());

            stmt.executeUpdate();
        }
    }

    // Método para buscar um endereço pelo ID
    public Endereco buscarPorId(int enderecoId) throws SQLException {
        String sql = "SELECT * FROM ENDERECO WHERE ENDERECO_ID = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enderecoId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Endereco(
                        rs.getInt("ENDERECO_ID"),
                        rs.getString("CIDADE"),
                        rs.getString("UF"),
                        rs.getString("CEP"),
                        rs.getString("RUA"),
                        rs.getString("NUMERO"),
                        rs.getString("COMPLEMENTO")
                );
            }
        }
        return null;
    }

    // Método para atualizar um endereço
    public void atualizar(Endereco endereco) throws SQLException {
        String sql = "UPDATE ENDERECO SET CIDADE = ?, UF = ?, CEP = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ? WHERE ENDERECO_ID = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, endereco.getCidade());
            stmt.setString(2, endereco.getUf());
            stmt.setString(3, endereco.getCep());
            stmt.setString(4, endereco.getRua());
            stmt.setString(5, endereco.getNumero());
            stmt.setString(6, endereco.getComplemento());
            stmt.setInt(7, endereco.getEnderecoId());

            stmt.executeUpdate();
        }
    }

    // Método para deletar um endereço
    public void deletar(int enderecoId) throws SQLException {
        String sql = "DELETE FROM ENDERECO WHERE ENDERECO_ID = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enderecoId);
            stmt.executeUpdate();
        }
    }
}
