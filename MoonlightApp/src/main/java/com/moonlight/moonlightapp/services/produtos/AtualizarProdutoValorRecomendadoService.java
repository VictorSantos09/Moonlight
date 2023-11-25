package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.daos.ItensProdutoDAO;
import com.moonlight.moonlightapp.daos.ProdutoProcessosDAO;
import com.moonlight.moonlightapp.daos.ValorProdutoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.ValorProdutoModel;
import com.moonlight.moonlightapp.services.CalcularValorRecomendadoProdutoService;

public class AtualizarProdutoValorRecomendadoService {
    private final ValorProdutoDAO valorProdutoDAO;
    private final ProdutoProcessosDAO produtoProcessosDAO;
    private final ItensProdutoDAO itensProdutoDAO;

    public AtualizarProdutoValorRecomendadoService() {
        valorProdutoDAO = new ValorProdutoDAO();
        produtoProcessosDAO = new ProdutoProcessosDAO();
        itensProdutoDAO = new ItensProdutoDAO();
    }

    public BaseDTO atualizar(ProdutoModel produto) {
        var valorRecomendado = recalcularValorRecomendado(produto);

        var modelAtualizado = new ValorProdutoModel(valorRecomendado, produto.getValorProduto().getValor());
        modelAtualizado.setId(produto.getValorProduto().getId());

        return valorProdutoDAO.atualizar(modelAtualizado);
    }

    private Double recalcularValorRecomendado(ProdutoModel produto) {
        var processos = produtoProcessosDAO.buscarProcessosPorProdutoId(produto.getId());
        var itensProdutos = itensProdutoDAO.buscarPorProdutoId(produto.getId());

        return CalcularValorRecomendadoProdutoService.calcular(processos, itensProdutos);
    }
}
