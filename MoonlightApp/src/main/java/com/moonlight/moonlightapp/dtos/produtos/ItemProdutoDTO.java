package com.moonlight.moonlightapp.dtos.produtos;

public class ItemProdutoDTO {
    private int quantidade;
    private String nomeMateriaPrima;

    public ItemProdutoDTO(int quantidade, String nomeMateriaPrima) {
        this.quantidade = quantidade;
        this.nomeMateriaPrima = nomeMateriaPrima;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMateriaPrima() {
        return nomeMateriaPrima;
    }

    public void setNomeMateriaPrima(String nomeMateriaPrima) {
        this.nomeMateriaPrima = nomeMateriaPrima;
    }
}
