package com.moonlight.moonlightapp.validators.contracts;

import com.moonlight.moonlightapp.dtos.DTO;
import com.moonlight.moonlightapp.validators.ResultadoValidacao;

public interface DTOValidator<T extends DTO> {
    ResultadoValidacao validar(T dto);
}
