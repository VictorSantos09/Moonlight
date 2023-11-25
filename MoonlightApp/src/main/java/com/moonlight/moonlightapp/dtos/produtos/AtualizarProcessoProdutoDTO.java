package com.moonlight.moonlightapp.dtos.produtos;

import java.util.List;

public class AtualizarProcessoProdutoDTO {
    private final String nomeProduto;
    private final List<String> etapas;

    public AtualizarProcessoProdutoDTO(String nomeProduto, List<String> etapas) {
        this.nomeProduto = nomeProduto;
        this.etapas = etapas;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public List<String> getEtapas() {
        return etapas;
    }

}
