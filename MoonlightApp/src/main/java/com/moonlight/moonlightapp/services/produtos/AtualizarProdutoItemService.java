package com.moonlight.moonlightapp.services.produtos;

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

        if(!resultadoValidacaoEntrada.getIsSucesso()){
            return resultadoValidacaoEntrada;
        }

        if (!materiaPrimaDAO.isCadastrado(dto.getNomeMateriaPrimaNova())) {
            return BaseDTO.buildFalha("matéria prima nova não encontrada");
        }

        if (!materiaPrimaDAO.isCadastrado(dto.getNomeMateriaPrimaAtual())) {
            return BaseDTO.buildFalha("matéria prima atual não encontrada");
        }

        if (!produtoDAO.isCadastrado(dto.getNomeProduto())) {
            return BaseDTO.buildFalha("produto não encontrado");
        }

        var materiaPrimaAtual = materiaPrimaDAO.buscarPorNome(dto.getNomeMateriaPrimaAtual());
        var materiaPrimaNova = materiaPrimaDAO.buscarPorNome(dto.getNomeMateriaPrimaNova());
        var produto = produtoDAO.buscarPorNome(dto.getNomeProduto());

        var subtotal = calcularSubtotal(materiaPrimaNova, dto);

        var itemProdutoOriginal = itensProdutoDAO.buscar(produto.getId(), materiaPrimaAtual.getId());
        if (itemProdutoOriginal == null) {
            return BaseDTO.buildFalha("produto com matéria prima não encontrado");
        }

        var itemProdutoAtualizado = new ItemProdutoModel(dto.getQuantidade(), produto, subtotal, materiaPrimaNova);
        itemProdutoAtualizado.setId(itemProdutoOriginal.getId());

        var resultadoAtualizacao = itensProdutoDAO.atualizar(itemProdutoAtualizado);
        if (!resultadoAtualizacao.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível atualizar a matéria prima do produto");
        }

        var resultadoValorRecomendado = atualizarProdutoValorRecomendadoService.atualizar(produto);

        if (!resultadoValorRecomendado.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível atualizar o valor recomendado", "produto atualizado");
        }

        return BaseDTO.buildSucesso("produto e matéria prima atualizados");
    }

    private Double calcularSubtotal(MateriaPrimaModel materiaPrima, AtualizarItemProdutoDTO dto) {
        return materiaPrima.getValor() * dto.getQuantidade();

    }

    private BaseDTO validarEntrada(AtualizarItemProdutoDTO dto) {
        if (DefaultValidator.isBlankOrEmpty(dto.getNomeMateriaPrimaAtual())) {
            return BaseDTO.buildFalha("nome da matéria atual inválida");
        }
        if (DefaultValidator.isBlankOrEmpty(dto.getNomeProduto())) {
            return BaseDTO.buildFalha("nome do produto inválido");
        }
        if (DefaultValidator.isBlankOrEmpty(dto.getNomeMateriaPrimaNova())) {
            return BaseDTO.buildFalha("nome da matéria prima nova inválida");
        }
        if (DefaultValidator.isZeroOrNegativte(dto.getQuantidade())) {
            return BaseDTO.buildFalha("quantidade inválida");
        }

        return  BaseDTO.buildSucesso("dados válidos");
    }
}
