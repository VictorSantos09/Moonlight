package com.moonlight.moonlightapp.validators.dtos;

import com.moonlight.moonlightapp.dtos.produtos.ItemProdutoDTO;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.ResultadoValidacao;
import com.moonlight.moonlightapp.validators.contracts.DTOValidator;

public class ItemProdutoDTOValidator extends BaseValidator
        implements DTOValidator<ItemProdutoDTO> {
    @Override
    public ResultadoValidacao validar(ItemProdutoDTO dto) {
        if (isZeroOrNegativte(dto.getQuantidade())) {
            addFailure("quantidade do item produto inválida");
        }
        if (isBlankOrEmpty(dto.getNomeProduto())) {
            addFailure("nome do item produto inválido");
        }

        if (isBlankOrEmpty(dto.getNomeMateriaPrima())) {
            addFailure("nome da matéria prima do item produto inválida");
        }
        return build();
    }
}
