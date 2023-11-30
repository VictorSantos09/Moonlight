package com.moonlight.moonlightapp.dtos.materiasprimas;

/**
 *
 * @author amanda.medeiros1
 */
public class AtualizarMateriaPrimaDTO {
    private final String nomeNovo;
    private final String nomeOriginal;
    private final String descricao;
    private final Double valor;
    private final Integer quantidade;
    private final String siglaUnidadeMedida;
    private final String tipo;

    public AtualizarMateriaPrimaDTO(String nomeNovo, String nomeOriginal, String descricao,
            Double valor, Integer quantidade, String siglaUnidadeMedida, String tipo) {
        this.nomeNovo = nomeNovo;
        this.nomeOriginal = nomeOriginal;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.siglaUnidadeMedida = siglaUnidadeMedida;
        this.tipo = tipo;
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

    public Double getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getSiglaUnidadeMedida() {
        return siglaUnidadeMedida;
    }

    public String getTipo() {
        return tipo;
    }

}
