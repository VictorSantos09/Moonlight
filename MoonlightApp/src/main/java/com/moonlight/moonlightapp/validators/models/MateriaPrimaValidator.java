package com.moonlight.moonlightapp.validators.models;

import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class MateriaPrimaValidator extends BaseValidator
        implements ModelValidator<MateriaPrimaModel> {
    private final UnidadeMedidaValidator unidadeMedidaValidator;
    private final TipoMateriaPrimaValidator tipoMateriaPrimaValidator;

    public MateriaPrimaValidator() {
        unidadeMedidaValidator = new UnidadeMedidaValidator();
        tipoMateriaPrimaValidator = new TipoMateriaPrimaValidator();
    }

    @Override
    public ResultadoValidacao validar(MateriaPrimaModel model) {
        if (model.getNome().isEmpty() || model.getNome().isBlank()) {
            addFailure("nome da matéria prima inválida");
        }

        if (model.getDescricao().isEmpty() || model.getDescricao().isBlank()) {
            addFailure("descrição da matéria prima inválida");
        }

        if (model.getQuantidade() <= 0) {
            addFailure("quantidade da matéria prima inválida");
        }

        if (model.getValor() <= 0) {
            addFailure("valor da matéria prima inválido");
        }

        var resultadoUnidadeMedida = unidadeMedidaValidator.validar(model.getUnidadeMedida());
        if (!resultadoUnidadeMedida.isValido()) {
            addFailure(resultadoUnidadeMedida);
        }

        var resultadoTipoMateriaPrima = tipoMateriaPrimaValidator.validar(model.getTipoMateriaPrima());
        if (!resultadoTipoMateriaPrima.isValido()) {
            addFailure(resultadoTipoMateriaPrima);
        }

        return build();
    }
}
