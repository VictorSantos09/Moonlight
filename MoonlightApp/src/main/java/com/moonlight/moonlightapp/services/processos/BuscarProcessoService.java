package com.moonlight.moonlightapp.services.processos;

import java.util.List;

import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.models.ProcessoModel;

public class BuscarProcessoService {
    private final ProcessoDAO processoDAO;

    public BuscarProcessoService() {
        processoDAO = new ProcessoDAO();
    }

    public List<ProcessoModel> buscarTodos() {
        return processoDAO.buscarTodos();
    }

    public ProcessoModel buscarPorNome(String etapa) {
        return processoDAO.buscarPorEtapa(etapa);
    }
    
}
