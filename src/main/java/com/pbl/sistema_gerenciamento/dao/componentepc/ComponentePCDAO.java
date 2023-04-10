package com.pbl.sistema_gerenciamento.dao.componentepc;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.ComponentePC;

import java.util.List;

public interface ComponentePCDAO extends CRUD<ComponentePC> {
    public List<ComponentePC> acharPorNome(String nome);
    public List<ComponentePC> acharPorPreco(Double preco);
    public List<ComponentePC> acharPorCusto(Double custo);
}
