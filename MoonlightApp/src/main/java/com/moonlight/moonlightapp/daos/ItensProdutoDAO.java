package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ItensProdutoModel;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.ProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItensProdutoDAO extends ConexaoBanco
        implements ModelDAO<ItensProdutoModel> {

    private final ProdutoDAO _produtoDAO;
    private final MateriaPrimaDAO _materiaPrimaDAO;

    public ItensProdutoDAO() {
        _produtoDAO = new ProdutoDAO();
        _materiaPrimaDAO = new MateriaPrimaDAO();
    }

    @Override
    public ItensProdutoModel buscarPorId(int id) throws RuntimeException {
        try {
            Connection conexa = connect();

            PreparedStatement ps = conexa.prepareStatement("SELECT * FROM ITENS_PRODUTOS WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            return build(rs).getFirst();
        } catch (SQLException e) {
            throw new RuntimeException("Um erro ocorreu ao buscar o ItensProduto por ID: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<ItensProdutoModel> buscarPorProdutoId(int idProduto) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM itens_produtos WHERE ID_PRODUTO = ?");
            ps.setInt(1, idProduto);

            ResultSet rs = ps.executeQuery();
            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException(
                    "Um erro ocorreu ao buscar os itensProdutos por meio do produto: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO criar(ItensProdutoModel model) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spCriarItensProduto(?, ?, ?, ?)");
            ps.setInt(1, model.getProduto().getId());
            ps.setInt(2, model.getMateriaPrima().getId());
            ps.setInt(3, model.getQuantidade());
            ps.setDouble(4, model.getSubTotal());

            ps.execute();

            return BaseDTO.buildSucesso("item cadastrado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Um erro ocorreu ao criar o item: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(ItensProdutoModel modelAtualizado) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spAtualizarItensProduto(?, ?, ? , ?, ?)");
            ps.setInt(1, modelAtualizado.getQuantidade());
            ps.setInt(2, modelAtualizado.getProduto().getId());
            ps.setInt(3, modelAtualizado.getMateriaPrima().getId());
            ps.setDouble(4, modelAtualizado.getSubTotal());
            ps.setInt(5, modelAtualizado.getId());

            ps.execute();
            return BaseDTO.buildSucesso("atualizado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Um erro ocorreu ao atualizar o item: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO deletar(ItensProdutoModel model) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("DELETE FROM itens_produtos WHERE ID_ITEM_PRODUTO = ?");
            ps.setInt(1, model.getId());

            ps.execute();
            return BaseDTO.buildSucesso("deletado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Um erro ocorreu ao deletar o item: " + e.getMessage());
        }
    }

    private List<ItensProdutoModel> build(ResultSet rs) throws SQLException {
        List<ItensProdutoModel> output = new ArrayList<>();
        if (rs.next()) {
            int idItemProduto = rs.getInt(1);
            int quantidade = rs.getInt(2);
            int idProduto = rs.getInt(3);
            int idMateriaPrima = rs.getInt(4);
            double subtotal = rs.getDouble(5);

            ProdutoModel produtoModel = buscarProdutoPorId(idProduto);
            MateriaPrimaModel materiaPrimaModel = buscarMateriaPrimaPorId(idMateriaPrima);

            var itensProduto = new ItensProdutoModel(quantidade, produtoModel, subtotal, materiaPrimaModel);
            itensProduto.setId(idItemProduto);

            output.add(itensProduto);
        } else {
            return List.of();
        }

        return output;
    }

    private MateriaPrimaModel buscarMateriaPrimaPorId(int id) {
        return _materiaPrimaDAO.buscarPorId(id);
    }

    private ProdutoModel buscarProdutoPorId(int id) {
        return _produtoDAO.buscarPorId(id);
    }
}
