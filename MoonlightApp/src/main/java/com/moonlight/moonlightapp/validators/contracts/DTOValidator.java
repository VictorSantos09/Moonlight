package com.moonlight.moonlightapp.validators.contracts;

import com.moonlight.moonlightapp.dtos.DTO;
import com.moonlight.moonlightapp.validators.ResultadoValidacao;

import java.util.ArrayList;
import java.util.List;

public interface DTOValidator<T extends DTO> {
    ResultadoValidacao validar(T dto);
}
