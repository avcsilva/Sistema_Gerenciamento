package com.pbl.sistema_gerenciamento.dao.montagem;

import com.pbl.sistema_gerenciamento.model.Montagem;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface MontagemDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Montagens
 */
public class MontagemFileImpl implements MontagemDAO{
    private ManipulaArquivo manipulaArquivo;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public MontagemFileImpl() {
        this.manipulaArquivo = new ManipulaArquivo("montagem.dat");
        ArrayList<Montagem> listaMontagem = this.manipulaArquivo.retornar();
        if (listaMontagem.size() > 0) {
            this.nextID = listaMontagem.get(listaMontagem.size() - 1).getId() + 1;
        } else this.nextID = 0;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Montagem criar(Montagem obj) {
        ArrayList<Montagem> listaMontagem = this.manipulaArquivo.retornar();
        obj.setId(nextID);
        this.nextID++;
        listaMontagem.add(obj);
        this.manipulaArquivo.guardar(listaMontagem);
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
        ArrayList<Montagem> listaMontagem = this.manipulaArquivo.retornar();
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
        return this.manipulaArquivo.retornar();
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public Montagem atualizar(Montagem obj) {
        ArrayList<Montagem> listaMontagem = this.manipulaArquivo.retornar();
        for (Montagem m : listaMontagem){
            if (m.getId() == obj.getId()){
                listaMontagem.set(listaMontagem.indexOf(m), obj);
                this.manipulaArquivo.guardar(listaMontagem);
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
        ArrayList<Montagem> listaMontagem = this.manipulaArquivo.retornar();
        for (Montagem m : listaMontagem){
            if (m.getId() == id){
                listaMontagem.remove(m);
                this.manipulaArquivo.guardar(listaMontagem);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<Montagem> listaMontagem = this.manipulaArquivo.retornar();
        listaMontagem.clear();
        this.manipulaArquivo.guardar(listaMontagem);
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
        ArrayList<Montagem> listaMontagem = this.manipulaArquivo.retornar();
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
        ArrayList<Montagem> listaMontagem = this.manipulaArquivo.retornar();
        ArrayList<Montagem> listaCusto = new ArrayList<Montagem>();
        for (Montagem o : listaMontagem){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}
