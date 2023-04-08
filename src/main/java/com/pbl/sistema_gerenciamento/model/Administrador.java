package com.pbl.sistema_gerenciamento.model;

/**
 * Subclasse Administrador que extende a superclasse Usuário.
 * Representa um Administrador do sistema, o qual pode gerenciar estoques e Ordens de Serviço,
 * assim como cadastrar novas Ordens e Clientes.
 */
public class Administrador extends Usuario{

    /**
     * Cria um Administrador com id, nome e e-mail definidos
     *
     * @param id o id do Administrador
     * @param nome o nome do Administrador
     * @param email o e-mail do Administrador
     */
    public Administrador(int id, String email, String nome) {
        super(id, email, nome);
    }
}
