package com.pbl.sistema_gerenciamento.dao.componenteoutro;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.ComponenteOutro;

import java.util.List;

public interface ComponenteOutroDAO extends CRUD<ComponenteOutro> {
    /**
     * Encontra Componentes por meio de suas descrições
     *
     * @param descricao decriçao do componente que esta fora da lista de componentes esperados pelo sistema
     * @return uma lista de componentes com base na descriçãoo deles, que nesse caso serve como meio de indeficação
     */
    public List<ComponenteOutro> acharPorDescricao(String descricao);
    public List<ComponenteOutro> acharPorPreco(Double preco);
    public List<ComponenteOutro> acharPorCusto(Double custo);
}
