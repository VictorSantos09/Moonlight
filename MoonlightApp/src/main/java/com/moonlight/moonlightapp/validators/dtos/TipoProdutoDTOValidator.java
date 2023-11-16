package com.moonlight.moonlightapp.validators.dtos;

import com.moonlight.moonlightapp.dtos.produtos.TipoProdutoDTO;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.models.ResultadoValidacao;
import com.moonlight.moonlightapp.validators.contracts.DTOValidator;

public class TipoProdutoDTOValidator extends BaseValidator
        implements DTOValidator<TipoProdutoDTO> {
    @Override
    public ResultadoValidacao validar(TipoProdutoDTO dto) {
        if (isBlankOrEmpty(dto.getNome())) {
            addFailure("tipo do produto inválido");
        }
        return build();
    }
}
