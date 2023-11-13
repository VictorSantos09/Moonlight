package com.moonlight.moonlightapp.daos.contracts;

import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.BaseModel;

/**
 * Interface que define as operações básicas de um DAO para um modelo que implementa a interface Identificavel.
 *
 * @param <T> Tipo do modelo que implementa Identificavel.
 */
public interface ModelDAO<T extends BaseModel> extends BuscarPorIdDAO<T> {
    /**
     * Cria um novo modelo no banco de dados.
     *
     * @param model O modelo a ser criado.
     * @return Um objeto BaseDTO contendo informações sobre a operação de criação.
     */
    BaseDTO criar(T model);

    /**
     * Atualiza um modelo existente no banco de dados.
     *
     * @param modelAtualizado O modelo atualizado a ser salvo.
     * @return Um objeto BaseDTO contendo informações sobre a operação de atualização.
     */
    BaseDTO atualizar(T modelAtualizado);

    /**
     * Deleta um modelo existente no banco de dados.
     *
     * @param model O modelo a ser deletado.
     * @return Um objeto BaseDTO contendo informações sobre a operação de deleção.
     */
    BaseDTO deletar(T model);
}
