package com.pbl.sistema_gerenciamento.dao.ordemservico;

import com.pbl.sistema_gerenciamento.model.OrdemServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemServicoListImpl implements OrdemServicoDAO{
    private ArrayList<OrdemServico> listaOrdem;
    private int nextID;

    public OrdemServicoListImpl() {
        this.listaOrdem = new ArrayList<OrdemServico>();
        this.nextID = 0;
    }

    @Override
    public OrdemServico criar(OrdemServico obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaOrdem.add(obj);
        return obj;
    }

    @Override
    public OrdemServico acharPorId(int id) {
        for(OrdemServico o: listaOrdem){
            if (o.getId() == id){
                return o;
            }
        }
        return null;
    }

    @Override
    public List<OrdemServico> acharTodos() {
        return listaOrdem;
    }

    @Override
    public OrdemServico atualizar(OrdemServico obj) {
        for (OrdemServico o : listaOrdem){
            if (o.getId() == obj.getId()){
                this.listaOrdem.set(listaOrdem.indexOf(o), obj);
                return o;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (OrdemServico o : listaOrdem){
            if (o.getId() == id){
                this.listaOrdem.remove(o);
                return;
            }
        }
    }

    @Override
    public void deletarTodos() {
        this.listaOrdem.clear();
        this.nextID = 0;
    }

    @Override
    public List<OrdemServico> acharPorTecnico(int tecnicoID) {
        ArrayList<OrdemServico> listaTecnico = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getTecnico().getId() == tecnicoID){
                listaTecnico.add(o);
            }
        }
        return listaTecnico;
    }

    @Override
    public List<OrdemServico> acharPorStatus(String status) {
        ArrayList<OrdemServico> listaStatus = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getStatus().equals(status)){
                listaStatus.add(o);
            }
        }
        return listaStatus;
    }

    @Override
    public List<OrdemServico> acharPorCliente(int clienteID) {
        ArrayList<OrdemServico> listaCliente = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getCliente().getId() == clienteID){
                listaCliente.add(o);
            }
        }
        return listaCliente;
    }

    @Override
    public List<OrdemServico> acharPorDataC(String comeco) {
        ArrayList<OrdemServico> listaCriacao = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getCriacao().equals(comeco)){
                listaCriacao.add(o);
            }
        }
        return listaCriacao;
    }

    @Override
    public List<OrdemServico> acharPorDataF(String fim) {
        ArrayList<OrdemServico> listaFim = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getFinalizacao().equals(fim)){
                listaFim.add(o);
            }
        }
        return listaFim;
    }

    @Override
    public List<OrdemServico> acharPorPreco(Double preco) {
        ArrayList<OrdemServico> listaPreco = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getPreco().equals(preco)){
                listaPreco.add(o);
            }
        }
        return listaPreco;
    }

    @Override
    public List<OrdemServico> acharPorCusto(Double custo) {
        ArrayList<OrdemServico> listaCusto = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }

    @Override
    public List<OrdemServico> acharPorMetPag(String mp) {
        ArrayList<OrdemServico> listaMetPag = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getMetodoPagamento().equals(mp)){
                listaMetPag.add(o);
            }
        }
        return listaMetPag;
    }
}
