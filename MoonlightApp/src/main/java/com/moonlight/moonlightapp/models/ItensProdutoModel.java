package com.moonlight.moonlightapp.models;

/**
 * Classe que representa o relacionamento entre ProdutoModel e sua MateriaPrimaModel e a quantidade de cada uma delas.
 * @author victor.santos09
 */

 public class ItensProdutoModel extends BaseModel {
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
