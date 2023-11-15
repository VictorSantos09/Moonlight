package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.TipoProdutoModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class TipoProdutoValidator extends BaseValidator
        implements ModelValidator<TipoProdutoModel> {

    @Override
    public ResultadoValidacao validar(TipoProdutoModel model) {
        if (model.getNome().isEmpty() || model.getNome().isBlank())
            addFailure("nome do tipo de produto inválido");

        return build();
    }
}
