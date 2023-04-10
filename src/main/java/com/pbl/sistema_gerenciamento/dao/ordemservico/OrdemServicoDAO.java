package com.pbl.sistema_gerenciamento.dao.ordemservico;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.OrdemServico;

import java.util.List;

public interface OrdemServicoDAO extends CRUD<OrdemServico> {
    public List<OrdemServico> acharPorTecnico(int tecnicoID);
    public List<OrdemServico> acharPorStatus(String status);
    public List<OrdemServico> acharPorCliente(int clienteID);
    public List<OrdemServico> acharPorDataC(String comeco);
    public List<OrdemServico> acharPorDataF(String fim);
    public List<OrdemServico> acharPorPreco(Double preco);
    public List<OrdemServico> acharPorCusto(Double custo);
    public List<OrdemServico> acharPorMetPag(String mp);
}
