package com.moonlight.moonlightapp.models;

public class ProdutoProcessoModel extends BaseModel {
    private ProcessoModel processo;
    private ProdutoModel produto;

    public ProdutoProcessoModel(final ProcessoModel processo, final ProdutoModel produto) {
        this.processo = processo;
        this.produto = produto;
    }

    public ProcessoModel getProcesso() {
        return this.processo;
    }

    public void setProcesso(final ProcessoModel processo) {
        this.processo = processo;
    }

    public ProdutoModel getProduto() {
        return this.produto;
    }

    public void setProduto(final ProdutoModel produto) {
        this.produto = produto;
    }
}
