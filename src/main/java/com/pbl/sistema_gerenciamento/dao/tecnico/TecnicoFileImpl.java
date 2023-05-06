package com.pbl.sistema_gerenciamento.dao.tecnico;

import com.pbl.sistema_gerenciamento.model.Limpeza;
import com.pbl.sistema_gerenciamento.model.Tecnico;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface TecnicoDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Técnicos
 */
public class TecnicoFileImpl implements TecnicoDAO{
    private ManipulaArquivo manipulaArquivos;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public TecnicoFileImpl() {
        this.manipulaArquivos = new ManipulaArquivo("tecnico.dat");
        ArrayList<Tecnico> lista = manipulaArquivos.retornar();
        this.nextID = lista.get(lista.size() - 1).getId() + 1;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Tecnico criar(Tecnico obj) {
        ArrayList<Tecnico> lista = manipulaArquivos.retornar();

        obj.setId(nextID);
        this.nextID++;
        lista.add(obj);

        this.manipulaArquivos.guardar(lista);
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
        ArrayList<Tecnico> listaTecnico = this.manipulaArquivos.retornar();
        for (Tecnico i : listaTecnico){
            if (i.getId() == id){
                return i;
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
        return manipulaArquivos.retornar();
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public Tecnico atualizar(Tecnico obj) {
        ArrayList<Tecnico> listaTecnico = this.manipulaArquivos.retornar();
        for (Tecnico i : listaTecnico){
            if (i.getId() == obj.getId()){
                listaTecnico.set(listaTecnico.indexOf(i), obj);
                this.manipulaArquivos.guardar(listaTecnico);
                return i;
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
        ArrayList<Tecnico> listaTecnico = this.manipulaArquivos.retornar();
        for (Tecnico i : listaTecnico){
            if (i.getId() == id){
                listaTecnico.remove(i);
                this.manipulaArquivos.guardar(listaTecnico);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<Tecnico> listaTecnico = this.manipulaArquivos.retornar();
        listaTecnico.clear();
        this.nextID = 0;
        this.manipulaArquivos.guardar(listaTecnico);
    }

    /**
     * Encontra objetos por meio de seus nomes
     *
     * @param nome o nome sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Tecnico> acharPorNome(String nome) {
        ArrayList<Tecnico> listaTecnico = this.manipulaArquivos.retornar();
        ArrayList<Tecnico> listaNome = new ArrayList<Tecnico>();
        for (Tecnico t : listaTecnico){
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
        ArrayList<Tecnico> listaTecnico = this.manipulaArquivos.retornar();
        ArrayList<Tecnico> listaEmail = new ArrayList<Tecnico>();
        for (Tecnico t : listaTecnico){
            if (t.getEmail().equals(email)){
                listaEmail.add(t);
            }
        }
        return listaEmail;
    }
}
