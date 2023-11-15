package com.moonlight.moonlightapp.dtos.produtos;

import com.moonlight.moonlightapp.dtos.DTO;

public class TipoProdutoDTO implements DTO {
    private String nome;

    public TipoProdutoDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
