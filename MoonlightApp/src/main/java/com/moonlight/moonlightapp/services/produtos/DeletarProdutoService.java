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
        if (DefaultValidator.isBlankOrEmpty(nome)) {
            return BaseDTO.buildFalha("nome inválido");
        }

        if (!produtoDAO.isCadastrado(nome)) {
            return BaseDTO.buildFalha("produto não encontrado");
        }

        var produtoEncontrado = buscarProdutoPorNome(nome);

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
