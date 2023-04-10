package com.pbl.sistema_gerenciamento.dao.componenteoutro;

import com.pbl.sistema_gerenciamento.model.ComponenteOutro;

import java.util.ArrayList;
import java.util.List;

public class ComponenteOutroListImpl implements ComponenteOutroDAO{
    private ArrayList<ComponenteOutro> listaComponenteOutros;
    private int nextID;

    public ComponenteOutroListImpl() {
        this.listaComponenteOutros = new ArrayList<ComponenteOutro>();
        this.nextID = 0;
    }

    @Override
    public ComponenteOutro criar(ComponenteOutro obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaComponenteOutros.add(obj);
        return obj;
    }

    @Override
    public ComponenteOutro acharPorId(int id) {
        for(ComponenteOutro c: listaComponenteOutros){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<ComponenteOutro> acharTodos() {
        return listaComponenteOutros;
    }

    @Override
    public ComponenteOutro atualizar(ComponenteOutro obj) {
        for (ComponenteOutro c : listaComponenteOutros){
            if (c.getId() == obj.getId()){
                this.listaComponenteOutros.set(listaComponenteOutros.indexOf(c), obj);
                return c;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (ComponenteOutro c: listaComponenteOutros){
            if (c.getId() == id ){
                this.listaComponenteOutros.remove(c);
                return;
            }
        }

    }

    @Override
    public void deletarTodos() {
        this.listaComponenteOutros.clear();
        this.nextID = 0;
    }

    @Override
    public List<ComponenteOutro> acharPorDescricao(String descricao) {
        ArrayList<ComponenteOutro> listaDescr = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComponenteOutros){
            if (c.getDescricao().equals(descricao)){
                listaDescr.add(c);
            }
        }
        return listaDescr;
    }

    @Override
    public List<ComponenteOutro> acharPorPreco(Double preco) {
        ArrayList<ComponenteOutro> listaPreco = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComponenteOutros){
            if (c.getPreco().equals(preco)){
                listaPreco.add(c);
            }
        }
        return listaPreco;
    }

    @Override
    public List<ComponenteOutro> acharPorCusto(Double custo) {
        ArrayList<ComponenteOutro> listaCusto = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComponenteOutros){
            if (c.getCusto().equals(custo)){
                listaCusto.add(c);
            }
        }
        return listaCusto;
    }
}
