package com.moonlight.moonlightapp.services.produtos;

import java.util.ArrayList;
import java.util.List;

import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.ProdutoProcessosDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.produtos.AtualizarProcessoProdutoDTO;
import com.moonlight.moonlightapp.models.ProdutoProcessoModel;
import com.moonlight.moonlightapp.validators.DefaultValidator;

public class AtualizarProdutoProcessoService {
    private final ProdutoDAO produtoDAO;
    private final ProcessoDAO processoDAO;
    private final ProdutoProcessosDAO produtoProcessosDAO;
    private final AtualizarProdutoValorRecomendadoService atualizarProdutoValorRecomendadoService;

    public AtualizarProdutoProcessoService() {
        produtoDAO = new ProdutoDAO();
        processoDAO = new ProcessoDAO();
        produtoProcessosDAO = new ProdutoProcessosDAO();
        atualizarProdutoValorRecomendadoService = new AtualizarProdutoValorRecomendadoService();
    }

    public BaseDTO atualizar(AtualizarProcessoProdutoDTO dto) {
        var resultadoValidacaoEntrada = validarEntrada(dto);

        if (!resultadoValidacaoEntrada.getIsSucesso()) {
            return resultadoValidacaoEntrada;
        }

        if (!produtoDAO.isCadastrado(dto.getNomeProduto())) {
            return BaseDTO.buildFalha("produto não encontrado");
        }

        var resultadoValidacaoNovasEtapas = verificarNovasEtapas(dto);
        if (!resultadoValidacaoNovasEtapas.getIsSucesso()) {
            return resultadoValidacaoNovasEtapas;
        }

        var resultadoRemocao = removerProcessosDoProduto(dto);
        if (!resultadoRemocao.getIsSucesso()) {
            return resultadoRemocao;
        }

        var resultadoCriacao = cadastrarNovosProcesso(dto);
        if (!resultadoCriacao.getIsSucesso()) {
            return resultadoCriacao;
        }

        return BaseDTO.buildSucesso("processo do produto atualizados com sucesso");
    }

    private BaseDTO validarEntrada(AtualizarProcessoProdutoDTO dto) {
        if (DefaultValidator.isBlankOrEmpty(dto.getNomeProduto())) {
            return BaseDTO.buildFalha("nome do produto inválido");
        }

        return BaseDTO.buildSucesso("dados válidos");
    }

    private BaseDTO verificarNovasEtapas(AtualizarProcessoProdutoDTO dto) {
        List<String> erros = new ArrayList<>();

        dto.getEtapas().forEach(e -> {
            if (!processoDAO.isCadastrado(e)) {
                erros.add("processo " + e + " não encontrado");
            }
        });

        return erros.isEmpty() ? BaseDTO.buildSucesso("processos encontrados")
                : BaseDTO.buildFalha("um processo ou mais não encontrado", erros);
    }

    private BaseDTO removerProcessosDoProduto(AtualizarProcessoProdutoDTO dto) {
        var produto = produtoDAO.buscarPorNome(dto.getNomeProduto());
        var produtoProcessos = produtoProcessosDAO.buscarPorProdutoId(produto.getId());

        List<String> erros = new ArrayList<>();

        produtoProcessos.forEach(pp -> {
            var resultado = produtoProcessosDAO.deletar(pp);

            if (!resultado.getIsSucesso()) {
                erros.add(resultado.getMensagem());
            }
        });

        return erros.isEmpty() ? BaseDTO.buildSucesso("processos do produto deletados com sucesso")
                : BaseDTO.buildFalha("um processo ou mais não foram apagados", erros);
    }

    private BaseDTO cadastrarNovosProcesso(AtualizarProcessoProdutoDTO dto) {
        var produto = produtoDAO.buscarPorNome(dto.getNomeProduto());
        List<String> erros = new ArrayList<>();

        for (var e : dto.getEtapas()) {
            var processo = processoDAO.buscarPorEtapa(e);

            var novoProdutoProcesso = new ProdutoProcessoModel(processo, produto);

            var resultadoGravacao = produtoProcessosDAO.criar(novoProdutoProcesso);

            if (!resultadoGravacao.getIsSucesso()) {
                erros.add(resultadoGravacao.getMensagem());
            } else {
                var resultadoValorRecomendado = atualizarProdutoValorRecomendadoService
                        .atualizar(novoProdutoProcesso.getProduto());

                if (!resultadoValorRecomendado.getIsSucesso()) {
                    return BaseDTO.buildFalha("não foi possível atualizar o valor recomendado",
                            "processo do produto atualizado");
                }
            }
        }
        return erros.isEmpty() ? BaseDTO.buildSucesso("processos do produto criados com sucesso")
                : BaseDTO.buildFalha("um processo ou mais não foram criados", erros);
    }
}
