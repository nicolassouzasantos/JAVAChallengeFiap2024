package br.com.fiap.projeto.dao;

import br.com.fiap.projeto.entity.Produto;
import br.com.fiap.projeto.entity.Servico;
import br.com.fiap.projeto.entity.Utiliza;
import br.com.fiap.projeto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilizaDAO {

    // Método para inserir uma nova associação
    public void inserir(Utiliza utiliza) throws SQLException {
        String sql = "INSERT INTO UTILIZA (SERVICO_ID_SERVICO, PRODUTO_COD_PRODUTO) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, utiliza.getServico().getIdServico());
            stmt.setLong(2, utiliza.getProduto().getCodProduto());

            stmt.executeUpdate();
        }
    }

    // Você pode implementar métodos adicionais conforme necessário, como buscar associações, deletar, etc.
}
