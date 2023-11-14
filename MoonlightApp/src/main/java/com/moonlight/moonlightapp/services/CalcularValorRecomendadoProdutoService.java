package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.ProcessoModel;

import java.util.List;

public class CalcularValorRecomendadoProdutoService {
    private static final double margemLucro = 0.3;

    public static Double calcularProcessos(List<ProcessoModel> processos, List<MateriaPrimaModel> materiasPrimas) {
        double subTotalProcessos = 0;
        double subTotalMateriasPrimas = 0;

        for (var processo : processos) {
            subTotalProcessos += CalcularValorProcessoService.calcular(processo);
        }

        for (var mp : materiasPrimas) {
            subTotalMateriasPrimas += calcularMateriaPrima(mp);
        }

        return subTotalProcessos + subTotalMateriasPrimas;
    }

    private static Double calcularMateriaPrima(MateriaPrimaModel materiaPrima) {
        return (materiaPrima.getValor() + (materiaPrima.getValor() * margemLucro));
    }
}
