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
public class ProdutoTiposModel extends Identificavel {
    private ProdutoModel produto;
    private ArrayList<TipoProdutoModel> tipos;

    public ProdutoTiposModel(ProdutoModel produto) {
        this.produto = produto;
        tipos = new ArrayList<>();
    }

    public void addTipo(TipoProdutoModel tipo) {
        tipos.add(tipo);
    }

    public void removeTipo(TipoProdutoModel tipo) {
        tipos.remove(tipo);
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public ArrayList<TipoProdutoModel> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<TipoProdutoModel> tipos) {
        this.tipos = tipos;
    }
}
