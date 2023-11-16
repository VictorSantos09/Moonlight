package com.moonlight.moonlightapp.services.produtos;

import java.util.List;

import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.models.ProdutoModel;

public class BuscarProdutoService {
    private final ProdutoDAO produtoDAO;

    public BuscarProdutoService() {
        produtoDAO = new ProdutoDAO();
    }

    public List<ProdutoModel> buscarTodos() {
        return produtoDAO.buscarTodos();
    }

    public ProdutoModel buscarPorNome(String nome) {
        return produtoDAO.buscarPorNome(nome);
    }
}
