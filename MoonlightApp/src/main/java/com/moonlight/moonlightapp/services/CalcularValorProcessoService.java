package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.ProcessoModel;

import java.util.List;

public class CalcularValorProcessoService {
    private static final double margemLucro = 0.1;

    public static Double calcular(List<ProcessoModel> processos) {
        double totalProcessos = processos.stream().mapToDouble(ProcessoModel::getCusto).sum();
        return efetuarCalculo(totalProcessos);
    }

    public static Double calcular(ProcessoModel processo) {
        return efetuarCalculo(processo.getCusto());
    }

    private static Double efetuarCalculo(double subTotal) {
        return subTotal + (subTotal * margemLucro);
    }
}
