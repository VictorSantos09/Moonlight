package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.TipoProdutoModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class TipoProdutoValidator implements ModelValidator<TipoProdutoModel> {

    @Override
    public ResultadoValidacao validar(TipoProdutoModel model) {
        if (model.getNome().isEmpty() || model.getNome().isBlank())
            return ResultadoValidacao.buildFalha("nome do tipo de produto inválido");

        return ResultadoValidacao.buildSucesso("tipo de produto válido");
    }
}
