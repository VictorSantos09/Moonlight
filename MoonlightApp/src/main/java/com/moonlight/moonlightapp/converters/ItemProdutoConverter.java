package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.daos.ItensProdutoDAO;
import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.dtos.produtos.ItemProdutoDTO;
import com.moonlight.moonlightapp.models.ItemProdutoModel;

public class ItemProdutoConverter {
    private final ItensProdutoDAO itensProdutoDAO;
    private final ProdutoDAO produtoDAO;
    private final MateriaPrimaDAO materiaPrimaDAO;

    public ItemProdutoConverter() {
        itensProdutoDAO = new ItensProdutoDAO();
        produtoDAO = new ProdutoDAO();
        materiaPrimaDAO = new MateriaPrimaDAO();
    }
    public ItemProdutoModel converterParaModel(ItemProdutoDTO dto) {
        var produto = produtoDAO.buscarPorNome(dto.getNomeProduto());
        var materiaPrima = materiaPrimaDAO.buscarPorNome(dto.getNomeProduto());
        
        double valor = produto.getValorProduto().getValor() * dto.getQuantidade();
        
        ItemProdutoModel model = new ItemProdutoModel(dto.getQuantidade(),produto,valor, materiaPrima);
        return model;
    }
    
}
