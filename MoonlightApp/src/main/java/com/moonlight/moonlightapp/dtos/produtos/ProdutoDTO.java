/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moonlight.moonlightapp.dtos.produtos;

import com.moonlight.moonlightapp.dtos.DTO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.dtos.unidadesmedidas.UnidadeMedidaDTO;

import java.util.List;

/**
 * @author victor.santos8
 */
public class ProdutoDTO implements DTO {
    private final String nome;
    private final String descricao;
    private final Integer valor;
    private final List<ProcessoDTO> processos;
    private final List<ItemProdutoDTO> itensProdutos;
    private final TipoProdutoDTO tipoProduto;
    private final UnidadeMedidaDTO unidadeMedida;

    public ProdutoDTO(String nome, String descricao, Integer valor, List<ProcessoDTO> processos,
                      List<ItemProdutoDTO> itensProdutos, TipoProdutoDTO tipoProduto, UnidadeMedidaDTO unidadeMedida) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.processos = processos;
        this.itensProdutos = itensProdutos;
        this.tipoProduto = tipoProduto;
        this.unidadeMedida = unidadeMedida;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public List<ProcessoDTO> getProcessos() {
        return processos;
    }

    public List<ItemProdutoDTO> getItensProdutos() {
        return itensProdutos;
    }

    public TipoProdutoDTO getTipoProduto() {
        return tipoProduto;
    }

    public UnidadeMedidaDTO getUnidadeMedida() {
        return unidadeMedida;
    }
}
