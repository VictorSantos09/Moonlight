package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorIdDAO;
import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.models.TipoMateriaPrimaModel;

public class TipoMateriaPrimaDAO extends ConexaoBanco
        implements BuscarPorNomeDAO<TipoMateriaPrimaModel>, BuscarPorIdDAO<TipoMateriaPrimaModel> {

    @Override
    public TipoMateriaPrimaModel buscarPorNome(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorNome'");
    }

    @Override
    public TipoMateriaPrimaModel BuscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorId'");
    }

}
