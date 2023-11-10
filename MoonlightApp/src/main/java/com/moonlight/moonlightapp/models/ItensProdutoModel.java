/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moonlight.moonlightapp.models;

import java.util.ArrayList;

/**
 *
 * @author victor.santos8
 */
public class ItensProdutoModel extends Identificavel {
    private int quantidade;
    private ProdutoModel produto;
    private ArrayList<MateriaPrimaModel> materiasPrimas;
    private double subTotal;

    public ItensProdutoModel(int quantidade, ProdutoModel produto, double valor) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.subTotal = valor;
        materiasPrimas = new ArrayList<>();
    }

    public void addMateriaPrima(MateriaPrimaModel materiaPrima) {
        materiasPrimas.add(materiaPrima);
    }

    public void removeMateriaPrima(MateriaPrimaModel materiaPrima) {
        materiasPrimas.remove(materiaPrima);
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

    public ArrayList<MateriaPrimaModel> getMateriasPrimas() {
        return materiasPrimas;
    }

    public void setMateriasPrimas(ArrayList<MateriaPrimaModel> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double valor) {
        this.subTotal = valor;
    }
}
