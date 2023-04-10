package com.pbl.sistema_gerenciamento.dao.recepcionista;

import com.pbl.sistema_gerenciamento.model.Recepcionista;

import java.util.ArrayList;
import java.util.List;

public class RecepcionistaListImpl implements RecepcionistaDAO{
    private ArrayList<Recepcionista> listaRecepcionistas;
    private int nextID;

    public RecepcionistaListImpl() {
        this.listaRecepcionistas = new ArrayList<Recepcionista>();
        this.nextID = 0;
    }

    @Override
    public Recepcionista criar(Recepcionista obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaRecepcionistas.add(obj);
        return obj;
    }

    @Override
    public Recepcionista acharPorId(int id) {
        for(Recepcionista r: listaRecepcionistas){
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Recepcionista> acharTodos() {
        return listaRecepcionistas;
    }

    @Override
    public Recepcionista atualizar(Recepcionista obj) {
        for (Recepcionista r : listaRecepcionistas){
            if (r.getId() == obj.getId()){
                this.listaRecepcionistas.set(listaRecepcionistas.indexOf(r), obj);
                return r;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (Recepcionista r : listaRecepcionistas){
            if (r.getId() == id){
                this.listaRecepcionistas.remove(r);
                return;
            }
        }
    }

    @Override
    public void deletarTodos() {
        this.listaRecepcionistas.clear();
        this.nextID = 0;
    }

    @Override
    public List<Recepcionista> acharPorNome(String nome) {
        ArrayList<Recepcionista> listaNome = new ArrayList<Recepcionista>();
        for (Recepcionista r : listaRecepcionistas){
            if (r.getNome().equals(nome)){
                listaNome.add(r);
            }
        }
        return listaNome;
    }

    @Override
    public List<Recepcionista> acharPorEmail(String email) {
        ArrayList<Recepcionista> listaEmail = new ArrayList<Recepcionista>();
        for (Recepcionista r : listaRecepcionistas){
            if (r.getEmail().equals(email)){
                listaEmail.add(r);
            }
        }
        return listaEmail;
    }
}
