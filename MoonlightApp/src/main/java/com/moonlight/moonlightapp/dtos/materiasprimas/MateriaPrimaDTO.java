package com.moonlight.moonlightapp.dtos.materiasprimas;

public class MateriaPrimaDTO {
    private String nome;
    private String descricao;
    private Double valor;
    private Integer quantidade;
    private String siglaUnidadeMedida;
    private String tipo;

    public MateriaPrimaDTO(String nome, String descricao, Double valor, Integer quantidade, String siglaUnidadeMedida, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.siglaUnidadeMedida = siglaUnidadeMedida;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getSiglaUnidadeMedida() {
        return siglaUnidadeMedida;
    }

    public void setSiglaUnidadeMedida(String siglaUnidadeMedida) {
        this.siglaUnidadeMedida = siglaUnidadeMedida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
