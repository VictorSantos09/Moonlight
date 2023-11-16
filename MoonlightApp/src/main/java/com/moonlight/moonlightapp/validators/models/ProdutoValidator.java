package com.moonlight.moonlightapp.validators.models;

import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.TipoProdutoModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.models.ValorProdutoModel;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class ProdutoValidator extends BaseValidator
        implements ModelValidator<ProdutoModel> {

    private final UnidadeMedidaValidator unidadeMedidaValidator = new UnidadeMedidaValidator();
    private final TipoProdutoValidator tipoProdutoValidator = new TipoProdutoValidator();
    private final ValorProdutoValidator valorProdutoValidator = new ValorProdutoValidator();

    @Override
    public ResultadoValidacao validar(ProdutoModel model) {
        if (model == null)
            addFailure("produto inválido");

        if (model.getNome().isEmpty() || model.getNome().isBlank())
            addFailure("nome do produto inválido");

        if (model.getDescricao().isEmpty() || model.getDescricao().isBlank())
            addFailure("descrição do produto inválida");

        validarTipoProduto(model.getTipo());
        validarUnidadeMedida(model.getUnidadeMedida());
        validarValorProduto(model.getValorProduto());

        return build();
    }

    private void validarUnidadeMedida(UnidadeMedidaModel model) {
        var resultado = unidadeMedidaValidator.validar(model);
        addFailure(resultado);
    }

    private void validarTipoProduto(TipoProdutoModel model) {
        var resultado = tipoProdutoValidator.validar(model);
        addFailure(resultado);
    }

    private void validarValorProduto(ValorProdutoModel model) {
        var resultado = valorProdutoValidator.validar(model);
        addFailure(resultado);
    }

}