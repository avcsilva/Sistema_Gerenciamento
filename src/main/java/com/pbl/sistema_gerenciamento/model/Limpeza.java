package com.pbl.sistema_gerenciamento.model;

/**
 * Subclasse Limpeza que extende a superclasse Serviço.
 * Representa um Serviço relacionado à limpeza de um computador. Definido por seu preço e custo.
 */
public class Limpeza extends Servico{

    /**
     * Cria um Serviço de Limpeza com seu preço e custo definidos.
     *
     * @param preco o preço da Limpeza
     */
    public Limpeza(Double preco) {
        super(preco, 0.0);
    }
}