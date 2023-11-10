/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moonlight.moonlightapp.models;

/**
 *
 * @author victor.santos8
 */
public class ValoresProdutoModel extends Identificavel {

    private double valorRecomendado;
    private double valor;
    private ProdutoModel produto;

    public ValoresProdutoModel(double valorRecomendado, double valor, ProdutoModel produto) {
        this.valorRecomendado = valorRecomendado;
        this.valor = valor;
        this.produto = produto;
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

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}
