package com.moonlight.moonlightapp.models;

/**
 * Classe que representa uma matéria prima de um produto.
 *
 * @author victor.santos09
 */
public class MateriaPrimaModel extends BaseModel {
    private String nome;
    private String descricao;
    private double valor;
    private int quantidade;
    private UnidadeMedidaModel unidadeMedida;
    private TipoMateriaPrimaModel tipoMateriaPrima;

    public MateriaPrimaModel(String nome, String descricao, double valor, int quantidade,
                             UnidadeMedidaModel unidadeMedida, TipoMateriaPrimaModel tipoMateriaPrima) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.tipoMateriaPrima = tipoMateriaPrima;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public UnidadeMedidaModel getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedidaModel unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public TipoMateriaPrimaModel getTipoMateriaPrima() {
        return tipoMateriaPrima;
    }

    public void setTipoMateriaPrima(TipoMateriaPrimaModel tipoMateriaPrima) {
        this.tipoMateriaPrima = tipoMateriaPrima;
    }
}
