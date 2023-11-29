package com.moonlight.moonlightapp.models.relatorios;

public class ProdutoFabricacaoMaisBaratoRelatorio extends  BaseProdutoRelatorio{
    public ProdutoFabricacaoMaisBaratoRelatorio(String nome, String tipo, Double valorVenda, Double valorRecomendado, Double subtotal) {
        super(nome, tipo, valorVenda, valorRecomendado, subtotal);
    }

    public static ProdutoFabricacaoMaisBaratoRelatorio buildFromBase(BaseProdutoRelatorio base) {
        return new ProdutoFabricacaoMaisBaratoRelatorio(base.getNome(), base.getTipo(), base.getValorVenda(),
                base.getValorRecomendado(), base.getSubtotal());
    }
}
