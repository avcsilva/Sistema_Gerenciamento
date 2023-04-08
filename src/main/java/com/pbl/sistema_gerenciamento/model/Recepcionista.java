package com.pbl.sistema_gerenciamento.model;

/**
 * Subclasse Recepcionista que extende a superclasse Usuário.
 * Representa um Recepcionista que será responsável por cadastrar Clientes e gerar Ordens de Serviço.
 */
public class Recepcionista extends Usuario{

    /**
     * Cria um Recepcionista com id, nome e e-mail definidos
     *
     * @param id o id do Recepcionista
     * @param nome o nome do Recepcionista
     * @param email o e-mail do Recepcionista
     */
    public Recepcionista(int id, String nome, String email) {
        super(id, nome, email);
    }
}