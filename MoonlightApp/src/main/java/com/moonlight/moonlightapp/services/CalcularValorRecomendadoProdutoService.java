package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.ProcessoModel;

import java.util.List;

public class CalcularValorRecomendadoProdutoService {
    private static final double margemLucro = 0.3;

    public static Double calcular(MateriaPrimaModel materiaPrima) {
        return calcularMateriaPrima(materiaPrima);
    }

    public static Double calcular(List<MateriaPrimaModel> materiasPrimas) {
        double subTotalMateriasPrimas = 0;

        for (var ip : materiasPrimas) {
            subTotalMateriasPrimas += calcularMateriaPrima(ip);
        }

        return subTotalMateriasPrimas;
    }

    public static Double calcularProcessos(List<ProcessoModel> processos) {
        double subTotalProcessos = 0;

        for (var processo : processos) {
            subTotalProcessos += CalcularValorProcessoService.calcular(processo);
        }

        return subTotalProcessos;
    }

    public static Double calcularProcesso(ProcessoModel processo) {
        return CalcularValorProcessoService.calcular(processo);
    }

    private static Double calcularMateriaPrima(MateriaPrimaModel materiaPrima) {
        return (materiaPrima.getValor() + (materiaPrima.getValor() * margemLucro));
    }
}
