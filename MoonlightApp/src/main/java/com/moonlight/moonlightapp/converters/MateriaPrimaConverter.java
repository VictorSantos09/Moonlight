package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.daos.TipoMateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.TipoMateriaPrimaModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;

/**
 * Classe responsável por converter objetos do tipo MateriaPrimaDTO em objetos
 * do tipo MateriaPrimaModel.
 * Utiliza os DAOs de UnidadeMedida e TipoMateriaPrima para buscar as entidades
 * correspondentes a partir dos dados do DTO.
 */
public class MateriaPrimaConverter {
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoMateriaPrimaDAO tipoMateriaPrimaDAO;

    public MateriaPrimaConverter() {
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoMateriaPrimaDAO = new TipoMateriaPrimaDAO();
    }

    
    public MateriaPrimaModel converterParaModel(MateriaPrimaDTO dto) {
        var unidadeMedida = buscarUnidadeMedidaPorSigla(dto.getSiglaUnidadeMedida());
        var tipoMateriaPrima = buscarTipoMateriaPrimaPorNome(dto.getTipo());

        return new MateriaPrimaModel(dto.getNome(), dto.getDescricao(),
                dto.getValor(), dto.getQuantidade(), unidadeMedida, tipoMateriaPrima);
    }

    private UnidadeMedidaModel buscarUnidadeMedidaPorSigla(String sigla) {
        return unidadeMedidaDAO.buscarPorSigla(sigla);
    }

    private TipoMateriaPrimaModel buscarTipoMateriaPrimaPorNome(String nome) {
        return tipoMateriaPrimaDAO.buscarPorNome(nome);
    }
}
