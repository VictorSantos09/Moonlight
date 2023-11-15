package com.moonlight.moonlightapp.validators.models;

import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class UnidadeMedidaValidator extends BaseValidator
        implements ModelValidator<UnidadeMedidaModel> {

    @Override
    public ResultadoValidacao validar(UnidadeMedidaModel model) {
        if (model.getNome().isEmpty() || model.getNome().isBlank())
            addFailure("nome da unidade de medida inválido");

        if (model.getSigla().isEmpty() || model.getSigla().isBlank())
            addFailure("sigla da unidade de medida inválida");

        return build();
    }
}
