package com.moonlight.moonlightapp.models;

/**
 * Classe que representa uma unidade de medida de uma matéria prima ou um
 * produto a ser fabricado.
 * 
 * @author victor.santos09
 */
public class UnidadeMedidaModel extends Identificavel {

    private String nome;
    private String sigla;

    public UnidadeMedidaModel(String nome, String sigla) {
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
