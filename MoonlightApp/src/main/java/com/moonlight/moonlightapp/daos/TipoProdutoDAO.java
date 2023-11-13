package com.moonlight.moonlightapp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorIdDAO;
import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.models.TipoProdutoModel;

public class TipoProdutoDAO extends ConexaoBanco
        implements BuscarPorNomeDAO<TipoProdutoModel>, BuscarPorIdDAO<TipoProdutoModel> {

    @Override
    public TipoProdutoModel buscarPorNome(String name) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM tipo_produto WHERE nome = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("um erro ocorreu ao buscar o tipo de produto por nome. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public TipoProdutoModel buscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM tipo_produto WHERE ID_TIPO_PRODUTO = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("um erro ocorreu ao buscar o tipo de produto por id. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private TipoProdutoModel build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            var id = rs.getInt(1);
            String nome = rs.getString(2);

            var tipoProduto = new TipoProdutoModel(nome);
            tipoProduto.setId(id);

            return tipoProduto;
        } else {
            return null;
        }
    }
}
