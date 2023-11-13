package com.moonlight.moonlightapp.models;

/**
 * Classe que representa um tipo de matéria prima de um produto a ser fabricado.
 * 
 * @author victor.santos09
 */
public class TipoMateriaPrimaModel extends BaseModel {

    private String nome;

    public TipoMateriaPrimaModel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
