package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorIdDAO;
import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;

public class UnidadeMedidaDAO extends ConexaoBanco
        implements BuscarPorNomeDAO<UnidadeMedidaModel>, BuscarPorIdDAO<UnidadeMedidaModel> {

    @Override
    public UnidadeMedidaModel buscarPorNome(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorNome'");
    }

    public UnidadeMedidaModel BuscarPorSigla(String sigla) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorSigla'");
    }

    @Override
    public UnidadeMedidaModel BuscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorId'");
    }

}
