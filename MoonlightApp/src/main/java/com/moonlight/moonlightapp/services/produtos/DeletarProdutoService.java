package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.validators.DefaultValidator;

public class DeletarProdutoService {
    private final ProdutoDAO produtoDAO;

    public DeletarProdutoService() {
        produtoDAO = new ProdutoDAO();
    }

    public BaseDTO deletar(String nome) {
        var isNomeValido = DefaultValidator.isBlankOrEmpty(nome);
        if (!isNomeValido) {
            return BaseDTO.buildFalha("nome inválido");
        }

        var produtoEncontrado = buscarProdutoPorNome(nome);
        if (produtoEncontrado == null) {
            return BaseDTO.buildFalha("produto " + nome + " não encontrado");
        }

        var resultadoDeletacao = deletarProduto(produtoEncontrado);
        if (!resultadoDeletacao.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível deletar o produto");
        }

        return BaseDTO.buildSucesso("produto deletado com sucesso", resultadoDeletacao.getData());
    }

    private ProdutoModel buscarProdutoPorNome(String nome) {
        return produtoDAO.buscarPorNome(nome);
    }

    private BaseDTO deletarProduto(ProdutoModel produto) {
        return produtoDAO.deletar(produto);
    }
}
