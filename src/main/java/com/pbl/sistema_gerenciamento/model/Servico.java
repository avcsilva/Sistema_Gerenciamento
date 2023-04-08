package com.pbl.sistema_gerenciamento.model;

/**
 * Superclasse Serviço que representará uma tarefa a ser realizada por um Técnico em sua Ordem de Serviço.
 * Definido por seu preço e custo.
 */
public class Servico {
    private Double preco;
    private Double custo;

    /**
     * Retorna o preço do Serviço
     *
     * @return o preço do Serviço
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Define o valor do atributo preço para o Serviço
     *
     * @param preco o preço do serviço
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * Retorna o custo para a realização do Serviço
     *
     * @return o custo para a realização do Serviço
     */
    public Double getCusto() {
        return custo;
    }

    /**
     * Define o custo para a realização do Serviço
     *
     * @param custo o custo para a realização do Serviço
     */
    public void setCusto(Double custo) {
        this.custo = custo;
    }
}