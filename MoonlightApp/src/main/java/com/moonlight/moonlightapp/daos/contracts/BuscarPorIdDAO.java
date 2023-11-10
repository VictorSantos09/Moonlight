package com.moonlight.moonlightapp.daos.contracts;

import com.moonlight.moonlightapp.models.Identificavel;

/**
 * Interface que define o contrato para buscar um objeto por seu ID.
 * @param <T> tipo do objeto a ser buscado.
 */
public interface BuscarPorIdDAO<T extends Identificavel> {
    /**
     * Busca um objeto pelo seu ID.
     * @param id ID do objeto a ser buscado.
     * @return objeto encontrado ou null caso não exista.
     */
    public T BuscarPorId(int id);
}
