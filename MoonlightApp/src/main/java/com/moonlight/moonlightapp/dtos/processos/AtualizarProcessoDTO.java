package com.moonlight.moonlightapp.dtos.processos;

public class AtualizarProcessoDTO {
    private final String etapaOriginal;
    private final String etapaNova;
    private final Double custo;

    public AtualizarProcessoDTO(String etapaOriginal, String etapaNova, Double custo) {
        this.etapaOriginal = etapaOriginal;
        this.etapaNova = etapaNova;
        this.custo = custo;
    }

    public String getEtapaOriginal() {
        return etapaOriginal;
    }

    public String getEtapaNova() {
        return etapaNova;
    }

    public Double getCusto() {
        return custo;
    }
}
