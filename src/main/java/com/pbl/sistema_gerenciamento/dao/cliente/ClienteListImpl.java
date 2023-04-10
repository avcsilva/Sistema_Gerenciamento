package com.pbl.sistema_gerenciamento.dao.cliente;

import com.pbl.sistema_gerenciamento.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListImpl implements ClienteDAO{
    private ArrayList<Cliente> listaClientes;
    private int nextID;

    public ClienteListImpl() {
        this.listaClientes = new ArrayList<Cliente>();
        this.nextID = 0;
    }

    @Override
    public Cliente criar(Cliente obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaClientes.add(obj);
        return obj;
    }

    @Override
    public Cliente acharPorId(int id) {
        for (Cliente c : listaClientes){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> acharTodos() {
        return this.listaClientes;
    }

    @Override
    public Cliente atualizar(Cliente obj) {
        for (Cliente c : listaClientes){
            if (c.getId() == obj.getId()){
                this.listaClientes.set(listaClientes.indexOf(c), obj);
                return c;
            }
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        for (Cliente a: listaClientes){
            if(a.getId() == id){
                this.listaClientes.remove(a);
                return;
            }
        }
    }

    @Override
    public void deletarTodos() {
        this.listaClientes.clear();
        this.nextID = 0;
    }

    @Override
    public List<Cliente> acharPorNome(String nome) {
        ArrayList<Cliente> listaNomes = new ArrayList<Cliente>();
        for (Cliente c : listaClientes){
            if (c.getNome().equals(nome)){
                listaNomes.add(c);
            }
        }
        return listaNomes;
    }
}
