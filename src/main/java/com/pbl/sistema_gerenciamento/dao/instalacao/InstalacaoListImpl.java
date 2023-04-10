package com.pbl.sistema_gerenciamento.dao.instalacao;

import com.pbl.sistema_gerenciamento.model.Instalacao;

import java.util.ArrayList;
import java.util.List;

public class InstalacaoListImpl implements InstalacaoDAO{
    private ArrayList<Instalacao> listaInstalacao;
    private int nextID;

    public InstalacaoListImpl() {
        this.listaInstalacao = new ArrayList<Instalacao>();
        this.nextID = 0;
    }

    @Override
    public Instalacao criar(Instalacao obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaInstalacao.add(obj);
        return obj;
    }

    @Override
    public Instalacao acharPorId(int id) {
        for(Instalacao i: listaInstalacao){
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Instalacao> acharTodos() {
        return listaInstalacao;
    }

    @Override
    public Instalacao atualizar(Instalacao obj) {
        for (Instalacao i : listaInstalacao){
            if (i.getId() == obj.getId()){
                this.listaInstalacao.set(listaInstalacao.indexOf(i), obj);
                return i;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (Instalacao i: listaInstalacao){
            if(i.getId() == id){
                this.listaInstalacao.remove(i);
                return;
            }
        }
    }

    @Override
    public void deletarTodos() {
        this.listaInstalacao.clear();
        this.nextID = 0;
    }

    @Override
    public List<Instalacao> acharPorSO(String sist) {
        ArrayList<Instalacao> listaSO = new ArrayList<Instalacao>();
        for (Instalacao i : listaInstalacao){
            if (i.getSistemaOperacional().equals(sist)){
                listaSO.add(i);
            }
        }
        return listaSO;
    }

    @Override
    public List<Instalacao> acharPorPreco(Double preco) {
        ArrayList<Instalacao> listaPreco = new ArrayList<Instalacao>();
        for (Instalacao o : listaInstalacao){
            if (o.getPreco().equals(preco)){
                listaPreco.add(o);
            }
        }
        return listaPreco;

    }

    @Override
    public List<Instalacao> acharPorCusto(Double custo) {
        ArrayList<Instalacao> listaCusto = new ArrayList<Instalacao>();
        for (Instalacao o : listaInstalacao){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}
