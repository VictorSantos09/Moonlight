package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ItemProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.*;
import com.moonlight.moonlightapp.services.CalcularValorRecomendadoProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CriarProdutoService {
    private final ProcessoDAO processoDAO;
    private final ProdutoDAO produtoDAO;
    private final MateriaPrimaDAO materiaPrimaDAO;

    public CriarProdutoService() {
        processoDAO = new ProcessoDAO();
        produtoDAO = new ProdutoDAO();
        materiaPrimaDAO = new MateriaPrimaDAO();
    }

    public BaseDTO criar(ProdutoDTO dto) {
        List<ProcessoDTO> processosDtos = dto.getProcessos();
        List<ItemProdutoDTO> itensProdutosDtos = dto.getItensProdutos();
        UnidadeMedidaModel unidadeMedida = dto.getUnidadeMedida();
        TipoProdutoModel tipoProduto = dto.getTipoProduto();

        List<ProcessoModel> processosModels = buscarProcessos(processosDtos);

        List<MateriaPrimaModel> materiasPrimas = extrairMateriasPrimas(itensProdutosDtos);

        var valorRecomendado = CalcularValorRecomendadoProdutoService.calcularProcessos(processosModels, materiasPrimas);

        ProdutoModel produto = new ProdutoModel(dto.getNome(), dto.getDescricao(), unidadeMedida,
                tipoProduto, valorRecomendado, dto.getValor());

        BaseDTO resultadoGravacaoProduto = produtoDAO.criar(produto);

        if (!resultadoGravacaoProduto.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível gravar o produto");
        }

        List<ItemProdutoModel> itensProdutosModels = converterItensProdutosParaModel(itensProdutosDtos);

        var idProduto = produtoDAO.buscarPorNome(produto.getNome()).getId();

        BaseDTO resultadoGravacaoDetalhes = produtoDAO.criarDetalhes(processosModels, itensProdutosModels, idProduto);

        if (!resultadoGravacaoDetalhes.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível gravar os processos e matérias primas do produto",
                    produto.getNome() + " foi cadastrado");
        }

        return BaseDTO.buildSucesso("produto e detalhes gravados com sucesso");
    }

    private List<ProcessoModel> buscarProcessos(List<ProcessoDTO> dtos) {
        List<ProcessoModel> output = new ArrayList<>();

        dtos.forEach(x -> {
            var processo = processoDAO.buscarPorEtapa(x.getEtapa());
            output.add(processo);
        });

        return output;
    }

    private List<ItemProdutoModel> converterItensProdutosParaModel(List<ItemProdutoDTO> dtos) {
        List<ItemProdutoModel> output = new ArrayList<>();

        dtos.forEach(x -> {
            var produto = produtoDAO.buscarPorNome(x.getNomeProduto());

            dtos.forEach(ip -> {

                var materiaPrima = materiaPrimaDAO.buscarPorNome(ip.getNomeMateriaPrima());
                var subTotal = materiaPrima.getValor() * ip.getQuantidade();
                var itemProduto = new ItemProdutoModel(ip.getQuantidade(), produto, subTotal, materiaPrima);
                output.add(itemProduto);
            });
        });

        return output;
    }

    private List<MateriaPrimaModel> extrairMateriasPrimas(List<ItemProdutoDTO> itensProdutosDtos) {
        return itensProdutosDtos.stream()
                .map(itemProduto -> materiaPrimaDAO.buscarPorNome(itemProduto.getNomeMateriaPrima()))
                .collect(Collectors.toList());

    }
}
