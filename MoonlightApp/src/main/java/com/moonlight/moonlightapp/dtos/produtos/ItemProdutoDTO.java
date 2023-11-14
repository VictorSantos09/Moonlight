package com.moonlight.moonlightapp.dtos.produtos;

public class ItemProdutoDTO {
    private int quantidade;
    private String nomeProduto;
    private String nomeMateriaPrima;

    public ItemProdutoDTO(int quantidade, String nomeMateriaPrima, String nomeProduto) {
        this.quantidade = quantidade;
        this.nomeMateriaPrima = nomeMateriaPrima;
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeMateriaPrima() {
        return nomeMateriaPrima;
    }

    public void setNomeMateriaPrima(String nomeMateriaPrima) {
        this.nomeMateriaPrima = nomeMateriaPrima;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
