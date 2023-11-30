package com.moonlight.moonlightapp.models;

/**
 * Classe que representa um processo de um produto a ser fabricado.
 *
 * @author victor.santos9
 */
public class ProcessoModel extends BaseModel {
    private String etapa;
    private double custo;

    public ProcessoModel(String etapa, double custo) {
        this.etapa = etapa;
        this.custo = custo;
    }

    

    @Override
    public String toString() {
        return etapa;
    }



    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public double getCusto() {
        return this.custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
