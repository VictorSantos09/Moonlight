package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.converters.contracts.ModelConverter;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;

public class ProdutoConverter implements ModelConverter<ProdutoModel, ProdutoDTO> {
    private final UnidadeMedidaConverter unidadeMedidaConverter;
    private final TipoProdutoConverter tipoProdutoConverter;

    public ProdutoConverter() {
        unidadeMedidaConverter = new UnidadeMedidaConverter();
        tipoProdutoConverter = new TipoProdutoConverter();
    }

    @Override
    public ProdutoModel converterFrom(ProdutoDTO object) {
        var unidadeMedida = unidadeMedidaConverter.converterFrom(object.getUnidadeMedida());
        var tipo = tipoProdutoConverter.converterFrom(object.getTipoProduto());

        return new ProdutoModel(object.getNome(), object.getDescricao(), unidadeMedida,
                tipo, 0, object.getValor());
    }
}
