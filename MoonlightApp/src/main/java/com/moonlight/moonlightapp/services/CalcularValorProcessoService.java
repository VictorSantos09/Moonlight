package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.ProcessoModel;

import java.util.List;

public class CalcularValorProcessoService {
    public static Double calcular(List<ProcessoModel> processos) {
        return processos.stream().mapToDouble(ProcessoModel::getCusto).sum() / processos.size();
    }
}
