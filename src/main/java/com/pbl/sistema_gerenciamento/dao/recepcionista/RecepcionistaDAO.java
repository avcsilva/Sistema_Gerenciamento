package com.pbl.sistema_gerenciamento.dao.recepcionista;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.Recepcionista;

import java.util.List;

public interface RecepcionistaDAO extends CRUD<Recepcionista> {
    public List<Recepcionista> acharPorNome(String nome);
    public List<Recepcionista> acharPorEmail(String email);
}
