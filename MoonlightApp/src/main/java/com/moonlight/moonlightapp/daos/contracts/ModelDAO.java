package com.moonlight.moonlightapp.daos.contracts;

import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.BaseModel;


/**
 * Esta interface define o contrato para um Objeto de Acesso a Dados (DAO) que manipula operações CRUD para um modelo específico.
 *
 * @param <T> O tipo de modelo que este DAO manipula.
 */

/**
 * Interface que define as operações básicas de um DAO para um modelo genérico.
 *
 * @param <T> O tipo do modelo.
 */
public interface ModelDAO<T extends BaseModel> extends BuscarPorIdDAO<T> {
    /**
     * Cria um novo modelo no banco de dados.
     *
     * @param model O modelo a ser criado.
     * @return Um objeto BaseDTO contendo informações sobre a operação de criação.
     * @throws RuntimeException Se ocorrer um erro ao criar o modelo.
     */
    BaseDTO criar(T model) throws RuntimeException;

    /**
     * Atualiza um modelo existente no banco de dados.
     *
     * @param modelAtualizado O modelo atualizado a ser salvo.
     * @return Um objeto BaseDTO contendo informações sobre a operação de atualização.
     * @throws RuntimeException Se ocorrer um erro ao atualizar o modelo.
     */
    BaseDTO atualizar(T modelAtualizado) throws RuntimeException;

    /**
     * Deleta um modelo existente no banco de dados.
     *
     * @param model O modelo a ser deletado.
     * @return Um objeto BaseDTO contendo informações sobre a operação de deleção.
     * @throws RuntimeException Se ocorrer um erro ao deletar o modelo.
     */
    BaseDTO deletar(T model) throws RuntimeException;
}
