package com.pbl.sistema_gerenciamento.dao.limpeza;

import com.pbl.sistema_gerenciamento.model.Limpeza;

import java.util.ArrayList;
import java.util.List;

public class LimpezaListImpl implements LimpezaDAO{
    private ArrayList<Limpeza> listaLimpezas;
    private int nextID;

    public LimpezaListImpl() {
        this.listaLimpezas = new ArrayList<Limpeza>();
        this.nextID = 0;
    }

    @Override
    public Limpeza criar(Limpeza obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaLimpezas.add(obj);
        return obj;
    }

    @Override
    public Limpeza acharPorId(int id) {
        for(Limpeza l: listaLimpezas){
            if (l.getId() == id){
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Limpeza> acharTodos() {
        return listaLimpezas;
    }

    @Override
    public Limpeza atualizar(Limpeza obj) {
        for (Limpeza l : listaLimpezas){
            if (l.getId() == obj.getId()){
                this.listaLimpezas.set(listaLimpezas.indexOf(l), obj);
                return l;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (Limpeza l : listaLimpezas){
            if (l.getId() == id){
                this.listaLimpezas.remove(l);
                return;
            }
        }
    }

    @Override
    public void deletarTodos() {
        this.listaLimpezas.clear();
        this.nextID = 0;
    }

    @Override
    public List<Limpeza> acharPorPreco(Double preco) {
        ArrayList<Limpeza> listaPreco = new ArrayList<Limpeza>();
        for (Limpeza o : listaLimpezas){
            if (o.getPreco().equals(preco)){
                listaPreco.add(o);
            }
        }
        return listaPreco;
    }

    @Override
    public List<Limpeza> acharPorCusto(Double custo) {
        ArrayList<Limpeza> listaCusto = new ArrayList<Limpeza>();
        for (Limpeza o : listaLimpezas){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}
