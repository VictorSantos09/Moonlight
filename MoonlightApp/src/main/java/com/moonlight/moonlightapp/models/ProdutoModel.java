package com.moonlight.moonlightapp.models;

import java.util.List;

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
    private List<ProcessoModel> processos;

    public ProdutoModel(String nome, String descricao, ValorProdutoModel valorProduto,
            UnidadeMedidaModel unidadeMedida, TipoProdutoModel tipo, List<ProcessoModel> processos) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorProduto = valorProduto;
        this.unidadeMedida = unidadeMedida;
        this.tipo = tipo;
        this.processos = processos;
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

    public List<ProcessoModel> getProcessos() {
        return processos;
    }

    public void setProcessos(List<ProcessoModel> processos) {
        this.processos = processos;
    }
}
