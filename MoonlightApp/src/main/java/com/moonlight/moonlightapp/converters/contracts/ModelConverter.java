package com.moonlight.moonlightapp.converters.contracts;

import com.moonlight.moonlightapp.models.BaseModel;

public interface ModelConverter<T extends BaseModel, D> {
    T converterFrom(D object);
}
