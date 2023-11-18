package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ValorProdutoModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class ValorProdutoDAO extends ConexaoBanco
        implements ModelDAO<ValorProdutoModel> {

    @Override
    public ValorProdutoModel buscarPorId(int id) throws RuntimeException {
        try {
            var conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM VALORES_PRODUTOS " +
                    "WHERE ID_VALOR_PRODUTO = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o ValorProduto por ID. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO criar(ValorProdutoModel model) {
        try {
            var conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spCriarValoresProdutos(?, ?)");
            ps.setDouble(1, model.getValorRecomendado());
            ps.setDouble(2, model.getValor());

            ps.execute();

            return BaseDTO.buildSucesso("cadastrado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar o ValorProduto. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(ValorProdutoModel modelAtualizado) {
        try {
            var conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spAtualizarProdutoValores(?,?,?)");
            ps.setDouble(1, modelAtualizado.getValorRecomendado());
            ps.setDouble(2, modelAtualizado.getValor());
            ps.setInt(3,modelAtualizado.getId());

            ps.execute();

            return BaseDTO.buildSucesso("atualizado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o ValorProduto. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO deletar(ValorProdutoModel model) {
        try {
            var conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spDeletarValoresProdutos(?)");
            ps.setInt(1, model.getId());

            ps.execute();

            return BaseDTO.buildSucesso("deletado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o ValorProduto. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private ValorProdutoModel build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            int idValorProduto = rs.getInt(1);
            double valorRecomendado = rs.getDouble(2);
            double valor = rs.getDouble(3);

            ValorProdutoModel model = new ValorProdutoModel(valorRecomendado, valor);
            model.setId(idValorProduto);
            return model;
        } else {
            return null;
        }
    }
}
