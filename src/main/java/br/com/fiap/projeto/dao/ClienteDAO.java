package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Automovel;
import br.com.fiap.projeto.entity.Cliente;
import br.com.fiap.projeto.entity.Endereco;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    // Método para inserir um novo cliente
    public void inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO CLIENTE (CPF, NOME, TEL_CLIENTE, EMAIL_CLIENTE, AUTOMOVEL_PLACA, ENDERECO_ENDERECO_ID) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getAutomovel().getPlaca());
            stmt.setInt(6, cliente.getEndereco().getEnderecoId());

            stmt.executeUpdate();
        }
    }

    // Método para buscar um cliente pelo CPF
    public Cliente buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM CLIENTE WHERE CPF = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Automovel automovel = new AutomovelDAO().buscarPorPlaca(rs.getString("AUTOMOVEL_PLACA"));
                Endereco endereco = new EnderecoDAO().buscarPorId(rs.getInt("ENDERECO_ENDERECO_ID"));
                return new Cliente(
                        rs.getString("CPF"),
                        rs.getString("NOME"),
                        rs.getString("TEL_CLIENTE"),
                        rs.getString("EMAIL_CLIENTE"),
                        automovel,
                        endereco
                );
            }
        }
        return null;
    }

    // Método para atualizar um cliente
    public void atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE CLIENTE SET NOME = ?, TEL_CLIENTE = ?, EMAIL_CLIENTE = ?, AUTOMOVEL_PLACA = ?, ENDERECO_ENDERECO_ID = ? WHERE CPF = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getAutomovel().getPlaca());
            stmt.setInt(5, cliente.getEndereco().getEnderecoId());
            stmt.setString(6, cliente.getCpf());

            stmt.executeUpdate();
        }
    }

    // Método para deletar um cliente
    public void deletar(String cpf) throws SQLException {
        String sql = "DELETE FROM CLIENTE WHERE CPF = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();
        }
    }
}
