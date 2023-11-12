package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;

public class MateriaPrimaDAO extends ConexaoBanco
        implements ModelDAO<MateriaPrimaModel>, BuscarPorNomeDAO<MateriaPrimaModel> {

    @Override
    public MateriaPrimaModel buscarPorNome(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorNome'");
    }

    @Override
    public BaseDTO criar(MateriaPrimaModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Criar'");
    }

    @Override
    public BaseDTO atualizar(MateriaPrimaModel modelAtualizado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Atualizar'");
    }

    @Override
    public BaseDTO deletar(MateriaPrimaModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Deletar'");
    }

    @Override
    public MateriaPrimaModel BuscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorId'");
    }

}
