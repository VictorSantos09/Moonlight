package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.converters.MateriaPrimaConverter;
import com.moonlight.moonlightapp.converters.ProcessoConverter;
import com.moonlight.moonlightapp.daos.*;
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
        var materiasPrimas = converterMateriasPrimasParaModel(dto);

        Double valorRecomendado = CalcularValorRecomendadoProdutoService.calcular(materiasPrimas);

        ValorProdutoModel valorProduto = new ValorProdutoModel(valorRecomendado, dto.getValor());

        UnidadeMedidaModel unidadeMedida = unidadeMedidaDAO.buscarPorSigla(dto.getSiglaUnidadeMedida());
        TipoProdutoModel tipoProduto = tipoProdutoDAO.buscarPorNome(dto.getTipo());

        var processos = converterProcessosParaModel(dto);

        var novoProduto = new ProdutoModel(dto.getNome(), dto.getDescricao(),
                valorProduto, unidadeMedida, tipoProduto, processos);

        return produtoDAO.criar(novoProduto);
    }

    private List<MateriaPrimaModel> converterMateriasPrimasParaModel(ProdutoDTO dto) {
        List<MateriaPrimaModel> materiasPrimas = new ArrayList<>();

        for (var materiaPrimaDto : dto.getMateriasPrimas()) {
            materiasPrimas.add(materiaPrimaConverter.converterParaModel(materiaPrimaDto));
        }

        return materiasPrimas;
    }

    private List<ProcessoModel> converterProcessosParaModel(ProdutoDTO dto) {
        List<ProcessoModel> processos = new ArrayList<>();

        for (var processo : dto.getProcessos()) {
            processos.add(processoConverter.converterParaModel(processo));
        }
        return processos;
    }
}
