package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Endereco;
import br.com.fiap.projeto.entity.Fornecedor;
import br.com.fiap.projeto.entity.Produto;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedorDAO {

    // Método para inserir um novo fornecedor
    public void inserir(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO FORNECEDOR (CNPJ, TEL_FORNECEDOR, EMAIL_FORNECEDOR, PRODUTO_COD_PRODUTO, ENDERECO_ENDERECO_ID) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setLong(4, fornecedor.getProduto().getCodProduto());
            stmt.setInt(5, fornecedor.getEndereco().getEnderecoId());

            stmt.executeUpdate();
        }
    }

    // Método para buscar um fornecedor pelo CNPJ
    public Fornecedor buscarPorCnpj(String cnpj) throws SQLException {
        String sql = "SELECT * FROM FORNECEDOR WHERE CNPJ = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Produto produto = new ProdutoDAO().buscarPorCodigo(rs.getLong("PRODUTO_COD_PRODUTO"));
                Endereco endereco = new EnderecoDAO().buscarPorId(rs.getInt("ENDERECO_ENDERECO_ID"));
                return new Fornecedor(
                        rs.getString("CNPJ"),
                        rs.getString("TEL_FORNECEDOR"),
                        rs.getString("EMAIL_FORNECEDOR"),
                        produto,
                        endereco
                );
            }
        }
        return null;
    }

    // Método para atualizar um fornecedor
    public void atualizar(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE FORNECEDOR SET TEL_FORNECEDOR = ?, EMAIL_FORNECEDOR = ?, PRODUTO_COD_PRODUTO = ?, ENDERECO_ENDERECO_ID = ? WHERE CNPJ = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getTelefone());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setLong(3, fornecedor.getProduto().getCodProduto());
            stmt.setInt(4, fornecedor.getEndereco().getEnderecoId());
            stmt.setString(5, fornecedor.getCnpj());

            stmt.executeUpdate();
        }
    }

    // Método para deletar um fornecedor
    public void deletar(String cnpj) throws SQLException {
        String sql = "DELETE FROM FORNECEDOR WHERE CNPJ = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            stmt.executeUpdate();
        }
    }
}
