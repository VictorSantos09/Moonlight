package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.ItensProdutoModel;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;

import java.util.List;

public class CalcularValorRecomendadoProdutoService {
    private static final Double margemLucro = 0.75;

    public static Double calcular(ItensProdutoModel itensProduto) {
        List<MateriaPrimaModel> materiasprimasNecessarias = itensProduto.getMateriasPrimas();

        return realizarCalculo(materiasprimasNecessarias);
    }

    public static Double calcular(List<MateriaPrimaModel> materiasPrimas) {
        return realizarCalculo(materiasPrimas);
    }

    private static Double realizarCalculo(List<MateriaPrimaModel> materiasPrimas) {
        double subtotalMateriaPrima = materiasPrimas.stream()
                .mapToDouble(m -> m.getValor() * m.getQuantidade())
                .sum();

        Double precoVenda = (subtotalMateriaPrima + (subtotalMateriaPrima * margemLucro));
        return precoVenda;
    }
}
