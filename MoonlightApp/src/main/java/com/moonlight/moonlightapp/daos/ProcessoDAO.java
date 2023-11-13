package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ProcessoModel;

import java.util.List;

public class ProcessoDAO extends  ConexaoBanco
implements ModelDAO<ProcessoModel> {

    @Override
    public ProcessoModel buscarPorId(int id) throws RuntimeException {
        return null;
    }

    public ProcessoModel BuscarPorEtapa(String etapa) throws RuntimeException {
        return null;
    }

    @Override
    public BaseDTO criar(ProcessoModel model) {
        return null;
    }

    @Override
    public BaseDTO atualizar(ProcessoModel modelAtualizado) {
        return null;
    }

    @Override
    public BaseDTO deletar(ProcessoModel model) {
        return null;
    }

    public List<ProcessoModel> buscarPorProdutoId(int id){
        return List.of();
    }
}
