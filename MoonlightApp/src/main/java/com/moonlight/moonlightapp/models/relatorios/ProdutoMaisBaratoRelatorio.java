package com.moonlight.moonlightapp.models.relatorios;

public class ProdutoMaisBaratoRelatorio extends  BaseProdutoRelatorio{
    public ProdutoMaisBaratoRelatorio(String nome, String tipo, Double valorVenda, Double valorRecomendado, Double subtotal) {
        super(nome, tipo, valorVenda, valorRecomendado, subtotal);
    }

    public static ProdutoMaisBaratoRelatorio buildFromBase(BaseProdutoRelatorio base) {
        return new ProdutoMaisBaratoRelatorio(base.getNome(), base.getTipo(), base.getValorVenda(),
                base.getValorRecomendado(), base.getSubtotal());
    }
}
