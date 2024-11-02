package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Produto;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

    // Método para inserir um novo produto
    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (COD_PRODUTO, MARCA, TIPO, NOME, VALOR_PRODUTO) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, produto.getCodProduto());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getTipo());
            stmt.setString(4, produto.getNome());
            stmt.setDouble(5, produto.getValorProduto());

            stmt.executeUpdate();
        }
    }

    // Método para buscar um produto pelo código
    public Produto buscarPorCodigo(long codProduto) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, codProduto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produto(
                        rs.getLong("COD_PRODUTO"),
                        rs.getString("MARCA"),
                        rs.getString("TIPO"),
                        rs.getString("NOME"),
                        rs.getDouble("VALOR_PRODUTO")
                );
            }
        }
        return null;
    }

    // Método para atualizar um produto
    public void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET MARCA = ?, TIPO = ?, NOME = ?, VALOR_PRODUTO = ? WHERE COD_PRODUTO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getMarca());
            stmt.setString(2, produto.getTipo());
            stmt.setString(3, produto.getNome());
            stmt.setDouble(4, produto.getValorProduto());
            stmt.setLong(5, produto.getCodProduto());

            stmt.executeUpdate();
        }
    }

    // Método para deletar um produto
    public void deletar(long codProduto) throws SQLException {
        String sql = "DELETE FROM PRODUTO WHERE COD_PRODUTO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, codProduto);
            stmt.executeUpdate();
        }
    }
}
