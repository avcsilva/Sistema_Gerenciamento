package com.pbl.sistema_gerenciamento.dao.tecnico;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Tecnico;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos Técnicos
 */
public interface TecnicoDAO extends CRUD<Tecnico> {
    /**
     * Encontra objetos por meio de seus nomes
     *
     * @param nome o nome sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Tecnico> acharPorNome(String nome);

    /**
     * Encontra objetos por meio de seus e-mails
     *
     * @param email o e-mail sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<Tecnico> acharPorEmail(String email);
}
