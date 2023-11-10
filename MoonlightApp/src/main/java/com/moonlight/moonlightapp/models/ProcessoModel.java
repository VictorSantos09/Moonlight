/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moonlight.moonlightapp.models;

/**
 *
 * @author victor.santos8
 */
public class ProcessoModel extends Identificavel {
    private String etapa;
    private double custo;
    private ProdutoModel produto;

    public ProcessoModel(String etapa, double custo, ProdutoModel produto) {
        this.etapa = etapa;
        this.custo = custo;
        this.produto = produto;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}
