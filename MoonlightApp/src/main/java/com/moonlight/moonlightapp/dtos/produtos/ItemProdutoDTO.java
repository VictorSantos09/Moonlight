package com.moonlight.moonlightapp.dtos.produtos;

import com.moonlight.moonlightapp.dtos.DTO;

public class ItemProdutoDTO implements DTO {
    private final Float quantidade;
    private final String nomeProduto;
    private final String nomeMateriaPrima;

    public ItemProdutoDTO(Float quantidade, String nomeMateriaPrima, String nomeProduto) {
        this.quantidade = quantidade;
        this.nomeMateriaPrima = nomeMateriaPrima;
        this.nomeProduto = nomeProduto;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getNomeMateriaPrima() {
        return nomeMateriaPrima;
    }
}
