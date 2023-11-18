package com.moonlight.moonlightapp.models;

public class ProdutoProcessoModel extends BaseModel {
    private ProcessoModel processo;
    private ProdutoModel produto;

    public ProdutoProcessoModel( ProcessoModel processo,  ProdutoModel produto) {
        this.processo = processo;
        this.produto = produto;
    }

    public ProcessoModel getProcesso() {
        return processo;
    }

    public void setProcesso(ProcessoModel processo) {
        this.processo = processo;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto( ProdutoModel produto) {
        this.produto = produto;
    }
}
