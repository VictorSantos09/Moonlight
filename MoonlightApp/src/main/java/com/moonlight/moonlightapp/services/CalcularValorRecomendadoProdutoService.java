package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.ItensProdutoModel;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;

import java.util.List;

public class CalcularValorRecomendadoProdutoService {
    private static final Double margemLucro = 0.75;

    public static Double calcular(ItensProdutoModel itensProduto) {
        return realizarCalculo(itensProduto.getMateriaPrima());
    }

    public static Double calcular(List<MateriaPrimaModel> materiasPrimas) {
        return realizarCalculo(materiasPrimas);
    }

    private static Double realizarCalculo(List<MateriaPrimaModel> materiasPrimas) {
        return materiasPrimas.stream().mapToDouble(m -> realizarCalculo(m)).sum();
    }

    private static Double realizarCalculo(MateriaPrimaModel materiaPrima) {
        Double precoVenda = (materiaPrima.getValor() + (materiaPrima.getValor() * margemLucro));
        return precoVenda;
    }
}
