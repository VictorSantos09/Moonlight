package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.TipoProdutoModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.models.ValorProdutoModel;
import com.moonlight.moonlightapp.validators.contracts.ModelValidator;

public class ProdutoValidator implements ModelValidator<ProdutoModel> {
    private ResultadoValidacao resultado = new ResultadoValidacao(false);
    private final UnidadeMedidaValidator unidadeMedidaValidator = new UnidadeMedidaValidator();
    private final TipoProdutoValidator tipoProdutoValidator = new TipoProdutoValidator();
    private final ValorProdutoValidator valorProdutoValidator = new ValorProdutoValidator();

    @Override
    public ResultadoValidacao validar(ProdutoModel model) {

        if (model == null)
            resultado.addFalha("produto inválido");

        if (model.getNome().isEmpty() || model.getNome().isBlank())
            resultado.addFalha("nome do produto inválido");

        if (model.getDescricao().isEmpty() || model.getDescricao().isBlank())
            resultado.addFalha("descrição do produto inválida");

        if (!validarTipoProduto(model.getTipo()).isValido())

            return ResultadoValidacao.buildSucesso("produto válido");

        return resultado;
    }

    private void validarUnidadeMedida(UnidadeMedidaModel model) {
        return unidadeMedidaValidator.validar(model);
    }

    private void validarTipoProduto(TipoProdutoModel model) {
        return tipoProdutoValidator.validar(model);
    }

    private void validarValorProduto(ValorProdutoModel model) {
        return valorProdutoValidator.validar(model);
    }
}
