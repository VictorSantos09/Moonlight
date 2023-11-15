package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.converters.contracts.ModelConverter;
import com.moonlight.moonlightapp.dtos.unidadesmedidas.UnidadeMedidaDTO;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;

public class UnidadeMedidaConverter implements ModelConverter<UnidadeMedidaModel, UnidadeMedidaDTO> {
    @Override
    public UnidadeMedidaModel converterFrom(UnidadeMedidaDTO object) {
        return new UnidadeMedidaModel(object.getNome(), object.getSigla());
    }
}
