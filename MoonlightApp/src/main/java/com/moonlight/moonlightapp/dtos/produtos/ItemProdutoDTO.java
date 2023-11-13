package com.moonlight.moonlightapp.dtos.produtos;

import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;

public class ItemProdutoDTO {
    private int quantidade;
    private MateriaPrimaDTO materiaPrima;

    public ItemProdutoDTO(int quantidade, MateriaPrimaDTO materiaPrima) {
        this.quantidade = quantidade;
        this.materiaPrima = materiaPrima;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public MateriaPrimaDTO getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrimaDTO materiaPrima) {
        this.materiaPrima = materiaPrima;
    }
}
