package com.pbl.sistema_gerenciamento.dao.montagem;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Montagem;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos Montagens
 */
public interface MontagemDAO extends CRUD<Montagem> {
    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Montagem> acharPorPreco(Double preco);

    /**
     * Encontra objetos por meio de seus custos
     *
     * @param custo o custo sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Montagem> acharPorCusto(Double custo);
}
