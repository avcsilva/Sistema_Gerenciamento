package com.pbl.sistema_gerenciamento.model;

import java.io.Serializable;

/**
 * Subclasse Recepcionista que extende a superclasse Usuário.
 * Representa um Recepcionista que será responsável por cadastrar Clientes e gerar Ordens de Serviço.
 */
public class Recepcionista extends Usuario {

    /**
     * Cria um Recepcionista com id, nome e e-mail definidos
     *
     * @param nome o nome do Recepcionista
     * @param email o e-mail do Recepcionista
     */
    public Recepcionista(String nome, String email) {
        super(nome, email);
    }
}