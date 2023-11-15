package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.TipoProdutoModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class TipoProdutoValidator extends BaseModelValidator
        implements ModelValidator<TipoProdutoModel> {

    @Override
    public ResultadoValidacao validar(TipoProdutoModel model) {
        if (model.getNome().isEmpty() || model.getNome().isBlank())
            build("nome do tipo de produto inválido");

        return resultado;
    }
}
