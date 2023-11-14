package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class UnidadeMedidaValidator implements ModelValidator<UnidadeMedidaModel> {

    @Override
    public ResultadoValidacao validar(UnidadeMedidaModel model) {
        if (model.getNome().isEmpty() || model.getNome().isBlank())
            return ResultadoValidacao.buildFalha("nome da unidade de medida inválido");

        if (model.getSigla().isEmpty() || model.getSigla().isBlank())
            return ResultadoValidacao.buildFalha("sigla da unidade de medida inválida");

        return ResultadoValidacao.buildSucesso("unidade de medida válida");
    }
}
