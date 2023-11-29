package com.moonlight.moonlightapp.dtos.produtos;

import java.util.Hashtable;

public class AtualizarItemProdutoDTO {
    private final String nomeProduto;
    private final Hashtable<String, Float> materiasPrimasQuantidade;

    public AtualizarItemProdutoDTO(String nomeProduto, Hashtable<String, Float> materiasPrimasQuantidade) {
        this.nomeProduto = nomeProduto;
        this.materiasPrimasQuantidade = materiasPrimasQuantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Hashtable<String, Float> getMateriasPrimasQuantidade() {
        return materiasPrimasQuantidade;
    }
}
