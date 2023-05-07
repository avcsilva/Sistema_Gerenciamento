package com.pbl.sistema_gerenciamento.dao.cliente;

import com.pbl.sistema_gerenciamento.model.Cliente;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface ClienteDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Clientes
 */
public class ClienteFileImpl implements ClienteDAO{
    private ManipulaArquivo manipulaArquivo;
    private int nextID;

    /**
     * Cria um ClienteListImpl com sua lista vazia e id inicial 0
     */
    public ClienteFileImpl() {
        this.manipulaArquivo = new ManipulaArquivo("cliente.dat");
        ArrayList<Cliente> lista = manipulaArquivo.retornar();
        if (lista.size() > 0) {
            this.nextID = lista.get(lista.size() - 1).getId() + 1;
        } else this.nextID = 0;
    }

    /**
     * Cria um Cliente e insere na lista
     * @param obj o objeto a ser criado
     * @return o Cliente criado
     */
    @Override
    public Cliente criar(Cliente obj) {
        ArrayList<Cliente> listaClientes = this.manipulaArquivo.retornar();
        obj.setId(nextID);
        this.nextID++;
        listaClientes.add(obj);
        this.manipulaArquivo.guardar(listaClientes);
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
        ArrayList<Cliente> listaClientes = this.manipulaArquivo.retornar();
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
        return this.manipulaArquivo.retornar();
    }

    /**
     * Atualiza um Cliente da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o Cliente atualizado
     */
    @Override
    public Cliente atualizar(Cliente obj) {
        ArrayList<Cliente> listaClientes = this.manipulaArquivo.retornar();
        for (Cliente c : listaClientes){
            if (c.getId() == obj.getId()){
                listaClientes.set(listaClientes.indexOf(c), obj);
                this.manipulaArquivo.guardar(listaClientes);
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
        ArrayList<Cliente> listaClientes = this.manipulaArquivo.retornar();
        for (Cliente a: listaClientes){
            if(a.getId() == id){
                listaClientes.remove(a);
                this.manipulaArquivo.guardar(listaClientes);
                return;
            }
        }
    }

    /**
     * Deleta a lista de Clientes e cria uma nova. Redefine o id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<Cliente> listaClientes = this.manipulaArquivo.retornar();
        listaClientes.clear();
        this.manipulaArquivo.guardar(listaClientes);
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
        ArrayList<Cliente> listaClientes = this.manipulaArquivo.retornar();
        ArrayList<Cliente> listaNomes = new ArrayList<Cliente>();
        for (Cliente c : listaClientes){
            if (c.getNome().equals(nome)){
                listaNomes.add(c);
            }
        }
        return listaNomes;
    }
}