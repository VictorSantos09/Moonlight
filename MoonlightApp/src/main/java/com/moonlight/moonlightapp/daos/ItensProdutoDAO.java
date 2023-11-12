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
    public ItensProdutoModel BuscarPorId(int id) throws RuntimeException {
        try {
            Connection conexa = connect();

            PreparedStatement ps = conexa.prepareStatement("SELECT * FROM ITENS_PRODUTOS WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            return build(rs).getFirst();
        } catch (Exception e) {
            throw new RuntimeException("Um erro ocorreu ao buscar o ItensProduto por ID");
        }
    }

    public List<ItensProdutoModel> buscarPorProdutoId(int idProduto) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM itens_produtos WHERE ID_PRODUTO = ?");
            ps.setInt(1, idProduto);

            ResultSet rs = ps.executeQuery();
            return build(rs);
        } catch (Exception e) {
            throw new RuntimeException("Um erro ocorreu ao buscar os itensProdutos por meio do produto");
        }
    }

    @Override
    public BaseDTO criar(ItensProdutoModel model) {
        throw new RuntimeException("metodo não implementado");
    }

    @Override
    public BaseDTO atualizar(ItensProdutoModel modelAtualizado) {
        throw new RuntimeException("metodo nao implementado");
    }

    @Override
    public BaseDTO deletar(ItensProdutoModel model) {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("DELETE FROM itens_produtos WHERE ID_ITEM_PRODUTO = ?");
            ps.setInt(1, model.getId());

            ps.execute();
            return BaseDTO.BuildSucesso("deletado com sucesso", null);
        }catch (Exception e){
            return BaseDTO.BuildException(e);
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

            ItensProdutoModel itensProduto = new ItensProdutoModel(quantidade, produtoModel, subtotal);
            itensProduto.setId(idItemProduto);

            addMateriaPrima(itensProduto, idMateriaPrima);

            output.add(itensProduto);
        } else {
            return List.of();
        }

        return output;
    }

    private void addMateriaPrima(ItensProdutoModel itensProduto, int idMateriaPrima) {
        MateriaPrimaModel materiaPrimaModel = buscarMateriaPrimaPorId(idMateriaPrima);
        itensProduto.addMateriaPrima(materiaPrimaModel);
    }

    private MateriaPrimaModel buscarMateriaPrimaPorId(int id) {
        return _materiaPrimaDAO.BuscarPorId(id);
    }

    private ProdutoModel buscarProdutoPorId(int id) {
        return _produtoDAO.BuscarPorId(id);
    }
}
