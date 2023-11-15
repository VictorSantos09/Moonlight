package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class UnidadeMedidaValidator extends BaseModelValidator
        implements ModelValidator<UnidadeMedidaModel> {

    @Override
    public ResultadoValidacao validar(UnidadeMedidaModel model) {
        if (model.getNome().isEmpty() || model.getNome().isBlank())
            build("nome da unidade de medida inválido");

        if (model.getSigla().isEmpty() || model.getSigla().isBlank())
            build("sigla da unidade de medida inválida");

        return resultado;
    }
}
