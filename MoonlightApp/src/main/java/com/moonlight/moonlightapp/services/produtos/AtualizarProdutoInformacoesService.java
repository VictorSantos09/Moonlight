package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.produtos.AtualizarInformacoesProdutoDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.validators.DefaultValidator;
import com.moonlight.moonlightapp.validators.dtos.TipoProdutoDTOValidator;
import com.moonlight.moonlightapp.validators.dtos.UnidadeMedidaDTOValidator;

public class AtualizarProdutoInformacoesService {
    private final ProdutoDAO produtoDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final UnidadeMedidaDTOValidator unidadeMedidaDTOValidator;
    private final TipoProdutoDTOValidator tipoProdutoDTOValidator;

    public AtualizarProdutoInformacoesService() {
        produtoDAO = new ProdutoDAO();
        ;
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
        unidadeMedidaDTOValidator = new UnidadeMedidaDTOValidator();
        tipoProdutoDTOValidator = new TipoProdutoDTOValidator();
    }

    public BaseDTO atualizar(AtualizarInformacoesProdutoDTO dto) {
        var resultadoValidacaoEntrada = validarEntrada(dto);
        if (!resultadoValidacaoEntrada.getIsSucesso()) {
            return resultadoValidacaoEntrada;
        }

        if (!produtoDAO.isCadastrado(dto.getNomeOriginal())) {
            return BaseDTO.buildFalha("produto não encontrado");
        }

        if (!unidadeMedidaDAO.isCadastradoPorNome(dto.getUnidadeMedida().getNome())) {
            return BaseDTO.buildFalha("unidade de medida não encontrada");
        }

        if (!tipoProdutoDAO.isCadastrado(dto.getTipoProduto().getNome())) {
            return BaseDTO.buildFalha("tipo do produto não encontrado");
        }

        var produtoOriginal = produtoDAO.buscarPorNome(dto.getNomeOriginal());
        var unidadeMedida = unidadeMedidaDAO.buscarPorNome(dto.getUnidadeMedida().getNome());
        var tipo = tipoProdutoDAO.buscarPorNome(dto.getTipoProduto().getNome());

        var produtoAtualizado = new ProdutoModel(dto.getNomeNovo(), dto.getDescricao(), unidadeMedida, tipo,
                produtoOriginal.getValorProduto().getValorRecomendado(), dto.getValor());

        produtoAtualizado.setId(produtoOriginal.getId());

        var resultadoAtualizacao = produtoDAO.atualizar(produtoAtualizado);

        if (!resultadoAtualizacao.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível atualizar as informações do produto",
                    resultadoAtualizacao.getMensagem());
        }

        return BaseDTO.buildSucesso("informações do produto atualizadas com sucesso");
    }

    private BaseDTO validarEntrada(AtualizarInformacoesProdutoDTO dto) {
        if (DefaultValidator.isBlankOrEmpty(dto.getDescricao())) {
            return BaseDTO.buildFalha("descrição inválida");
        }

        if (DefaultValidator.isBlankOrEmpty(dto.getNomeOriginal())) {
            return BaseDTO.buildFalha("nome do produto original inválido");
        }

        if (DefaultValidator.isBlankOrEmpty((dto.getNomeNovo()))) {
            return BaseDTO.buildFalha("nome do novo produto inválido");
        }

        var resultadoUnidadeMedida = unidadeMedidaDTOValidator.validar(dto.getUnidadeMedida());
        if (!resultadoUnidadeMedida.isValido()) {
            return BaseDTO.buildFalha("unidade de medida inválida", resultadoUnidadeMedida);
        }

        var resultadoTipoProduto = tipoProdutoDTOValidator.validar(dto.getTipoProduto());
        if (!resultadoTipoProduto.isValido()) {
            return BaseDTO.buildFalha("tipo do produto inválido", resultadoTipoProduto);
        }

        return BaseDTO.buildSucesso("dados inválidos");
    }
}
