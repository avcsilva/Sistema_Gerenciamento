package com.pbl.sistema_gerenciamento.dao.administrador;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Administrador;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos Administrador
 */
public interface AdministradorDAO extends CRUD<Administrador> {
    /**
     * Encontra objetos Administrador por meio do nome
     *
     * @param nome o nome sobre os quais os Administradores devem ser encontrados
     * @return lista de Administradores encontrados
     */
    public List<Administrador> acharPorNome(String nome);

    /**
     * Encontra objetos Administrador por meio do e-mail
     *
     * @param email o e-mail sobre os quais os Administradores devem ser encontrados
     * @return lista de Administradores encontrados
     */
    public List<Administrador> acharPorEmail(String email);
}
