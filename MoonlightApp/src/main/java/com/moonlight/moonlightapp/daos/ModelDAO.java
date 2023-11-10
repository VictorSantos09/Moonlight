package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.Identificavel;

public interface ModelDAO<T extends Identificavel> {
    public BaseDTO Criar(T model);

    public BaseDTO Atualizar(T modelAtualizado);

    public BaseDTO Deletar(T model);

    public T BuscarPorId(int id);
}
