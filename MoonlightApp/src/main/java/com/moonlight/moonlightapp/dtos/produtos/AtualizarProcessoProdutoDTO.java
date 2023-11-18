package com.moonlight.moonlightapp.dtos.produtos;

public class AtualizarProcessoProdutoDTO {
    private final String nomeProduto;
    private final String etapaAtual;
    private final String novaEtapa;

    public AtualizarProcessoProdutoDTO(String nomeProduto, String etapaAtual, String novaEtapa) {
        this.nomeProduto = nomeProduto;
        this.etapaAtual = etapaAtual;
        this.novaEtapa = novaEtapa;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getEtapaAtual() {
        return etapaAtual;
    }

    public String getNovaEtapa() {
        return novaEtapa;
    }
}
