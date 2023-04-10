package com.pbl.sistema_gerenciamento.dao.cliente;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Cliente;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos Cliente
 */
public interface ClienteDAO extends CRUD<Cliente> {
    /**
     * Busca os Clientes com base nos nomes
     *
     * @param nome o nome no qual o Cliente vai ser buscado
     * @return a lista de Clientes encontrados
     */
    public List<Cliente> acharPorNome(String nome);
}
