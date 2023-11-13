/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moonlight.moonlightapp.models;

import java.util.ArrayList;

/**
 * @author victor.santos8
 */
public class ItensProdutoModel extends Identificavel {
    private int quantidade;
    private ProdutoModel produto;
    private MateriaPrimaModel materiaPrima;
    private double subTotal;

    public ItensProdutoModel(int quantidade, ProdutoModel produto, double valor, MateriaPrimaModel materiasPrima) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.subTotal = valor;
        this.materiaPrima = materiasPrima;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public MateriaPrimaModel getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrimaModel materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double valor) {
        this.subTotal = valor;
    }
}
