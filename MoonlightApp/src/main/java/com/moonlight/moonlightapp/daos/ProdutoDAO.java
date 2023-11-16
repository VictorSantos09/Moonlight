package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ProdutoDAO extends ConexaoBanco
        implements ModelDAO<ProdutoModel>, BuscarPorNomeDAO<ProdutoModel> {
    private final ValorProdutoDAO valorProdutoDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final ItensProdutoDAO itensProdutoDAO;

    public ProdutoDAO() {
        valorProdutoDAO = new ValorProdutoDAO();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
        itensProdutoDAO = new ItensProdutoDAO();
    }

    public BaseDTO criarDetalhes(List<ProcessoModel> processos, List<ItemProdutoModel> itensProdutos, int idProduto)
            throws RuntimeException {
        try {
            var resultadosProcessos = salvarProcessos(idProduto, processos);
            var resultadosItensProdutos = salvarItensProdutos(itensProdutos);

            List<String> informacoes = new ArrayList<>();
            informacoes.addAll(resultadosItensProdutos);
            informacoes.addAll(resultadosProcessos);

            return BaseDTO.buildSucesso("detalhes do produto criados", informacoes);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar os detalhes do produto: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public BaseDTO criar(ProdutoModel model) throws RuntimeException {
        try {
            definirIdUnidademedida(model);
            definirIdTipoProduto(model);

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

    public BaseDTO atualizar(ProdutoModel modelAtualizado) throws RuntimeException {
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

    public BaseDTO deletar(ProdutoModel model) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("CALL spDeletarProdutosEDetalhes(?)");
            ps.setInt(1, model.getId());

            ps.executeUpdate();

            return BaseDTO.buildSucesso("Produto deletado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

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

            ProdutoModel produto = new ProdutoModel(nome, descricao, unidadeMedida, tipoProduto,
                    valorProduto.getValorRecomendado(), valorProduto.getValor());

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

    private List<String> salvarProcessos(int idProduto, List<ProcessoModel> processos) {
        List<String> output = new ArrayList<>();
        ProdutoProcessosDAO produtoProcessosDAO = new ProdutoProcessosDAO();

        processos.forEach(processo -> {
            var produto = buscarPorId(idProduto);

            ProdutoProcessoModel produtoProcesso = new ProdutoProcessoModel(processo, produto);

            var resultadoGravacao = produtoProcessosDAO.criar(produtoProcesso);

            output.add(processo.getEtapa() + (resultadoGravacao.getIsSucesso() ? " CRIADO" : " NÃO CRIADO"));
        });

        return output;
    }

    private List<String> salvarItensProdutos(List<ItemProdutoModel> itensProdutos) {
        List<String> output = new ArrayList<>();

        itensProdutos.forEach(ip -> {
            var resultadoGravacao = itensProdutoDAO.criar(ip);

            output.add(ip.getProduto().getNome() + " - " + ip.getMateriaPrima().getNome()
                    + (resultadoGravacao.getIsSucesso() ? "CRIADO" : "NÂO CRIADO"));
        });

        return output;
    }

    private void definirIdUnidademedida(ProdutoModel model) throws RuntimeException {
        var idUnidadeMedida = unidadeMedidaDAO.buscarPorSigla(model.getUnidadeMedida().getSigla()).getId();

        if (idUnidadeMedida == 0) {
            throw new RuntimeException("um erro ocorreu ao definir a ID da unidade de medida do produto");
        }

        model.getUnidadeMedida().setId(idUnidadeMedida);
    }

    private void definirIdTipoProduto(ProdutoModel model) throws RuntimeException {
        var idTipo = tipoProdutoDAO.buscarPorNome(model.getTipo().getNome()).getId();

        if (idTipo == 0) {
            throw new RuntimeException("um erro ocorreu ao definir a ID do tipo do produto");
        }

        model.getTipo().setId(idTipo);
    }
}