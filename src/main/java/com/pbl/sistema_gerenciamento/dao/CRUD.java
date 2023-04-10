package com.pbl.sistema_gerenciamento.dao;

import java.util.List;

/**
 * Interface que representa as ações básicas do CRUD (criar, achar, atualizar e deletar)
 *
 * @param <T> o tipo de objeto no qual se quer manipular
 */
public interface CRUD<T> {
    /**
     * Cria um objeto do tipo T
     *
     * @param obj o objeto a ser criado
     * @return o objeto que foi criado
     */
    public T criar(T obj);

    /**
     * Encontra e retorna um objeto tipo T por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    public T acharPorId(int id);

    /**
     * Retorna uma lista de todos os objetos tipo T encontrados
     *
     * @return lista de todos os objetos encontrados
     */
    public List<T> acharTodos();

    /**
     * Atualiza um objeto do tipo T
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto que foi atualizado
     */
    public T atualizar(T obj);

    /**
     * Deleta um objeto por meio de seu id
     *
     * @param id o id do objeto a ser deletado
     */
    public void deletar(int id);

    /**
     * Deleta todos os objetos
     */
    public void deletarTodos();
}
