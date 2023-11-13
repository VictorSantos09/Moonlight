package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.converters.MateriaPrimaConverter;
import com.moonlight.moonlightapp.converters.ProcessoConverter;
import com.moonlight.moonlightapp.daos.ItensProdutoDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.*;
import com.moonlight.moonlightapp.services.CalcularValorRecomendadoProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CriarProdutoService {
    private final ProdutoDAO produtoDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final ItensProdutoDAO itensProdutoDAO;
    private final MateriaPrimaConverter materiaPrimaConverter;
    private final ProcessoConverter processoConverter;

    public CriarProdutoService() {
        produtoDAO = new ProdutoDAO();
        materiaPrimaConverter = new MateriaPrimaConverter();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
        itensProdutoDAO = new ItensProdutoDAO();
        processoConverter = new ProcessoConverter();
    }

    public BaseDTO criar(ProdutoDTO dto) {
        UnidadeMedidaModel unidadeMedida = unidadeMedidaDAO.buscarPorSigla(dto.getSiglaUnidadeMedida());
        TipoProdutoModel tipoProduto = tipoProdutoDAO.buscarPorNome(dto.getTipo());

        List<ProcessoModel> processos = converterProcessosParaModel(dto);

        var novoProduto = new ProdutoModel(dto.getNome(), dto.getDescricao(),
                unidadeMedida, tipoProduto, 0, dto.getValor());

        List<ItensProdutoModel> itensProdutos = converterItensProdutoParaListModel(dto, novoProduto);

        double valorRecomendado = CalcularValorRecomendadoProdutoService.calcular(itensProdutos.stream()
                .map(ItensProdutoModel::getMateriaPrima)
                .collect(Collectors.toList()));

        novoProduto.getValorProduto().setValorRecomendado(valorRecomendado);

        var resultadoGravacaoProduto = gravarProduto(novoProduto);
        if (!resultadoGravacaoProduto.getIsSucesso()) {
            return resultadoGravacaoProduto;
        }

        if (!gravarItensProdutos(itensProdutos)) {
            return BaseDTO.buildFalha("não foi possível gravar um itemProduto", null);
        }

        return BaseDTO.buildSucesso("produto cadastrado com sucesso", null);
    }

    private List<ProcessoModel> converterProcessosParaModel(ProdutoDTO dto) {
        List<ProcessoModel> processos = new ArrayList<>();

        dto.getProcessos().stream()
                .map(processoConverter::converterParaModel)
                .forEach(processos::add);

        return processos;
    }

    private List<ItensProdutoModel> converterItensProdutoParaListModel(ProdutoDTO dto, ProdutoModel novoProduto) {
        return dto.getItensProdutos().stream()
                .map(ip -> {
                    var materiaPrima = materiaPrimaConverter.converterParaModel(ip.getMateriaPrima());

                    double valor = materiaPrima.getValor() * ip.getQuantidade();

                    return new ItensProdutoModel(ip.getQuantidade(), novoProduto, valor, materiaPrima);
                })
                .collect(Collectors.toList());
    }

    private BaseDTO gravarProduto(ProdutoModel produto) {
        return produtoDAO.criar(produto);
    }

    private Boolean gravarItensProdutos(List<ItensProdutoModel> itensProdutos) {
        for (var ip : itensProdutos) {
            var resultadoCriacaoItemProduto = itensProdutoDAO.criar(ip);
            if (!resultadoCriacaoItemProduto.getIsSucesso()) {
                return false;
            }
        }
        return true;
    }
}
