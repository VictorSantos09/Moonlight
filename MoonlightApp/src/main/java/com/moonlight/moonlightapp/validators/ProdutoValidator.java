package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.TipoProdutoModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.models.ValorProdutoModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class ProdutoValidator extends BaseModelValidator
        implements ModelValidator<ProdutoModel> {

    private final UnidadeMedidaValidator unidadeMedidaValidator = new UnidadeMedidaValidator();
    private final TipoProdutoValidator tipoProdutoValidator = new TipoProdutoValidator();
    private final ValorProdutoValidator valorProdutoValidator = new ValorProdutoValidator();

    @Override
    public ResultadoValidacao validar(ProdutoModel model) {
        if (model == null)
            build("produto inválido");

        if (model.getNome().isEmpty() || model.getNome().isBlank())
            build("nome do produto inválido");

        if (model.getDescricao().isEmpty() || model.getDescricao().isBlank())
            build("descrição do produto inválida");

        validarTipoProduto(model.getTipo());
        validarUnidadeMedida(model.getUnidadeMedida());
        validarValorProduto(model.getValorProduto());

        return resultado;
    }

    private void validarUnidadeMedida(UnidadeMedidaModel model) {
        var resultado = unidadeMedidaValidator.validar(model);
        build(resultado);
    }

    private void validarTipoProduto(TipoProdutoModel model) {
        var resultado = tipoProdutoValidator.validar(model);
        build(resultado);
    }

    private void validarValorProduto(ValorProdutoModel model) {
        var resultado = valorProdutoValidator.validar(model);
        build(resultado);
    }

}