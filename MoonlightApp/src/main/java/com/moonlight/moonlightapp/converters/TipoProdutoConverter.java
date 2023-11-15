package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.converters.contracts.ModelConverter;
import com.moonlight.moonlightapp.dtos.produtos.TipoProdutoDTO;
import com.moonlight.moonlightapp.models.TipoProdutoModel;

public class TipoProdutoConverter implements ModelConverter<TipoProdutoModel, TipoProdutoDTO> {
    @Override
    public TipoProdutoModel converterFrom(TipoProdutoDTO object) {
        return new TipoProdutoModel(object.getNome());
    }
}
