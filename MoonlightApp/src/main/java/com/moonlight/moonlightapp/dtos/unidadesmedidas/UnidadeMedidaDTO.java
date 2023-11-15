package com.moonlight.moonlightapp.dtos.unidadesmedidas;

import com.moonlight.moonlightapp.dtos.DTO;

public class UnidadeMedidaDTO implements DTO {
    private String nome;
    private String sigla;

    public UnidadeMedidaDTO(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
