package com.moonlight.moonlightapp.models;

/**
 * Classe que representa um produto final da empresa.
 *
 * @author victor.santos09
 */
public class ProdutoModel extends BaseModel {
    private String nome;
    private String descricao;
    private ValorProdutoModel valorProduto;
    private UnidadeMedidaModel unidadeMedida;
    private TipoProdutoModel tipo;

    public ProdutoModel(String nome, String descricao,
            UnidadeMedidaModel unidadeMedida, TipoProdutoModel tipo, double valorRecomendado, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.tipo = tipo;
        valorProduto = new ValorProdutoModel(valorRecomendado, valor);
    }

    @Override
    public String toString() {
        return nome;
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

    public UnidadeMedidaModel getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedidaModel unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public TipoProdutoModel getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutoModel tipo) {
        this.tipo = tipo;
    }
}
