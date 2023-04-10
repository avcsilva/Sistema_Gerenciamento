package com.pbl.sistema_gerenciamento.dao.cliente;

import com.pbl.sistema_gerenciamento.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface ClienteDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Clientes
 */
public class ClienteListImpl implements ClienteDAO{
    private ArrayList<Cliente> listaClientes;
    private int nextID;

    /**
     * Cria um ClienteListImpl com sua lista vazia e id inicial 0
     */
    public ClienteListImpl() {
        this.listaClientes = new ArrayList<Cliente>();
        this.nextID = 0;
    }

    /**
     * Cria um Cliente e insere na lista
     * @param obj o objeto a ser criado
     * @return o Cliente criado
     */
    @Override
    public Cliente criar(Cliente obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaClientes.add(obj);
        return obj;
    }

    /**
     * Encontra um Cliente por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o Cliente encontrado
     */
    @Override
    public Cliente acharPorId(int id) {
        for (Cliente c : listaClientes){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    /**
     * Encontra todos os Clientes registrados
     *
     * @return a lista de Clientes encontrados
     */
    @Override
    public List<Cliente> acharTodos() {
        return this.listaClientes;
    }

    /**
     * Atualiza um Cliente da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o Cliente atualizado
     */
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

    /**
     * Deleta um Cliente por meio de seu id
     *
     * @param id o id do objeto a ser deletado
     */
    @Override
    public void deletar(int id) {
        for (Cliente a: listaClientes){
            if(a.getId() == id){
                this.listaClientes.remove(a);
                return;
            }
        }
    }

    /**
     * Deleta a lista de Clientes e cria uma nova. Redefine o id inicial para 0
     */
    @Override
    public void deletarTodos() {
        this.listaClientes.clear();
        this.nextID = 0;
    }

    /**
     * Encontra Clientes por meio de seus nomes
     *
     * @param nome o nome no qual o Cliente vai ser buscado
     * @return a lista de Clientes encontrados
     */
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
