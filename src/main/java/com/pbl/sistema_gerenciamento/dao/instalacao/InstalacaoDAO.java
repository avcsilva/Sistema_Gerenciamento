package com.pbl.sistema_gerenciamento.dao.instalacao;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Instalacao;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos Instalação
 */
public interface InstalacaoDAO extends CRUD<Instalacao> {
    /**
     * Encontra objetos por meio de seus sistemas operacionais
     *
     * @param sist o sistema operacional sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Instalacao> acharPorSO(String sist);

    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Instalacao> acharPorPreco(Double preco);

    /**
     * Encontra objetos por meio de seus custos
     *
     * @param custo o custo sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Instalacao> acharPorCusto(Double custo);
}
