package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.ProcessoModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class ProcessoValidator extends BaseValidator
        implements ModelValidator<ProcessoModel> {
    @Override
    public ResultadoValidacao validar(ProcessoModel model) {
        if (model.getCusto() <= 0) {
            addFailure("custo inválido");
        }
        if (model.getEtapa().isBlank() || model.getEtapa().isEmpty()) {
            addFailure("etapa inválida");
        }

        return build();
    }
}
