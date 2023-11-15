package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.converters.contracts.ModelConverter;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.models.ProcessoModel;

public class ProcessoConverter implements ModelConverter<ProcessoModel, ProcessoDTO> {
    @Override
    public ProcessoModel converterFrom(ProcessoDTO object) {
        return new ProcessoModel(object.getEtapa(), object.getCusto());
    }
}
