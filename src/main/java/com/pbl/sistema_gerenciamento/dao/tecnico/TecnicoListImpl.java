package com.pbl.sistema_gerenciamento.dao.tecnico;

import com.pbl.sistema_gerenciamento.model.Tecnico;

import java.util.ArrayList;
import java.util.List;

public class TecnicoListImpl implements TecnicoDAO{
    private ArrayList<Tecnico> listaTecnicos;
    private int nextID;

    public TecnicoListImpl() {
        this.listaTecnicos = new ArrayList<Tecnico>();
        this.nextID = 0;
    }

    @Override
    public Tecnico criar(Tecnico obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaTecnicos.add(obj);
        return obj;
    }

    @Override
    public Tecnico acharPorId(int id) {
        for(Tecnico t: listaTecnicos){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Tecnico> acharTodos() {
        return listaTecnicos;
    }

    @Override
    public Tecnico atualizar(Tecnico obj) {
        for (Tecnico t : listaTecnicos){
            if (t.getId() == obj.getId()){
                this.listaTecnicos.set(listaTecnicos.indexOf(t), obj);
                return t;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (Tecnico t : listaTecnicos){
            if (t.getId() == id){
                this.listaTecnicos.remove(t);
                return;
            }
        }
    }

    @Override
    public void deletarTodos() {
        this.listaTecnicos.clear();
        this.nextID = 0;
    }

    @Override
    public List<Tecnico> acharPorNome(String nome) {
        ArrayList<Tecnico> listaNome = new ArrayList<Tecnico>();
        for (Tecnico t : listaTecnicos){
            if (t.getNome().equals(nome)){
                listaNome.add(t);
            }
        }
        return listaNome;
    }

    @Override
    public List<Tecnico> acharPorEmail(String email) {
        ArrayList<Tecnico> listaEmail = new ArrayList<Tecnico>();
        for (Tecnico t : listaTecnicos){
            if (t.getEmail().equals(email)){
                listaEmail.add(t);
            }
        }
        return listaEmail;
    }
}
