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
    private List<MateriaPrimaDTO> materiasPrimas;
    private TipoProdutoModel tipoProduto;

    public ProdutoDTO(String nome, String descricao, Integer valor, String tipo,
                      String siglaUnidadeMedida, List<ProcessoDTO> processos,
                      List<MateriaPrimaDTO> materiasPrimas, TipoProdutoModel tipoProduto) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.siglaUnidadeMedida = siglaUnidadeMedida;
        this.processos = processos;
        this.materiasPrimas = materiasPrimas;
        this.tipoProduto = tipoProduto;
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

    public List<MateriaPrimaDTO> getMateriasPrimas() {
        return materiasPrimas;
    }

    public void setMateriasPrimas(List<MateriaPrimaDTO> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }

    public TipoProdutoModel getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProdutoModel tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
