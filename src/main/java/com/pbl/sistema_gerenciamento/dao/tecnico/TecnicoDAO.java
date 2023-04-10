package com.pbl.sistema_gerenciamento.dao.tecnico;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Tecnico;

import java.util.List;

public interface TecnicoDAO extends CRUD<Tecnico> {
    public List<Tecnico> acharPorNome(String nome);
    public List<Tecnico> acharPorEmail(String email);
}
