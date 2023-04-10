package com.pbl.sistema_gerenciamento.dao.instalacao;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Instalacao;

import java.util.List;

public interface InstalacaoDAO extends CRUD<Instalacao> {
    public List<Instalacao> acharPorSO(String sist);
    public List<Instalacao> acharPorPreco(Double preco);
    public List<Instalacao> acharPorCusto(Double custo);
}
