package com.pbl.sistema_gerenciamento.model;

/**
 * Subclasse ComponentePC que extende a superclasse Componente.
 * Representa um Componente usual para a realização de Serviços de Montagem,
 * tal como RAM, HD/SSD, fonte e placa de vídeo. São armazenados em estoque.
 * Definido pelo seu nome, fabricante, preço, custo e id.
 */
public class ComponentePC extends Componente{
    private String nome;
    private String fabricante;

    /**
     * Cria um novo ComponentePC com preço, custo, nome e fabricante definidos.
     *
     * @param id o id do ComponentePC
     * @param preco o preço do ComponentePC
     * @param custo o custo do ComponentePC
     * @param nome o nome do ComponentePC
     * @param fabricante o fabricante do ComponentePC
     */
    public ComponentePC(int id, Double preco, Double custo, String nome, String fabricante) {
        super(id, preco, custo);
        this.nome = nome;
        this.fabricante = fabricante;
    }

    /**
     * Retorna o nome do ComponentePC
     *
     * @return o nome do ComponentePC
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do ComponentePC
     *
     * @param nome o nome do ComponentePC
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o fabricante do ComponentePC
     *
     * @return o fabricante do ComponentePC
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Define o fabricante do ComponentePC
     *
     * @param fabricante o fabricante do ComponentePC
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}