package com.pbl.sistema_gerenciamento.dao.componenteoutro;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.ComponenteOutro;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos ComponenteOutro
 */
public interface ComponenteOutroDAO extends CRUD<ComponenteOutro> {
    /**
     * Encontra Componentes por meio de suas descrições
     *
     * @param descricao a descrição sobre os quais os Componentes devem ser encontrados
     * @return uma lista de componentes com base na descrição deles, que nesse caso serve como meio de identificação
     */
    public List<ComponenteOutro> acharPorDescricao(String descricao);

    /**
     * Encontra Componentes por meio de seus preços
     *
     * @param preco o preço sobre os quais os Componentes devem ser encontrados
     * @return a lista de Componentes encontrados
     */
    public List<ComponenteOutro> acharPorPreco(Double preco);

    /**
     * Encontra Componentes por meio de seus custos
     *
     * @param custo o custo sobre os quais os Componentes devem ser encontrados
     * @return a lista de Componentes encontrados
     */
    public List<ComponenteOutro> acharPorCusto(Double custo);
}
