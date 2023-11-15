package com.moonlight.moonlightapp.validators.dtos;

import com.moonlight.moonlightapp.dtos.unidadesmedidas.UnidadeMedidaDTO;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.ResultadoValidacao;
import com.moonlight.moonlightapp.validators.contracts.DTOValidator;

public class UnidadeMedidaDTOValidator extends BaseValidator
        implements DTOValidator<UnidadeMedidaDTO> {
    @Override
    public ResultadoValidacao validar(UnidadeMedidaDTO dto) {
        if (isBlankOrEmpty(dto.getNome())) {
            addFailure("nome da unidade de medida inválido");
        }
        if (isBlankOrEmpty(dto.getSigla())) {
            addFailure("sigla da unidade de medida inválida");
        }

        return build();
    }
}
