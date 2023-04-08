package com.pbl.sistema_gerenciamento.model;

/**
 * Subclasse ComponenteOutro que extende a superclasse Componente.
 * Representa componentes extras ou que não são usuais aos Serviços de Montagem. Não são armazenados em estoque.
 * São definidos por seu preço, custo e descrição.
 */
public class ComponenteOutro extends Componente{
    private String descricao;

    /**
     * Cria um novo ComponenteOutro com seu preço, custo e descrição definidos.
     *
     * @param preco o preço do ComponenteOutro
     * @param custo o custo do ComponenteOutro
     * @param descricao a descrição do ComponenteOutro
     */
    public ComponenteOutro(Double preco, Double custo, String descricao) {
        super(preco, custo);
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição do ComponenteOutro.
     *
     * @return a descrição do ComponenteOutro
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do ComponenteOutro
     *
     * @param descricao a descrição do ComponenteOutro
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
