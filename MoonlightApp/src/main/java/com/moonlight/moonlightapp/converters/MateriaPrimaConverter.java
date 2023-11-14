package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.converters.contracts.ModelConverter;
import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.TipoMateriaPrimaModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;

public class MateriaPrimaConverter implements ModelConverter<MateriaPrimaModel, MateriaPrimaDTO> {

    @Override
    public MateriaPrimaModel converterFrom(MateriaPrimaDTO object) {
        var unidadeMedida = new UnidadeMedidaModel(null, null);
        var tipoMateriaPrima = new TipoMateriaPrimaModel(object.getTipo());

        return new MateriaPrimaModel(object.getNome(),object.getDescricao(),
        object.getValor(),object.getQuantidade(),unidadeMedida,tipoMateriaPrima);
    }
}
