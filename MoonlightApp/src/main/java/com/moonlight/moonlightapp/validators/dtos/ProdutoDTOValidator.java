package com.moonlight.moonlightapp.validators.dtos;

import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.ResultadoValidacao;
import com.moonlight.moonlightapp.validators.contracts.DTOValidator;

public class ProdutoDTOValidator extends BaseValidator
        implements DTOValidator<ProdutoDTO> {
    private final UnidadeMedidaDTOValidator unidadeMedidaDTOValidator;
    private final ProcessoDTOValidator processoDTOValidator;
    private final TipoProdutoDTOValidator tipoProdutoDTOValidator;
    private final ItemProdutoDTOValidator itemProdutoDTOValidator;

    public ProdutoDTOValidator() {
        unidadeMedidaDTOValidator = new UnidadeMedidaDTOValidator();
        processoDTOValidator = new ProcessoDTOValidator();
        tipoProdutoDTOValidator = new TipoProdutoDTOValidator();
        itemProdutoDTOValidator = new ItemProdutoDTOValidator();
    }

    @Override
    public ResultadoValidacao validar(ProdutoDTO dto) {
        if (isBlankOrEmpty(dto.getNome())) {
            addFailure("nome do produto inválido");
        }
        if (isBlankOrEmpty(dto.getDescricao())) {
            addFailure("descrição do produto inválida");
        }
        if (isZeroOrNegativte(dto.getValor())) {
            addFailure("valor do produto inválido");
        }

        validarProcessos(dto);
        validarUnidadeMedida(dto);
        validarTipoProduto(dto);
        validarItemProduto(dto);
        return build();
    }

    private void validarProcessos(ProdutoDTO dto) {
       dto.getProcessos().forEach(p -> {
           var result = processoDTOValidator.validar(p);
           if (!result.isValido()) {
               addFailure(result);
           }
       });
    }

    private void validarUnidadeMedida(ProdutoDTO dto) {
        var resultado = unidadeMedidaDTOValidator.validar(dto.getUnidadeMedida());
        if (!resultado.isValido()) {
            addFailure(resultado);
        }
    }

    private void validarTipoProduto(ProdutoDTO dto) {
        var resultado = tipoProdutoDTOValidator.validar(dto.getTipoProduto());
        if (!resultado.isValido()) {
            addFailure(resultado);
        }
    }

    private void validarItemProduto(ProdutoDTO dto) {
        dto.getItensProdutos().forEach(x -> {
            var resultado = itemProdutoDTOValidator.validar(x);

            if (!resultado.isValido()) {
                addFailure(resultado);
            }
        });
    }
}
