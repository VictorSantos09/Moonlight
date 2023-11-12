/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moonlight.moonlightapp.models;

/**
 * @author victor.santos8
 */
public class ProdutoModel extends Identificavel {
    private String nome;
    private String descricao;
    private ValorProdutoModel valorProduto;

    public ProdutoModel(String nome, String descricao, ValorProdutoModel valorProduto) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorProduto = valorProduto;
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

    public ValorProdutoModel getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(ValorProdutoModel valorProduto) {
        this.valorProduto = valorProduto;
    }
}
