package com.pbl.sistema_gerenciamento.model;

/**
 * Classe Componente que representa um componente que poderá ser utilizado
 * para a realização de um Serviço de Montagem.
 */
public class Componente {
    private Double preco;
    private Double custo;

    /**
     * Cria um novo Componente com seu preço e custo definidos
     *
     * @param preco o preço do Componente
     * @param custo o custo do Componente
     */
    public Componente(Double preco, Double custo) {
        this.preco = preco;
        this.custo = custo;
    }

    /**
     * Retorna o preço do Componente
     *
     * @return o preço do Componente
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Define o preço do Componente
     *
     * @param preco o preço do Componente
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * Retorna o custo do Componente
     *
     * @return o custo do Componente
     */
    public Double getCusto() {
        return custo;
    }

    /**
     * Define o custo do Componente
     *
     * @param custo o custo do Componente
     */
    public void setCusto(Double custo) {
        this.custo = custo;
    }
}
