package com.moonlight.moonlightapp.converters;

import com.moonlight.moonlightapp.converters.contracts.ModelConverter;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;

public class ProdutoConverter implements ModelConverter<ProdutoModel, ProdutoDTO> {
    private final TipoProdutoConverter tipoProdutoConverter;
    private final UnidadeMedidaDAO unidadeMedidaDAO;

    public ProdutoConverter() {
        tipoProdutoConverter = new TipoProdutoConverter();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
    }

    @Override
    public ProdutoModel converterFrom(ProdutoDTO object) {
        var unidadeMedida = unidadeMedidaDAO.buscarPorNome(object.getUnidadeMedida().getNome());
        var tipo = tipoProdutoConverter.converterFrom(object.getTipoProduto());

        return new ProdutoModel(object.getNome(), object.getDescricao(), unidadeMedida,
                tipo, 0, object.getValor());
    }
}
