package com.pbl.sistema_gerenciamento.model;

/**
 * Subclasse Administrador que extende a superclasse Usuário.
 * Representa um Administrador do sistema, o qual pode gerenciar estoques e Ordens de Serviço,
 * assim como cadastrar novas Ordens e Clientes.
 */
public class Administrador extends Usuario{

    /**
     * Cria um Administrador com nome e e-mail definidos.
     *
     * @param nome  o nome do Usuário
     * @param email o e-mail do Usuário
     */
    public Administrador(String nome, String email) {
        super(nome, email);
    }
}
