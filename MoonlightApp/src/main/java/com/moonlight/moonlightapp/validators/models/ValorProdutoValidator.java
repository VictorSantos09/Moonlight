package com.moonlight.moonlightapp.validators.models;

import com.moonlight.moonlightapp.models.ValorProdutoModel;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class ValorProdutoValidator extends BaseValidator
        implements ModelValidator<ValorProdutoModel> {

    @Override
    public ResultadoValidacao validar(ValorProdutoModel model) {
        if (model == null)
            addFailure("valor do produto inválido");

        if (model.getValor() <= 0)
            addFailure("valor do produto inválido");

        return build();
    }
}
