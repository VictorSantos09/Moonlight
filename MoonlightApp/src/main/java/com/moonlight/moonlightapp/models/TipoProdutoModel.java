package com.moonlight.moonlightapp.models;

/**
 * Classe que representa um tipo de produto a ser fabricado pela empresa.
 *
 * @author victor.santos09
 */
public class TipoProdutoModel extends BaseModel {

    private String nome;

    public TipoProdutoModel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
