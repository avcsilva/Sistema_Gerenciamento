package com.pbl.sistema_gerenciamento.dao.montagem;

import com.pbl.sistema_gerenciamento.model.Montagem;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface MontagemDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Montagens
 */
public class MontagemListImpl implements MontagemDAO{
    private ArrayList<Montagem> listaMontagem;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public MontagemListImpl() {
        this.listaMontagem = new ArrayList<Montagem>();
        this.nextID = 0;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Montagem criar(Montagem obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaMontagem.add(obj);
        return obj;
    }

    /**
     * Encontra um objeto por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    @Override
    public Montagem acharPorId(int id) {
        for(Montagem m: listaMontagem){
            if (m.getId() == id){
                return m;
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
    public List<Montagem> acharTodos() {
        return listaMontagem;
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public Montagem atualizar(Montagem obj) {
        for (Montagem m : listaMontagem){
            if (m.getId() == obj.getId()){
                this.listaMontagem.set(listaMontagem.indexOf(m), obj);
                return m;
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
        for (Montagem m : listaMontagem){
            if (m.getId() == id){
                this.listaMontagem.remove(m);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        this.listaMontagem.clear();
        this.nextID = 0;
    }

    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Montagem> acharPorPreco(Double preco) {
        ArrayList<Montagem> listaPreco = new ArrayList<Montagem>();
        for (Montagem o : listaMontagem){
            if (o.getPreco().equals(preco)){
                listaPreco.add(o);
            }
        }
        return listaPreco;
    }

    /**
     * Encontra objetos por meio de seus custos
     *
     * @param custo o custo sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Montagem> acharPorCusto(Double custo) {
        ArrayList<Montagem> listaCusto = new ArrayList<Montagem>();
        for (Montagem o : listaMontagem){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}
