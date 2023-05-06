package com.pbl.sistema_gerenciamento.dao.recepcionista;

import com.pbl.sistema_gerenciamento.model.Recepcionista;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface RecepcionistaDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Recepcionistas
 */
public class RecepcionistaFileImpl implements RecepcionistaDAO{
    private ManipulaArquivo manipulaArquivo;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public RecepcionistaFileImpl() {
        this.manipulaArquivo = new ManipulaArquivo("recepcionista.dat");
        ArrayList<Recepcionista> listaRecepcionistas = this.manipulaArquivo.retornar();
        this.nextID = listaRecepcionistas.get(listaRecepcionistas.size() - 1).getId() + 1;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Recepcionista criar(Recepcionista obj) {
        ArrayList<Recepcionista> listaRecepcionistas = this.manipulaArquivo.retornar();
        obj.setId(nextID);
        this.nextID++;
        listaRecepcionistas.add(obj);
        this.manipulaArquivo.guardar(listaRecepcionistas);
        return obj;
    }

    /**
     * Encontra um objeto por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    @Override
    public Recepcionista acharPorId(int id) {
        ArrayList<Recepcionista> listaRecepcionistas = this.manipulaArquivo.retornar();
        for(Recepcionista r: listaRecepcionistas){
            if (r.getId() == id){
                return r;
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
    public List<Recepcionista> acharTodos() {
        return this.manipulaArquivo.retornar();
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public Recepcionista atualizar(Recepcionista obj) {
        ArrayList<Recepcionista> listaRecepcionistas = this.manipulaArquivo.retornar();
        for (Recepcionista r : listaRecepcionistas){
            if (r.getId() == obj.getId()){
                listaRecepcionistas.set(listaRecepcionistas.indexOf(r), obj);
                this.manipulaArquivo.guardar(listaRecepcionistas);
                return r;
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
        ArrayList<Recepcionista> listaRecepcionistas = this.manipulaArquivo.retornar();
        for (Recepcionista r : listaRecepcionistas){
            if (r.getId() == id){
                listaRecepcionistas.remove(r);
                this.manipulaArquivo.guardar(listaRecepcionistas);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<Recepcionista> listaRecepcionistas = this.manipulaArquivo.retornar();
        listaRecepcionistas.clear();
        this.manipulaArquivo.guardar(listaRecepcionistas);
        this.nextID = 0;
    }

    /**
     * Encontra objetos por meio de seus nomes
     *
     * @param nome o nome sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Recepcionista> acharPorNome(String nome) {
        ArrayList<Recepcionista> listaRecepcionistas = this.manipulaArquivo.retornar();
        ArrayList<Recepcionista> listaNome = new ArrayList<Recepcionista>();
        for (Recepcionista r : listaRecepcionistas){
            if (r.getNome().equals(nome)){
                listaNome.add(r);
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
    public List<Recepcionista> acharPorEmail(String email) {
        ArrayList<Recepcionista> listaRecepcionistas = this.manipulaArquivo.retornar();
        ArrayList<Recepcionista> listaEmail = new ArrayList<Recepcionista>();
        for (Recepcionista r : listaRecepcionistas){
            if (r.getEmail().equals(email)){
                listaEmail.add(r);
            }
        }
        return listaEmail;
    }
}