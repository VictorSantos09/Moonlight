package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorIdDAO;
import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.models.TipoProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoProdutoDAO extends ConexaoBanco
        implements BuscarPorNomeDAO<TipoProdutoModel>, BuscarPorIdDAO<TipoProdutoModel> {

    @Override
    public TipoProdutoModel buscarPorNome(String name) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM tipos_produtos WHERE NOME = ?";

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

            String sql = "SELECT * FROM tipos_produtos WHERE ID_TIPO_PRODUTO = ?";

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

    public List<TipoProdutoModel> buscarTodos() throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM tipos_produtos";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            return buildList(rs);
        } catch (SQLException e) {
            throw new RuntimeException("um erro ocorreu ao buscar todos os tipos de produtos. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public Boolean isCadastrado(String nome) {
        return buscarPorNome(nome) != null;
    }

    private TipoProdutoModel build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            var id = rs.getInt(1);
            String nome = rs.getString(2);

            TipoProdutoModel tipoProduto = new TipoProdutoModel(nome);
            tipoProduto.setId(id);

            return tipoProduto;
        } else {
            return null;
        }
    }

    private List<TipoProdutoModel> buildList(ResultSet rs) throws SQLException {
        List<TipoProdutoModel> tiposProdutos = new ArrayList<>();

        while (rs.next()) {
            var id = rs.getInt(1);
            String nome = rs.getString(2);

            TipoProdutoModel tipoProduto = new TipoProdutoModel(nome);
            tipoProduto.setId(id);

            tiposProdutos.add(tipoProduto);
        }

        return tiposProdutos.isEmpty() ? List.of() : tiposProdutos;
    }
}
