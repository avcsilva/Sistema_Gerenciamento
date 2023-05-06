package com.pbl.sistema_gerenciamento.dao.limpeza;

import com.pbl.sistema_gerenciamento.model.Limpeza;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface LimpezaDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Limpezas
 */
public class LimpezaFileImpl implements LimpezaDAO{
    private ManipulaArquivo manipulaArquivos;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public LimpezaFileImpl() {
        this.manipulaArquivos = new ManipulaArquivo("limpeza.dat");
        ArrayList<Limpeza> lista = manipulaArquivos.retornar();
        this.nextID = lista.get(lista.size() - 1).getId() + 1;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Limpeza criar(Limpeza obj) {
        ArrayList<Limpeza> lista = this.manipulaArquivos.retornar();

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
    public Limpeza acharPorId(int id) {
        ArrayList<Limpeza> listaLimpeza = this.manipulaArquivos.retornar();
        for (Limpeza i : listaLimpeza){
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
    public List<Limpeza> acharTodos() {
        return manipulaArquivos.retornar();
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public Limpeza atualizar(Limpeza obj) {
        ArrayList<Limpeza> listaLimpeza = this.manipulaArquivos.retornar();
        for (Limpeza i : listaLimpeza){
            if (i.getId() == obj.getId()){
                listaLimpeza.set(listaLimpeza.indexOf(i), obj);
                this.manipulaArquivos.guardar(listaLimpeza);
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
        ArrayList<Limpeza> listaLimpeza = this.manipulaArquivos.retornar();
        for (Limpeza i : listaLimpeza){
            if (i.getId() == id){
                listaLimpeza.remove(i);
                this.manipulaArquivos.guardar(listaLimpeza);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<Limpeza> listaLimpeza = this.manipulaArquivos.retornar();
        listaLimpeza.clear();
        this.nextID = 0;
        this.manipulaArquivos.guardar(listaLimpeza);
    }

    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Limpeza> acharPorPreco(Double preco) {
        ArrayList<Limpeza> listaLimpeza = this.manipulaArquivos.retornar();
        ArrayList<Limpeza> listaPreco = new ArrayList<Limpeza>();
        for (Limpeza o : listaLimpeza){
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
        ArrayList<Limpeza> listaLimpeza = this.manipulaArquivos.retornar();
        ArrayList<Limpeza> listaCusto = new ArrayList<Limpeza>();
        for (Limpeza o : listaLimpeza){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}