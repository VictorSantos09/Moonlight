package com.moonlight.moonlightapp.models;

/**
 * Classe que representa um processo de um produto a ser fabricado.
 * @author victor.santos9
 */
public class ProcessoModel extends BaseModel {
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
