package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoProcessosDAO extends ConexaoBanco
        implements ModelDAO<ProdutoProcessoModel> {

    private final ProdutoDAO produtoDAO;
    private final ProcessoDAO processoDAO;

    public ProdutoProcessosDAO() {
        produtoDAO = new ProdutoDAO();
        processoDAO = new ProcessoDAO();
    }

    @Override
    public BaseDTO criar(ProdutoProcessoModel model) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "INSERT INTO produtos_processos (id_produto, id_processo) VALUES (?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, model.getProduto().getId());
            ps.setInt(2, model.getProcesso().getId());
            ps.execute();

            return BaseDTO.buildSucesso("criado com sucesso!", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar ProdutoProcessos: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(ProdutoProcessoModel modelAtualizado) throws RuntimeException {
        try {
            var conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("CALL spAtualizarProdutoProcesso(?,?,?)");

            ps.setInt(1, modelAtualizado.getProduto().getId());
            ps.setInt(2, modelAtualizado.getProcesso().getId());
            ps.setInt(3, modelAtualizado.getId());
            ps.executeUpdate();

            return BaseDTO.buildSucesso("atualizado com sucesso!", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar ProdutoProcessos: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO deletar(ProdutoProcessoModel model) throws RuntimeException {
        try {
            Connection conexao = connect();
            String sql = "DELETE FROM produtos_processos WHERE ID_PRODUTO_PROCESSo = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, model.getId());
            ps.executeUpdate();

            return BaseDTO.buildSucesso("deletado com sucesso!", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar ProdutoProcessos: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public ProdutoProcessoModel buscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();
            String sql = "SELECT * FROM produtos_processos WHERE ID_PRODUTO_PROCESSO = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ProdutoProcessos por id: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<ProcessoModel> buscarProcessosPorProdutoId(int id) {
        try {
            Connection conexao = connect();
            String sql = "SELECT ID_PROCESSO FROM produtos_processos WHERE ID_PRODUTO = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            List<ProcessoModel> output = new ArrayList<>();
            while (rs.next()) {
                var idProcesso = rs.getInt(1);
                var processo = processoDAO.buscarPorId(idProcesso);
                output.add(processo);
            }

            return output;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ProdutoProcessos por id: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<ProdutoProcessoModel> buscarPorProdutoId(int id) {
        try {
            Connection conexao = connect();
            String sql = "SELECT * FROM produtos_processos WHERE ID_PRODUTO = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            List<ProdutoProcessoModel> output = new ArrayList<>();
            while (rs.next()) {
                var idProdutoProcesso = rs.getInt(1);
                var produto = produtoDAO.buscarPorId(rs.getInt(2));
                var processo = processoDAO.buscarPorId(rs.getInt(3));

                var produtoProcesso = new ProdutoProcessoModel(processo, produto);
                produtoProcesso.setId(idProdutoProcesso);
                output.add(produtoProcesso);
            }

            return output;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ProdutoProcessos por id: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public ProdutoProcessoModel buscar(ProdutoProcessoModel model) throws RuntimeException {
        try {
            var conexao = connect();
            var ps = conexao
                    .prepareStatement("SELECT * FROM produtos_processos WHERE ID_PRODUTO = ? AND ID_PROCESSO = ?");

            ps.setInt(1, model.getProduto().getId());
            ps.setInt(2, model.getProcesso().getId());

            var rs = ps.executeQuery();

            return build(rs);
        } catch (Exception e) {
            throw new RuntimeException("não foi possível buscar o produto processo", e);
        } finally {
            disconnect();
        }
    }

    public Boolean isCadastrado(ProdutoProcessoModel model) {
        return buscar(model) != null;
    }

    private ProdutoProcessoModel build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            var id = rs.getInt(1);
            var idProduto = rs.getInt(2);
            var idProcesso = rs.getInt(3);

            var produto = buscarProdutoPorId(idProduto);
            var processo = buscarProcessoPorId(idProcesso);

            ProdutoProcessoModel produtoProcessos = new ProdutoProcessoModel(processo, produto);
            produtoProcessos.setId(id);

            return produtoProcessos;
        } else {
            return null;
        }
    }

    private ProcessoModel buscarProcessoPorId(int id) {
        return processoDAO.buscarPorId(id);
    }

    private ProdutoModel buscarProdutoPorId(int id) {
        return produtoDAO.buscarPorId(id);
    }
}
