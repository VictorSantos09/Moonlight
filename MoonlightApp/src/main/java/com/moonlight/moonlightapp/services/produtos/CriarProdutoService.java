package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.converters.MateriaPrimaConverter;
import com.moonlight.moonlightapp.converters.ProcessoConverter;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.*;
import com.moonlight.moonlightapp.services.CalcularValorRecomendadoProdutoService;

import java.util.ArrayList;
import java.util.List;

public class CriarProdutoService {
    private final ProdutoDAO produtoDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final MateriaPrimaConverter materiaPrimaConverter;
    private final ProcessoConverter processoConverter;

    public CriarProdutoService() {
        produtoDAO = new ProdutoDAO();
        materiaPrimaConverter = new MateriaPrimaConverter();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
        processoConverter = new ProcessoConverter();
    }

    public BaseDTO criar(ProdutoDTO dto) {
        UnidadeMedidaModel unidadeMedida = unidadeMedidaDAO.buscarPorSigla(dto.getSiglaUnidadeMedida());
        TipoProdutoModel tipoProduto = tipoProdutoDAO.buscarPorNome(dto.getTipo());

        var processos = converterProcessosParaModel(dto);

        var novoProduto = new ProdutoModel(dto.getNome(), dto.getDescricao(),
                unidadeMedida, tipoProduto, processos, 0, dto.getValor());

        var itensProdutos = converterItensProdutoParaListModel(dto, novoProduto);

        double valorRecomendado = CalcularValorRecomendadoProdutoService.calcular(itensProdutos);
        novoProduto.getValorProduto().setValorRecomendado(valorRecomendado);

        return produtoDAO.criar(novoProduto);
    }

    private List<ProcessoModel> converterProcessosParaModel(ProdutoDTO dto) {
        List<ProcessoModel> processos = new ArrayList<>();

        for (var processo : dto.getProcessos()) {
            processos.add(processoConverter.converterParaModel(processo));
        }
        return processos;
    }

    private List<ItensProdutoModel> converterItensProdutoParaListModel(ProdutoDTO dto, ProdutoModel novoProduto) {
        List<ItensProdutoModel> itensProdutos = new ArrayList<>();

        for (var ip : dto.getItensProdutos()) {
            var materiaPrima = materiaPrimaConverter.converterParaModel(ip.getMateriaPrima());

            var valor = materiaPrima.getValor() * ip.getQuantidade();

            var itemProduto = new ItensProdutoModel(ip.getQuantidade(), novoProduto, valor, materiaPrima);

            itensProdutos.add(itemProduto);
        }

        return itensProdutos;
    }
}
