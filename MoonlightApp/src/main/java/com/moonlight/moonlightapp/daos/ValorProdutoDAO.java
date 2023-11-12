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
    public ValorProdutoModel BuscarPorId(int id) throws RuntimeException {
        try {
            var conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM VALORES_PRODUTOS " +
                    "WHERE ID_VALOR_PRODUTO = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o ValorProduto por ID", e);
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

            return BaseDTO.BuildSucesso("cadastrado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(ValorProdutoModel modelAtualizado) {
        try {
            var conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spAtualizarValoresProduto(?, ?)");
            ps.setDouble(1, modelAtualizado.getValorRecomendado());
            ps.setDouble(2, modelAtualizado.getValor());

            ps.execute();

            return BaseDTO.BuildSucesso("atualizado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
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

            return BaseDTO.BuildSucesso("deletado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
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
