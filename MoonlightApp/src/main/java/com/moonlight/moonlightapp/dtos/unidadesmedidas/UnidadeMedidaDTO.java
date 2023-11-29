package com.moonlight.moonlightapp.dtos.unidadesmedidas;

import com.moonlight.moonlightapp.dtos.DTO;

public class UnidadeMedidaDTO implements DTO {
    private String nome;

    public UnidadeMedidaDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
