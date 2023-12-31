package com.moonlight.moonlightapp.models;

/**
 * Classe que representa o relacionamento entre ProdutoModel e sua MateriaPrimaModel e a quantidade de cada uma delas.
 *
 * @author victor.santos09
 */

public class ItemProdutoModel extends BaseModel {
    private Float quantidade;
    private ProdutoModel produto;
    private MateriaPrimaModel materiaPrima;
    private Double subTotal;

    public ItemProdutoModel(Float quantidade, ProdutoModel produto, Double subTotal, MateriaPrimaModel materiaPrima) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.subTotal = subTotal;
        this.materiaPrima = materiaPrima;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
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

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
