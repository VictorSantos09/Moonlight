package com.moonlight.moonlightapp.validators.dtos;

import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;
import com.moonlight.moonlightapp.validators.BaseValidator;
import com.moonlight.moonlightapp.validators.DefaultValidator;
import com.moonlight.moonlightapp.validators.contracts.DTOValidator;
import com.moonlight.moonlightapp.validators.models.ResultadoValidacao;

public class MateriaPrimaDTOValidator extends BaseValidator
        implements DTOValidator<MateriaPrimaDTO> {

    @Override
    public ResultadoValidacao validar(MateriaPrimaDTO dto) {
        if (DefaultValidator.isBlankOrEmpty(dto.getNome())) {
            addFailure("nome da matéria prima inválido");
        }

        if (DefaultValidator.isBlankOrEmpty(dto.getDescricao())) {
            addFailure("descricao da matéria prima inválida");
        }

        if (DefaultValidator.isBlankOrEmpty(dto.getSiglaUnidadeMedida())) {
            addFailure("unidade de medida da matéria prima inválida");
        }

        if (DefaultValidator.isBlankOrEmpty(dto.getTipo())) {
            addFailure("tipo da matéria prima inválida");
        }
        
        return build();
    }

}
