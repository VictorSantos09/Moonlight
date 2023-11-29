package com.moonlight.moonlightapp.models.relatorios;

public class BaseProdutoRelatorio {
    private String nome;
    private String tipo;
    private Double valorVenda;
    private  Double valorRecomendado;
    private Double subtotal;

    public BaseProdutoRelatorio(String nome, String tipo, Double valorVenda, Double valorRecomendado, Double subtotal) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorVenda = valorVenda;
        this.valorRecomendado = valorRecomendado;
        this.subtotal = subtotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getValorRecomendado() {
        return valorRecomendado;
    }

    public void setValorRecomendado(Double valorRecomendado) {
        this.valorRecomendado = valorRecomendado;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
