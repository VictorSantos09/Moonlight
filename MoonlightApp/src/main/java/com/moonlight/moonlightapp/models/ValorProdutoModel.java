package com.moonlight.moonlightapp.models;

/**
 * Classe que representa um valor de um produto a ser fabricado.
 * 
 * @author victor.santos09
 */
public class ValorProdutoModel extends Identificavel {
    private double valorRecomendado;
    private double valor;

    public ValorProdutoModel(double valorRecomendado, double valor) {
        this.valorRecomendado = valorRecomendado;
        this.valor = valor;
    }

    public double getValorRecomendado() {
        return valorRecomendado;
    }

    public void setValorRecomendado(double valorRecomendado) {
        this.valorRecomendado = valorRecomendado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
