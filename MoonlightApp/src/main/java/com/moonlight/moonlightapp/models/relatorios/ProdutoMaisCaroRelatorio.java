package com.moonlight.moonlightapp.models.relatorios;

public class ProdutoMaisCaroRelatorio extends BaseProdutoRelatorio {
    public ProdutoMaisCaroRelatorio(String nome, String tipo, Double valorVenda, Double valorRecomendado, Double subtotal) {
        super(nome, tipo, valorVenda, valorRecomendado, subtotal);
    }

    public static ProdutoMaisCaroRelatorio buildFromBase(BaseProdutoRelatorio base) {
        return new ProdutoMaisCaroRelatorio(base.getNome(), base.getTipo(), base.getValorVenda(),
                base.getValorRecomendado(), base.getSubtotal());
    }
}
