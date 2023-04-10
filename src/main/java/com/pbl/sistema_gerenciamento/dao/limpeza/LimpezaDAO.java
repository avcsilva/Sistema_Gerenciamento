package com.pbl.sistema_gerenciamento.dao.limpeza;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Limpeza;

import java.util.List;

public interface LimpezaDAO extends CRUD<Limpeza> {
    public List<Limpeza> acharPorPreco(Double preco);
    public List<Limpeza> acharPorCusto(Double custo);
}
