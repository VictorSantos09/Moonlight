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
public class ProdutoMedidasModel extends Identificavel {

    private ArrayList<UnidadeMedidaModel> unidadesMedidas;
    private ProdutoModel produto;

    public ProdutoMedidasModel(ProdutoModel produto) {
        this.produto = produto;
        unidadesMedidas = new ArrayList<>();
    }

    public void addUnidadeMedida(UnidadeMedidaModel unidadeMedida) {
        unidadesMedidas.add(unidadeMedida);
    }

    public void removeUnidadeMedida(UnidadeMedidaModel unidadeMedida) {
        unidadesMedidas.remove(unidadeMedida);
    }

    public ArrayList<UnidadeMedidaModel> getUnidadesMedidas() {
        return unidadesMedidas;
    }

    public void setUnidadesMedidas(ArrayList<UnidadeMedidaModel> unidadesMedidas) {
        this.unidadesMedidas = unidadesMedidas;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}
