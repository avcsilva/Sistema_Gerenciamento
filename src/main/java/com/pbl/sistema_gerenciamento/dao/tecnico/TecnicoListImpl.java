package com.pbl.sistema_gerenciamento.dao.tecnico;

import com.pbl.sistema_gerenciamento.model.Tecnico;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface TecnicoDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Técnicos
 */
public class TecnicoListImpl implements TecnicoDAO{
    private ArrayList<Tecnico> listaTecnicos;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public TecnicoListImpl() {
        this.listaTecnicos = new ArrayList<Tecnico>();
        this.nextID = 0;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Tecnico criar(Tecnico obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaTecnicos.add(obj);
        return obj;
    }

    /**
     * Encontra um objeto por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    @Override
    public Tecnico acharPorId(int id) {
        for(Tecnico t: listaTecnicos){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    /**
     * Encontra todos os objetos registrados
     *
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Tecnico> acharTodos() {
        return listaTecnicos;
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
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

    /**
     * Deleta um objeto da lista por meio de seu id
     *
     * @param id o id do objeto a ser deletado
     */
    @Override
    public void deletar(int id) {
        for (Tecnico t : listaTecnicos){
            if (t.getId() == id){
                this.listaTecnicos.remove(t);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        this.listaTecnicos.clear();
        this.nextID = 0;
    }

    /**
     * Encontra objetos por meio de seus nomes
     *
     * @param nome o nome sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
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

    /**
     * Encontra objetos por meio de seus e-mails
     *
     * @param email o e-mail sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
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
