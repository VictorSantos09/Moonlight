package com.moonlight.moonlightapp.validators.dtos;

import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.models.ResultadoValidacao;
import com.moonlight.moonlightapp.validators.contracts.DTOValidator;

public class ProcessoDTOValidator extends BaseValidator
        implements DTOValidator<ProcessoDTO> {
    @Override
    public ResultadoValidacao validar(ProcessoDTO dto) {
        if (isZeroOrNegativte(dto.getCusto())) {
            addFailure("custo do processo inválido");
        }
        if (isBlankOrEmpty(dto.getEtapa())) {
            addFailure("etapa do processo inválida");
        }
        return build();
    }
}
