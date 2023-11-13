package com.moonlight.moonlightapp.daos.contracts;

/**
 * Interface que define o contrato para buscar um objeto do tipo T por nome no
 * banco de dados, onde o campo 'nome' é único.
 *
 * @param <T> o tipo do objeto a ser buscado
 */
/**
 * Interface responsável por buscar um objeto do tipo T pelo nome único no banco de dados.
 * @param <T> o tipo do objeto a ser buscado
 */
public interface BuscarPorNomeDAO<T> {
    /**
     * Busca um objeto do tipo T pelo nome único no banco de dados.
     *
     * @param nome o nome a ser buscado
     * @return o objeto do tipo T encontrado, ou null se não encontrado
     * @throws RuntimeException se ocorrer um erro durante a busca
     */
    T buscarPorNome(String nome) throws RuntimeException;
}
