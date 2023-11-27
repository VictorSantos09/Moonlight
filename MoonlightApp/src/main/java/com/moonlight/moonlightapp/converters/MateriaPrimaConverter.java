package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.converters.contracts.ModelConverter;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.TipoMateriaPrimaModel;

public class MateriaPrimaConverter implements ModelConverter<MateriaPrimaModel, MateriaPrimaDTO> {
    private final UnidadeMedidaDAO unidadeMedidaDAO;

    public MateriaPrimaConverter() {
        unidadeMedidaDAO = new UnidadeMedidaDAO();
    }

    @Override
    public MateriaPrimaModel converterFrom(MateriaPrimaDTO object) {
        var unidadeMedida = unidadeMedidaDAO.buscarPorSigla(object.getSiglaUnidadeMedida());
        var tipoMateriaPrima = new TipoMateriaPrimaModel(object.getTipo());

        return new MateriaPrimaModel(object.getNome(), object.getDescricao(),
                object.getValor(), object.getQuantidade(), unidadeMedida, tipoMateriaPrima);
    }
}
