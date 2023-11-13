package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.ProcessoModel;

import java.util.List;

public class CalcularValorProcessoService {
    private static double margemLucro = 0.1;

    public static Double calcular(List<ProcessoModel> processos) {
        double totalProcessos = processos.stream().mapToDouble(ProcessoModel::getCusto).sum();
        return efetuarCalculo(totalProcessos, processos.size());
    }

    public static Double calcular(ProcessoModel processo) {
        return efetuarCalculo(processo.getCusto(), 1);
    }

    private static Double efetuarCalculo(double total, int size) {
        return total * margemLucro / size;
    }
}
