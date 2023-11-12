package com.moonlight.moonlightapp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.ValorProdutoModel;

public final class ProdutoDAO extends ConexaoBanco
        implements ModelDAO<ProdutoModel>, BuscarPorNomeDAO<ProdutoModel> {

    private final ValorProdutoDAO _valorProdutoDAO;

    public ProdutoDAO() {
        _valorProdutoDAO = new ValorProdutoDAO();
    }

    @Override
    public BaseDTO criar(ProdutoModel model) {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spCriarProduto(?, ?, ?, ?)");
            ps.setString(1, model.getNome());
            ps.setString(2, model.getDescricao());
            ps.setDouble(3, model.getValorProduto().getValorRecomendado());
            ps.setDouble(4, model.getValorProduto().getValor());

            ps.execute();

            return BaseDTO.BuildSucesso("Produto criado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(ProdutoModel modelAtualizado) {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("UPDATE produtos SET NOME = ?, DESCRICAO = ? WHERE ID = ?");
            ps.setString(1, modelAtualizado.getNome());
            ps.setString(2, modelAtualizado.getDescricao());
            ps.setInt(3, modelAtualizado.getId());

            ps.executeUpdate();

            return BaseDTO.BuildSucesso("Produto atualizado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO deletar(ProdutoModel model) {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("DELETE FROM produtos WHERE ID = ?");
            ps.setInt(1, model.getId());

            ps.executeUpdate();

            return BaseDTO.BuildSucesso("Produto deletado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        } finally {
            disconnect();
        }
    }

    @Override
    public ProdutoModel BuscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos WHERE ID_PRODUTO = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            return Build(rs);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto por ID", e);
        } finally {
            disconnect();
        }
    }

    @Override
    public ProdutoModel buscarPorNome(String name) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos WHERE NOME = ?");

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            return Build(rs);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto por nome. Erro: ", e);
        } finally {
            disconnect();
        }
    }

    private ProdutoModel Build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            int idProduto = rs.getInt(1);
            String nome = rs.getString(2);
            String descricao = rs.getString(3);
            int idValorProduto = rs.getInt(4);

            ValorProdutoModel valorProduto = BuscarValorProduto(idValorProduto);

            ProdutoModel produto = new ProdutoModel(nome, descricao, valorProduto);
            produto.setId(idProduto);

            return produto;
        } else {
            return null;
        }
    }

    private ValorProdutoModel BuscarValorProduto(int id) {
        return _valorProdutoDAO.BuscarPorId(id);
    }
}