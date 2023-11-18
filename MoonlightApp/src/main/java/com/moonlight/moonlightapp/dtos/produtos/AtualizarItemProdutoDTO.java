package com.moonlight.moonlightapp.dtos.produtos;

public class AtualizarItemProdutoDTO {
    private final String nomeProduto;
    private final String nomeMateriaPrimaAtual;
    private final String nomeMateriaPrimaNova;
    private final Integer quantidade;

    public AtualizarItemProdutoDTO(String nomeProduto, String nomeMateriaPrimaAtual,
                                   String nomeMateriaPrimaNova, Integer quantidade) {
        this.nomeProduto = nomeProduto;
        this.nomeMateriaPrimaAtual = nomeMateriaPrimaAtual;
        this.nomeMateriaPrimaNova = nomeMateriaPrimaNova;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getNomeMateriaPrimaAtual() {
        return nomeMateriaPrimaAtual;
    }

    public String getNomeMateriaPrimaNova() {
        return nomeMateriaPrimaNova;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
