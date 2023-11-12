/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moonlight.moonlightapp.models;

/**
 *
 * @author victor.santos8
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
