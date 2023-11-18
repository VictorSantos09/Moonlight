package com.moonlight.moonlightapp.dtos.produtos;

import com.moonlight.moonlightapp.dtos.unidadesmedidas.UnidadeMedidaDTO;

public class AtualizarInformacoesProdutoDTO {
    private final String nomeNovo;
    private final String nomeOriginal;
    private final String descricao;
    private final UnidadeMedidaDTO unidadeMedida;
    private final TipoProdutoDTO tipoProduto;
    private final Double valor;

    public AtualizarInformacoesProdutoDTO(String nomeNovo, String nomeOriginal, String descricao,
                                          UnidadeMedidaDTO unidadeMedida, TipoProdutoDTO tipoProduto, Double valor) {
        this.nomeNovo = nomeNovo;
        this.nomeOriginal = nomeOriginal;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.tipoProduto = tipoProduto;
        this.valor = valor;
    }

    public String getNomeNovo() {
        return nomeNovo;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public String getDescricao() {
        return descricao;
    }

    public UnidadeMedidaDTO getUnidadeMedida() {
        return unidadeMedida;
    }

    public TipoProdutoDTO getTipoProduto() {
        return tipoProduto;
    }

    public Double getValor() {
        return valor;
    }
}
