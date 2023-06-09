package com.pbl.sistema_gerenciamento.model;


/**
 * Subclasse Técnico que extende a superclasse Usuário.
 * Representa o Técnico que será responsável por realizar os trabalhos das Ordens de Serviço.
 */
public class Tecnico extends Usuario {

    private OrdemServico ordemAssociada;
    /**
     * Cria um Técnico com id, nome e e-mail definidos
     *
     * @param nome o nome do Técnico
     * @param email o e-mail do Técnico
     */
    public Tecnico(String nome, String email, String senha) {
        super(nome, email, senha);
        this.ordemAssociada = null;
    }

    public OrdemServico getOrdemAssociada() {
        return ordemAssociada;
    }

    public void setOrdemAssociada(OrdemServico ordemAssociada) {
        this.ordemAssociada = ordemAssociada;
    }
}