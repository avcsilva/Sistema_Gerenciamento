package com.pbl.sistema_gerenciamento.dao.montagem;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Montagem;

import java.util.List;

public interface MontagemDAO extends CRUD<Montagem> {
    public List<Montagem> acharPorPreco(Double preco);
    public List<Montagem> acharPorCusto(Double custo);
}
