/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moonlight.moonlightapp.dtos.produtos;

import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.models.TipoProdutoModel;

import java.util.List;

/**
 *
 * @author victor.santos8
 */
public class ProdutoDTO {
    private String nome;
    private String descricao;
    private Integer valor;
    private String tipo;
    private String siglaUnidadeMedida;
    private List<ProcessoDTO> processos;
    private List<ItemProdutoDTO>  itensProdutos;
    private TipoProdutoModel tipoProduto;

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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSiglaUnidadeMedida() {
        return siglaUnidadeMedida;
    }

    public void setSiglaUnidadeMedida(String siglaUnidadeMedida) {
        this.siglaUnidadeMedida = siglaUnidadeMedida;
    }

    public List<ProcessoDTO> getProcessos() {
        return processos;
    }

    public void setProcessos(List<ProcessoDTO> processos) {
        this.processos = processos;
    }

    public List<ItemProdutoDTO> getItensProdutos() {
        return itensProdutos;
    }

    public void setItensProdutos(List<ItemProdutoDTO> itensProdutos) {
        this.itensProdutos = itensProdutos;
    }

    public TipoProdutoModel getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProdutoModel tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
