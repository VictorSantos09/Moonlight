package com.moonlight.moonlightapp.services;

import com.moonlight.moonlightapp.models.ItensProdutoModel;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.ProcessoModel;
import com.moonlight.moonlightapp.models.ProdutoModel;

import java.util.List;

public class CalcularValorRecomendadoProdutoService {
    private static final double margemLucro = 0.75;

    public static Double calcular(ItensProdutoModel itensProduto) {
        return realizarCalculo(itensProduto.getMateriaPrima());
    }

    public static Double calcular(List<ItensProdutoModel> itensProdutos) {
        double subTotalProcessos = 0;
        double subTotalMateriasPrimas = 0;

        for (var ip : itensProdutos) {
            subTotalMateriasPrimas += calcular(ip);
            subTotalProcessos += realizarCalculoProcesso(ip.getProduto().getProcessos());
        }

        return subTotalProcessos + subTotalMateriasPrimas;
    }

    private static Double realizarCalculo(MateriaPrimaModel materiaPrima) {
        return (materiaPrima.getValor() + (materiaPrima.getValor() * margemLucro));
    }

    private static Double realizarCalculoProcesso(List<ProcessoModel> processos) {
        return processos.stream().mapToDouble(ProcessoModel::getCusto).sum() / processos.size();
    }
}
