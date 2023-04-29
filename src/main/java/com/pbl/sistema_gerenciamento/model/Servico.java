package com.pbl.sistema_gerenciamento.model;

/**
 * Superclasse Serviço que representará uma tarefa a ser realizada por um Técnico em sua Ordem de Serviço.
 * Definido por seu preço, custo e id.
 */
public abstract class Servico {
    private int id;
    private Double preco;
    private Double custo;

    public Servico(Double preco, Double custo) {
        this.preco = preco;
        this.custo = custo;
    }

    /**
     * Retorna o id do Serviço
     *
     * @return o id do Serviço
     */
    public int getId() {
        return id;
    }

    /**
     * Define o id do Serviço
     *
     * @param id o id do Serviço
     */
    public void setId(int id) {
        this.id = id;
    }

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