package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Endereco;
import br.com.fiap.projeto.entity.Oficina;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OficinaDAO {

    // Método para inserir uma nova oficina
    public void inserir(Oficina oficina) throws SQLException {
        String sql = "INSERT INTO OFICINA (CNPJ, NOME_FANTASIA, TIPO, ENDERECO_ENDERECO_ID) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, oficina.getCnpj());
            stmt.setString(2, oficina.getNomeFantasia());
            stmt.setString(3, oficina.getTipo());
            stmt.setInt(4, oficina.getEndereco().getEnderecoId());

            stmt.executeUpdate();
        }
    }

    // Método para buscar uma oficina pelo CNPJ
    public Oficina buscarPorCnpj(String cnpj) throws SQLException {
        String sql = "SELECT * FROM OFICINA WHERE CNPJ = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Endereco endereco = new EnderecoDAO().buscarPorId(rs.getInt("ENDERECO_ENDERECO_ID"));
                return new Oficina(
                        rs.getString("CNPJ"),
                        rs.getString("NOME_FANTASIA"),
                        rs.getString("TIPO"),
                        endereco
                );
            }
        }
        return null;
    }

    // Método para atualizar uma oficina
    public void atualizar(Oficina oficina) throws SQLException {
        String sql = "UPDATE OFICINA SET NOME_FANTASIA = ?, TIPO = ?, ENDERECO_ENDERECO_ID = ? WHERE CNPJ = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, oficina.getNomeFantasia());
            stmt.setString(2, oficina.getTipo());
            stmt.setInt(3, oficina.getEndereco().getEnderecoId());
            stmt.setString(4, oficina.getCnpj());

            stmt.executeUpdate();
        }
    }

    // Método para deletar uma oficina
    public void deletar(String cnpj) throws SQLException {
        String sql = "DELETE FROM OFICINA WHERE CNPJ = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            stmt.executeUpdate();
        }
    }
}

