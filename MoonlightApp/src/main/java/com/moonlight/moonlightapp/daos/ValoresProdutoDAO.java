package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.ValoresProdutoModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValoresProdutoDAO extends ConexaoBanco
        implements ModelDAO<ValoresProdutoModel> {
    private final ProdutoDAO _produtoDAO;

    public ValoresProdutoDAO() {
        this._produtoDAO = new ProdutoDAO();
    }

    @Override
    public ValoresProdutoModel BuscarPorId(int id) throws RuntimeException {
        try {
            var conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM VALORES_PRODUTOS " +
                    "WHERE ID_VALOR_PRODUTO = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return build(rs);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o ValoresProduto por ID", e);
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO criar(ValoresProdutoModel model) {
        try {
            var conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("CALL spCriarValoresProdutos(?, ?, ?)");
            ps.setDouble(1, model.getValorRecomendado());
            ps.setDouble(2, model.getValor());
            ps.setInt(3, model.getProduto().getId());
            ps.execute();
            return BaseDTO.BuildSucesso("cadastrado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(ValoresProdutoModel modelAtualizado) {
        try {
            var conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("CALL spAtualizarValoresProduto(?, ?, ?)");
            ps.setDouble(1, modelAtualizado.getValorRecomendado());
            ps.setDouble(2, modelAtualizado.getValor());
            ps.setInt(3, modelAtualizado.getProduto().getId());
            ps.execute();
            return BaseDTO.BuildSucesso("atualizado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO deletar(ValoresProdutoModel model) {
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

    private ValoresProdutoModel build(ResultSet resultSet) throws SQLException {
        double valorRecomendado = resultSet.getDouble("VALOR_RECOMENDADO");
        double valor = resultSet.getDouble("VALOR");
        int idProduto = resultSet.getInt("ID_PRODUTO");

        ProdutoModel produto = buscarProdutoPorId(idProduto);
        ValoresProdutoModel model = new ValoresProdutoModel(valorRecomendado, valor, produto);
        return model;
    }

    private ProdutoModel buscarProdutoPorId(int id) {
        ProdutoModel model = _produtoDAO.BuscarPorId(id);
        return model;
    }
}
