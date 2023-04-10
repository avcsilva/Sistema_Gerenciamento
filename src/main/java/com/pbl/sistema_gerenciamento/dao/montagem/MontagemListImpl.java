package com.pbl.sistema_gerenciamento.dao.montagem;

import com.pbl.sistema_gerenciamento.model.Montagem;

import java.util.ArrayList;
import java.util.List;

public class MontagemListImpl implements MontagemDAO{
    private ArrayList<Montagem> listaMontagem;
    private int nextID;

    public MontagemListImpl() {
        this.listaMontagem = new ArrayList<Montagem>();
        this.nextID = 0;
    }

    @Override
    public Montagem criar(Montagem obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaMontagem.add(obj);
        return obj;
    }

    @Override
    public Montagem acharPorId(int id) {
        for(Montagem m: listaMontagem){
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Montagem> acharTodos() {
        return listaMontagem;
    }

    @Override
    public Montagem atualizar(Montagem obj) {
        for (Montagem m : listaMontagem){
            if (m.getId() == obj.getId()){
                this.listaMontagem.set(listaMontagem.indexOf(m), obj);
                return m;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (Montagem m : listaMontagem){
            if (m.getId() == id){
                this.listaMontagem.remove(m);
                return;
            }
        }
    }

    @Override
    public void deletarTodos() {
        this.listaMontagem.clear();
        this.nextID = 0;
    }

    @Override
    public List<Montagem> acharPorPreco(Double preco) {
        ArrayList<Montagem> listaPreco = new ArrayList<Montagem>();
        for (Montagem o : listaMontagem){
            if (o.getPreco().equals(preco)){
                listaPreco.add(o);
            }
        }
        return listaPreco;
    }

    @Override
    public List<Montagem> acharPorCusto(Double custo) {
        ArrayList<Montagem> listaCusto = new ArrayList<Montagem>();
        for (Montagem o : listaMontagem){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}
