package com.pbl.sistema_gerenciamento.dao.administrador;

import com.pbl.sistema_gerenciamento.model.Administrador;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface AdministradorDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Administradores
 */
public class AdministradorListImpl implements AdministradorDAO {
    private ArrayList<Administrador> listaAdmins;
    private int nextID;

    /**
     * Cria um AdministradorListImpl com sua lista vazia e id inicial 0
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
     * Encontra um Administrador por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o Administrador encontrado
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
     * Encontra todos os Administradores registrados
     *
     * @return a lista de Administradores encontrados
     */
    @Override
    public List<Administrador> acharTodos() {
        return listaAdmins;
    }

    /**
     * Atualiza um Administrador
     *
     * @param obj o objeto a ser atualizado
     * @return o Administrador que foi atualizado
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
     * Deleta um Administrador da lista por meio de seu id
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
     * Deleta a lista de Administradores e cria uma nova. Redefine o id inicial para 0
     */
    @Override
    public void deletarTodos() {
        this.listaAdmins.clear();
        this.nextID = 0;
    }

    /**
     * Encontra Administradores por meio de seus nomes
     *
     * @param nome o nome sobre os quais os Administradores devem ser encontrados
     * @return a lista de Administradores encontrados
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

    /**
     * Encontra Administradores por meio de seus e-mails
     *
     * @param email o e-mail sobre os quais os Administradores devem ser encontrados
     * @return a lista de Administradores encontrados
     */
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
