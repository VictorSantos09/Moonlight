package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.converters.contracts.ModelConverter;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;

public class ProdutoConverter implements ModelConverter<ProdutoModel, ProdutoDTO> {

    @Override
    public ProdutoModel converterFrom(ProdutoDTO object) {
        return new ProdutoModel(object.getNome(), object.getDescricao(), object.getUnidadeMedida(),
                object.getTipoProduto(), 0, object.getValor());
    }
}
