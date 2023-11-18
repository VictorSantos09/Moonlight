package com.moonlight.moonlightapp.services.produtos;

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

        if (!processoDAO.isCadastrado(dto.getNovaEtapa())) {
            return BaseDTO.buildFalha("processo não encontrado");
        }

        var produto = produtoDAO.buscarPorNome(dto.getNomeProduto());
        var processo = processoDAO.buscarPorEtapa(dto.getEtapaAtual());

        var produtoProcessoParaBuscar = new ProdutoProcessoModel(processo, produto);

        if (!produtoProcessosDAO.isCadastrado(produtoProcessoParaBuscar)) {
            return BaseDTO.buildFalha("produto com o processo não encontrado");
        }

        var produtoProcessoOriginal = produtoProcessosDAO.buscar(produtoProcessoParaBuscar);

        var novoProcesso = processoDAO.buscarPorEtapa(dto.getNovaEtapa());

        var produtoProcessoAtualizado = new ProdutoProcessoModel(novoProcesso, produto);

        produtoProcessoAtualizado.setId(produtoProcessoOriginal.getId());

        var resultadoAtualizacao = produtoProcessosDAO.atualizar(produtoProcessoAtualizado);

        if (!resultadoAtualizacao.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível atualizar o processo do produto",
                    resultadoAtualizacao.getMensagem());
        }

        var resultadoValorRecomendado = atualizarProdutoValorRecomendadoService.atualizar(produtoProcessoAtualizado.getProduto());
        if (!resultadoValorRecomendado.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível atualizar o valor recomendado",
                    "processo do produto atualizado");
        }

        return BaseDTO.buildSucesso("processo do produto atualizado com sucesso");
    }

    private BaseDTO validarEntrada(AtualizarProcessoProdutoDTO dto) {
        if (DefaultValidator.isBlankOrEmpty(dto.getEtapaAtual())) {
            return BaseDTO.buildFalha("etapa atual inválida");
        }
        if (DefaultValidator.isBlankOrEmpty(dto.getNovaEtapa())) {
            return BaseDTO.buildFalha("nova etapa inválida");
        }
        if (DefaultValidator.isBlankOrEmpty(dto.getNomeProduto())) {
            return BaseDTO.buildFalha("nome do produto inválido");
        }

        return BaseDTO.buildSucesso("dados válidos");
    }
}
