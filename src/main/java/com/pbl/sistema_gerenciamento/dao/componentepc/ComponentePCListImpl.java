package com.pbl.sistema_gerenciamento.dao.componentepc;

import com.pbl.sistema_gerenciamento.model.ComponentePC;

import java.util.ArrayList;
import java.util.List;

public class ComponentePCListImpl implements ComponentePCDAO{
    private ArrayList<ComponentePC> listaComponentePC;
    private int nextID;

    public ComponentePCListImpl() {
        this.listaComponentePC = new ArrayList<ComponentePC>();
        this.nextID = 0;
    }

    @Override
    public ComponentePC criar(ComponentePC obj) {
        obj.setId(nextID);
        this.nextID ++;
        this.listaComponentePC.add(obj);
        return obj;
    }

    @Override
    public ComponentePC acharPorId(int id) {
        for (ComponentePC c : listaComponentePC){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<ComponentePC> acharTodos() {
        return listaComponentePC;
    }

    @Override
    public ComponentePC atualizar(ComponentePC obj) {
        for (ComponentePC c: listaComponentePC){
            if (c.getId() == obj.getId()){
                this.listaComponentePC.set(listaComponentePC.indexOf(c), obj);
                return c;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (ComponentePC c : listaComponentePC){
            if (c.getId() == id){
                this.listaComponentePC.remove(c);
                return;
            }
        }
    }

    @Override
    public void deletarTodos() {
        this.listaComponentePC.clear();
        this.nextID = 0;
    }

    @Override
    public List<ComponentePC> acharPorNome(String nome) {
        ArrayList<ComponentePC> listaNomes = new ArrayList<ComponentePC>();
        for (ComponentePC c : listaComponentePC){
            if (c.getNome().equals(nome)){
                listaNomes.add(c);
            }
        }
        return listaNomes;
    }

    @Override
    public List<ComponentePC> acharPorPreco(Double preco) {
        ArrayList<ComponentePC> listaPreco = new ArrayList<ComponentePC>();
        for (ComponentePC o : listaComponentePC){
            if (o.getPreco().equals(preco)){
                listaPreco.add(o);
            }
        }
        return listaPreco;
    }

    @Override
    public List<ComponentePC> acharPorCusto(Double custo) {
        ArrayList<ComponentePC> listaCusto = new ArrayList<ComponentePC>();
        for (ComponentePC o : listaComponentePC){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}
