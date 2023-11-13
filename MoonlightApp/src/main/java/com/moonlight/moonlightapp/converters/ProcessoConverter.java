package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.models.ProcessoModel;

/**
 * Classe responsável por converter um objeto ProcessoDTO em um objeto
 * ProcessoModel.
 * Utiliza um objeto ProcessoDAO para buscar o ProcessoModel correspondente à
 * etapa do ProcessoDTO.
 */
public class ProcessoConverter {
    private final ProcessoDAO processoDAO;

    public ProcessoConverter() {
        processoDAO = new ProcessoDAO();
    }

    public ProcessoModel converterParaModel(ProcessoDTO dto) {
        return processoDAO.buscarPorEtapa(dto.getEtapa());
    }
}
