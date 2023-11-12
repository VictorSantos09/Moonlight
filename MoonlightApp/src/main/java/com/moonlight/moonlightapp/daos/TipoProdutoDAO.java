package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorIdDAO;
import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.models.TipoProdutoModel;

public class TipoProdutoDAO extends ConexaoBanco
        implements BuscarPorNomeDAO<TipoProdutoModel>, BuscarPorIdDAO<TipoProdutoModel> {

    @Override
    public TipoProdutoModel buscarPorNome(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorNome'");
    }

    @Override
    public TipoProdutoModel BuscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorId'");
    }

}
