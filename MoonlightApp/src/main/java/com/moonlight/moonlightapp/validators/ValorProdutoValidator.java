package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.ValorProdutoModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class ValorProdutoValidator extends BaseModelValidator
        implements ModelValidator<ValorProdutoModel> {

    @Override
    public ResultadoValidacao validar(ValorProdutoModel model) {
        if (model == null)
            build("valor do produto inválido");

        if (model.getValor() <= 0)
            build("valor do produto inválido");

        return resultado;
    }
}
