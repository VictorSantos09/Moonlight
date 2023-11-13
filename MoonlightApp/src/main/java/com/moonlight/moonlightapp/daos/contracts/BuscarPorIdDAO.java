package com.moonlight.moonlightapp.daos.contracts;

import com.moonlight.moonlightapp.models.BaseModel;

/**
 * Interface que define o contrato para buscar um objeto por seu ID.
 * @param <T> tipo do objeto a ser buscado.
 */
/**
 * Interface que define o contrato para buscar um objeto pelo seu ID.
 * @param <T> tipo do objeto a ser buscado.
 */
public interface BuscarPorIdDAO<T extends BaseModel> {
    /**
     * Busca um objeto pelo seu ID.
     * @param id ID do objeto a ser buscado.
     * @return objeto encontrado ou null caso não exista.
     * @throws RuntimeException se ocorrer um erro durante a busca.
     */
    T buscarPorId(int id) throws RuntimeException;
}
