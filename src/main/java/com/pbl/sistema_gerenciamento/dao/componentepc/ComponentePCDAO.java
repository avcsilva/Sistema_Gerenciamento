package com.pbl.sistema_gerenciamento.dao.componentepc;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.ComponentePC;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos ComponentePC
 */
public interface ComponentePCDAO extends CRUD<ComponentePC> {
    /**
     * Encontra objetos por meio de seus nomes
     *
     * @param nome o nome do objeto a ser encontrado
     * @return a lista de objetos encontrados
     */
    public List<ComponentePC> acharPorNome(String nome);

    /**
     * Encontra Componentes por meio de seus preços
     *
     * @param preco o preço sobre os quais os Componentes devem ser encontrados
     * @return lista de Componentes encontrados
     */
    public List<ComponentePC> acharPorPreco(Double preco);

    /**
     * Encontra Componentes por meio de seus custos
     *
     * @param custo o custo sobre os quais os Componentes devem ser encontrados
     * @return lista de Componentes encontrados
     */
    public List<ComponentePC> acharPorCusto(Double custo);
}
