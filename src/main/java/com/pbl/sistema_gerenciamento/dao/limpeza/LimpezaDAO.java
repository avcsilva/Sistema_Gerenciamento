package com.pbl.sistema_gerenciamento.dao.limpeza;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Limpeza;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos Limpezas
 */
public interface LimpezaDAO extends CRUD<Limpeza> {
    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Limpeza> acharPorPreco(Double preco);

    /**
     * Encontra objetos por meio de seus custos
     *
     * @param custo o custo sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Limpeza> acharPorCusto(Double custo);
}
