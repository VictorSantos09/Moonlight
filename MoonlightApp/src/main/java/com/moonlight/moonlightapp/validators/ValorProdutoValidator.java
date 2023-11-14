package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.ValorProdutoModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class ValorProdutoValidator implements ModelValidator<ValorProdutoModel> {

    @Override
    public ResultadoValidacao validar(ValorProdutoModel model) {
        if (model == null)
            return ResultadoValidacao.buildFalha("valor do produto inválido");

        if (model.getValor() <= 0)
            return ResultadoValidacao.buildFalha("valor do produto inválido");

        return ResultadoValidacao.buildSucesso("valor do produto válido");
    }
}
