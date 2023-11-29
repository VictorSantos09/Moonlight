package com.moonlight.moonlightapp.models.relatorios;

public class ProdutoFabricacaoMaisCaroRelatorio extends  BaseProdutoRelatorio{
    public ProdutoFabricacaoMaisCaroRelatorio(String nome, String tipo, Double valorVenda, Double valorRecomendado, Double subtotal) {
        super(nome, tipo, valorVenda, valorRecomendado, subtotal);
    }

    public static ProdutoFabricacaoMaisCaroRelatorio buildFromBase(BaseProdutoRelatorio base) {
        return new ProdutoFabricacaoMaisCaroRelatorio(base.getNome(), base.getTipo(), base.getValorVenda(),
                base.getValorRecomendado(), base.getSubtotal());
    }
}
