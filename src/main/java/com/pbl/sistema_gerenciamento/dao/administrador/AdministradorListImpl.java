package com.pbl.sistema_gerenciamento.dao.administrador;

import com.pbl.sistema_gerenciamento.model.Administrador;

import java.util.ArrayList;
import java.util.List;

public class AdministradorListImpl implements AdministradorDAO {
    private ArrayList<Administrador> listaAdmins;
    private int nextID;

    /**
     *
     */
    public AdministradorListImpl() {
        this.listaAdmins = new ArrayList<Administrador>();
        this.nextID = 0;
    }

    /**
     * Insere um Administrador na lista e define o seu id
     *
     * @param obj o Administrador a ser inserido
     * @return o Administrador inserido
     */
    @Override
    public Administrador criar(Administrador obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaAdmins.add(obj);
        return obj;
    }

    /**
     *
     * @param id o id do objeto a ser encontrado
     * @return
     */
    @Override
    public Administrador acharPorId(int id) {
        for (Administrador a : listaAdmins){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Administrador> acharTodos() {
        return listaAdmins;
    }

    /**
     *
     * @param obj o objeto a ser atualizado
     * @return
     */
    @Override
    public Administrador atualizar(Administrador obj) {
        for (Administrador a : listaAdmins){
            if (a.getId() == obj.getId()){
                this.listaAdmins.set(listaAdmins.indexOf(a), obj);
                return a;
            }
        }
        return null;
    }

    /**
     *
     * @param id o id do objeto a ser deletado
     */
    @Override
    public void deletar(int id) {
        for (Administrador a : listaAdmins){
            if (a.getId() == id){
                this.listaAdmins.remove(a);
                return;
            }
        }
    }

    /**
     *
     */
    @Override
    public void deletarTodos() {
        this.listaAdmins.clear();
        this.nextID = 0;
    }

    /**
     *
     * @param nome o nome sobre os quais os Administradores devem ser encontrados
     * @return
     */
    @Override
    public List<Administrador> acharPorNome(String nome) {
        ArrayList<Administrador> listaNomes = new ArrayList<Administrador>();
        for (Administrador a : listaAdmins) {
            if (a.getNome().equals(nome)) {
                listaNomes.add(a);
            }
        }
        return listaNomes;
    }

    @Override
    public List<Administrador> acharPorEmail(String email) {
        ArrayList<Administrador> listaEmail = new ArrayList<Administrador>();
        for (Administrador a : listaAdmins) {
            if (a.getEmail().equals(email)) {
                listaEmail.add(a);
            }
        }
        return listaEmail;
    }
}
