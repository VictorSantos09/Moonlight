package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public final class ProdutoDAO extends ConexaoBanco
        implements ModelDAO<ProdutoModel>, BuscarPorNomeDAO<ProdutoModel> {
    private final ValorProdutoDAO valorProdutoDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final ProcessoDAO processoDAO;

    public ProdutoDAO() {
        valorProdutoDAO = new ValorProdutoDAO();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
        processoDAO = new ProcessoDAO();
    }

    @Override
    public BaseDTO criar(ProdutoModel model) {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spCriarProduto(?, ?, ?, ?, ?, ?)");
            ps.setString(1, model.getNome());
            ps.setString(2, model.getDescricao());
            ps.setDouble(3, model.getValorProduto().getValorRecomendado());
            ps.setDouble(4, model.getValorProduto().getValor());
            ps.setInt(5, model.getUnidadeMedida().getId());
            ps.setInt(6, model.getTipo().getId());

            ps.execute();

            return BaseDTO.buildSucesso("Produto criado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar produto: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(ProdutoModel modelAtualizado) {
        try {
            Connection conexao = connect();

            var ps = conexao.prepareStatement("CALL spAtualizarProduto(?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, modelAtualizado.getId());
            ps.setString(2, modelAtualizado.getDescricao());
            ps.setDouble(3, modelAtualizado.getValorProduto().getValorRecomendado());
            ps.setDouble(4, modelAtualizado.getValorProduto().getValor());
            ps.setInt(5, modelAtualizado.getUnidadeMedida().getId());
            ps.setInt(6, modelAtualizado.getTipo().getId());
            ps.executeUpdate();

            return BaseDTO.buildSucesso("Produto atualizado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
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

            return BaseDTO.buildSucesso("Produto deletado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public ProdutoModel buscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos WHERE ID_PRODUTO = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            return Build(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto por ID: " + e.getMessage());
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
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto por nome. Erro: " + e.getMessage());
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
            int idUnidadeMedida = rs.getInt(5);
            int idTipoProduto = rs.getInt(6);

            ValorProdutoModel valorProduto = buscarValorProdutoPorId(idValorProduto);
            UnidadeMedidaModel unidadeMedida = buscarUnidadeMedidaPorId(idUnidadeMedida);
            TipoProdutoModel tipoProduto = buscarTipoProdutoPorId(idTipoProduto);
            List<ProcessoModel> processos = buscarProcessosPorProdutoId(idProduto);

            ProdutoModel produto = new ProdutoModel(nome, descricao, unidadeMedida, tipoProduto,
                    processos, valorProduto.getValorRecomendado(), valorProduto.getValor());

            produto.setId(idProduto);

            return produto;
        } else {
            return null;
        }
    }

    private ValorProdutoModel buscarValorProdutoPorId(int id) {
        return valorProdutoDAO.buscarPorId(id);
    }

    private UnidadeMedidaModel buscarUnidadeMedidaPorId(int id) {
        return unidadeMedidaDAO.buscarPorId(id);
    }

    private TipoProdutoModel buscarTipoProdutoPorId(int id) {
        return tipoProdutoDAO.buscarPorId(id);
    }

    private List<ProcessoModel> buscarProcessosPorProdutoId(int id) {
        return processoDAO.buscarPorProdutoId(id);
    }
}