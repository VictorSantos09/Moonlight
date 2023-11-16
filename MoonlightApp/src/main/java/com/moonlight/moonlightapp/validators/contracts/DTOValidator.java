package com.moonlight.moonlightapp.validators.contracts;

import com.moonlight.moonlightapp.dtos.DTO;
import com.moonlight.moonlightapp.validators.models.ResultadoValidacao;

public interface DTOValidator<T extends DTO> {
    ResultadoValidacao validar(T dto);
}
