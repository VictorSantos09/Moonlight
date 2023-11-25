package com.moonlight.moonlightapp.services.produtos;

import java.util.ArrayList;
import java.util.List;

import com.moonlight.moonlightapp.daos.ItensProdutoDAO;
import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.produtos.AtualizarItemProdutoDTO;
import com.moonlight.moonlightapp.models.ItemProdutoModel;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.validators.DefaultValidator;

public class AtualizarProdutoItemService {
    private final ProdutoDAO produtoDAO;
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final ItensProdutoDAO itensProdutoDAO;
    private final AtualizarProdutoValorRecomendadoService atualizarProdutoValorRecomendadoService;

    public AtualizarProdutoItemService() {
        produtoDAO = new ProdutoDAO();
        materiaPrimaDAO = new MateriaPrimaDAO();
        itensProdutoDAO = new ItensProdutoDAO();
        atualizarProdutoValorRecomendadoService = new AtualizarProdutoValorRecomendadoService();
    }

    public BaseDTO atualizar(AtualizarItemProdutoDTO dto) {
        var resultadoValidacaoEntrada = validarEntrada(dto);

        if (!resultadoValidacaoEntrada.getIsSucesso()) {
            return resultadoValidacaoEntrada;
        }

        if (!produtoDAO.isCadastrado(dto.getNomeProduto())) {
            return BaseDTO.buildFalha("produto não encontrado");
        }

        var resultadoVerificacao = verificarNovasMateriasPrimas(dto);
        if (!resultadoVerificacao.getIsSucesso()) {
            return resultadoVerificacao;
        }

        var resultadoRemocao = removerMateriasPrimasProduto(dto);
        if (!resultadoRemocao.getIsSucesso()) {
            return resultadoRemocao;
        }

        var resultadoGravacao = cadastrarNovosItens(dto);
        if (!resultadoGravacao.getIsSucesso()) {
            return resultadoGravacao;
        }
        return BaseDTO.buildSucesso("produto e matéria prima atualizados");
    }

    private Double calcularSubtotal(MateriaPrimaModel materiaPrima, Integer quantidade) {
        return materiaPrima.getValor() * quantidade;

    }

    private BaseDTO validarEntrada(AtualizarItemProdutoDTO dto) {
        List<String> erros = new ArrayList<>();
        if (DefaultValidator.isBlankOrEmpty(dto.getNomeProduto())) {
            return BaseDTO.buildFalha("nome do produto inválido");
        }

        dto.getMateriasPrimasQuantidade().keySet().forEach(m -> {
            if (DefaultValidator.isBlankOrEmpty(m)) {
                erros.add("nome da matéria prima inválida");
            }

            if (DefaultValidator.isZeroOrNegativte(dto.getMateriasPrimasQuantidade().get(m))) {
                erros.add("quantidade da matéria prima inválida");
            }
        });

        return erros.isEmpty() ? BaseDTO.buildSucesso("dados válidos")
                : BaseDTO.buildFalha("informações inválidas", erros);
    }

    private BaseDTO verificarNovasMateriasPrimas(AtualizarItemProdutoDTO dto) {
        List<String> erros = new ArrayList<>();

        dto.getMateriasPrimasQuantidade().keySet().forEach(m -> {
            if (!materiaPrimaDAO.isCadastrado(m)) {
                erros.add("matéria prima " + m + " não encontrado");
            }
        });

        return erros.isEmpty() ? BaseDTO.buildSucesso("matérias primas encontrados")
                : BaseDTO.buildFalha("uma matéria prima ou mais não encontrada", erros);
    }

    private BaseDTO removerMateriasPrimasProduto(AtualizarItemProdutoDTO dto) {
        var produto = produtoDAO.buscarPorNome(dto.getNomeProduto());
        var itensProdutos = itensProdutoDAO.buscarPorProdutoId(produto.getId());

        List<String> erros = new ArrayList<>();

        itensProdutos.forEach(ip -> {
            var resultado = itensProdutoDAO.deletar(ip);
            if (!resultado.getIsSucesso()) {
                erros.add(resultado.getMensagem());
            }
        });

        return erros.isEmpty() ? BaseDTO.buildSucesso("itens do produto deletados com sucesso")
                : BaseDTO.buildFalha("um item do produto ou mais não foram apagados", erros);
    }

    private BaseDTO cadastrarNovosItens(AtualizarItemProdutoDTO dto) {
        var produto = produtoDAO.buscarPorNome(dto.getNomeProduto());
        List<String> erros = new ArrayList<>();

        for (var mq : dto.getMateriasPrimasQuantidade().keySet()) {
            var materiaPrima = materiaPrimaDAO.buscarPorNome(mq);

            var subtotal = calcularSubtotal(materiaPrima, dto.getMateriasPrimasQuantidade().get(mq));

            var novoItemProduto = new ItemProdutoModel(dto.getMateriasPrimasQuantidade().get(mq), produto, subtotal,
                    materiaPrima);

            var resultadoAtualizacao = itensProdutoDAO.criar(novoItemProduto);
            if (!resultadoAtualizacao.getIsSucesso()) {
                erros.add("não foi possível atualizar a matéria prima do produto");
            }

            var resultadoValorRecomendado = atualizarProdutoValorRecomendadoService.atualizar(produto);

            if (!resultadoValorRecomendado.getIsSucesso()) {
                erros.add("não foi possível atualizar o valor recomendado, produto atualizado");
            }

        }
        return erros.isEmpty() ? BaseDTO.buildSucesso("itens do produto criados com sucesso")
                : BaseDTO.buildFalha("um item do produto ou mais não foram criados", erros);
    }
}
