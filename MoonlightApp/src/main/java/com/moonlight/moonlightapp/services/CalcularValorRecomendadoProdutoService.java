package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.ItemProdutoModel;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.ProcessoModel;

import java.util.List;

public class CalcularValorRecomendadoProdutoService {
    private static final double margemLucro = 0.3;

    public static Double calcular(List<ProcessoModel> processos, List<ItemProdutoModel> itensProdutos) {
        double subTotalProcessos = 0;
        double subTotalMateriasPrimas = 0;

        for (var processo : processos) {
            subTotalProcessos += CalcularValorProcessoService.calcular(processo);
        }

        for (var mp : itensProdutos) {
            subTotalMateriasPrimas += mp.getMateriaPrima().getValor() * mp.getQuantidade();
        }

        double subTotal = subTotalProcessos + subTotalMateriasPrimas;
        return subTotal + (subTotal * margemLucro);
    }
}
