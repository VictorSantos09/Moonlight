package com.moonlight.moonlightapp.validators.contracts;

import com.moonlight.moonlightapp.models.BaseModel;
import com.moonlight.moonlightapp.validators.models.ResultadoValidacao;

public interface ModelValidator<T extends BaseModel> {
    ResultadoValidacao validar(T model);
}
