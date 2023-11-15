package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.converters.ProdutoConverter;
import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ItemProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.*;
import com.moonlight.moonlightapp.services.CalcularValorRecomendadoProdutoService;
import com.moonlight.moonlightapp.validators.ProdutoValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CriarProdutoService {
    private final ProcessoDAO processoDAO;
    private final ProdutoDAO produtoDAO;
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final ProdutoConverter produtoConverter;
    private final ProdutoValidator produtoValidator;

    public CriarProdutoService() {
        processoDAO = new ProcessoDAO();
        produtoDAO = new ProdutoDAO();
        materiaPrimaDAO = new MateriaPrimaDAO();
        produtoConverter = new ProdutoConverter();
        produtoValidator = new ProdutoValidator();
    }

    public BaseDTO criar(ProdutoDTO dto) {
        ProdutoModel produto = produtoConverter.converterFrom(dto);
        var resultadoValidacao = produtoValidator.validar(produto);

        if (!resultadoValidacao.isValido()) {
            return BaseDTO.buildFalha("produto inválido", resultadoValidacao.getFalhas());
        }

        List<ProcessoDTO> processosDtos = dto.getProcessos();
        List<ItemProdutoDTO> itensProdutosDtos = dto.getItensProdutos();

        List<ProcessoModel> processosModels = buscarProcessos(processosDtos);
        List<MateriaPrimaModel> materiasPrimas = buscarMateriasPrimas(itensProdutosDtos);

        var valorRecomendado = CalcularValorRecomendadoProdutoService.calcularProcessos(processosModels,
                materiasPrimas);

        produto.getValorProduto().setValorRecomendado(valorRecomendado);

        BaseDTO resultadoGravacaoProduto = produtoDAO.criar(produto);

        if (!resultadoGravacaoProduto.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível gravar o produto");
        }

        List<ItemProdutoModel> itensProdutosModels = buscarItensProdutos(itensProdutosDtos);

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

    private List<ItemProdutoModel> buscarItensProdutos(List<ItemProdutoDTO> dtos) {
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

    private List<MateriaPrimaModel> buscarMateriasPrimas(List<ItemProdutoDTO> itensProdutosDtos) {
        return itensProdutosDtos.stream()
                .map(itemProduto -> materiaPrimaDAO.buscarPorNome(itemProduto.getNomeMateriaPrima()))
                .collect(Collectors.toList());

    }
}
