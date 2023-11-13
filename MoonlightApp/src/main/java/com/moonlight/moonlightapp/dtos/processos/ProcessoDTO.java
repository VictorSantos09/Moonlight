package com.moonlight.moonlightapp.dtos.processos;

public class ProcessoDTO {
    private String etapa;
    private Double custo;

    public ProcessoDTO(String etapa, Double custo) {
        this.etapa = etapa;
        this.custo = custo;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }
}
