package com.pbl.sistema_gerenciamento.dao.limpeza;

import com.pbl.sistema_gerenciamento.model.Limpeza;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface LimpezaDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Limpezas
 */
public class LimpezaListImpl implements LimpezaDAO{
    private ArrayList<Limpeza> listaLimpezas;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public LimpezaListImpl() {
        this.listaLimpezas = new ArrayList<Limpeza>();
        this.nextID = 0;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Limpeza criar(Limpeza obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaLimpezas.add(obj);
        return obj;
    }

    /**
     * Encontra um objeto por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    @Override
    public Limpeza acharPorId(int id) {
        for(Limpeza l: listaLimpezas){
            if (l.getId() == id){
                return l;
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
    public List<Limpeza> acharTodos() {
        return listaLimpezas;
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public Limpeza atualizar(Limpeza obj) {
        for (Limpeza l : listaLimpezas){
            if (l.getId() == obj.getId()){
                this.listaLimpezas.set(listaLimpezas.indexOf(l), obj);
                return l;
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
        for (Limpeza l : listaLimpezas){
            if (l.getId() == id){
                this.listaLimpezas.remove(l);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        this.listaLimpezas.clear();
        this.nextID = 0;
    }

    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Limpeza> acharPorPreco(Double preco) {
        ArrayList<Limpeza> listaPreco = new ArrayList<Limpeza>();
        for (Limpeza o : listaLimpezas){
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
    public List<Limpeza> acharPorCusto(Double custo) {
        ArrayList<Limpeza> listaCusto = new ArrayList<Limpeza>();
        for (Limpeza o : listaLimpezas){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}
