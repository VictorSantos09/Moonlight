package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.TipoMateriaPrimaModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class TipoMateriaPrimaValidator extends BaseValidator
        implements ModelValidator<TipoMateriaPrimaModel> {
    @Override
    public ResultadoValidacao validar(TipoMateriaPrimaModel model) {
        if (model.getNome().isBlank() || model.getNome().isEmpty()) {
            addFailure("nome do tipo da matéria prima inválido");
        }

        return build();
    }
}
