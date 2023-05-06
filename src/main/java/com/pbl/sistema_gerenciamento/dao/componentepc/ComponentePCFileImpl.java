package com.pbl.sistema_gerenciamento.dao.componentepc;

import com.pbl.sistema_gerenciamento.model.ComponentePC;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface ComponentePCDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de ComponentePC
 */
public class ComponentePCFileImpl implements ComponentePCDAO{
    private ManipulaArquivo manipulaArquivo;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public ComponentePCFileImpl() {
        this.manipulaArquivo = new ManipulaArquivo("componentesPC.dat");
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        this.nextID = listaComponentePC.get(listaComponentePC.size() - 1).getId() + 1;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public ComponentePC criar(ComponentePC obj) {
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        obj.setId(nextID);
        this.nextID ++;
        listaComponentePC.add(obj);
        this.manipulaArquivo.guardar(listaComponentePC);
        return obj;
    }

    /**
     * Encontra um objeto por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    @Override
    public ComponentePC acharPorId(int id) {
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        for (ComponentePC c : listaComponentePC){
            if (c.getId() == id){
                return c;
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
    public List<ComponentePC> acharTodos() {
        return this.manipulaArquivo.retornar();
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public ComponentePC atualizar(ComponentePC obj) {
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        for (ComponentePC c: listaComponentePC){
            if (c.getId() == obj.getId()){
                listaComponentePC.set(listaComponentePC.indexOf(c), obj);
                this.manipulaArquivo.guardar(listaComponentePC);
                return c;
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
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        for (ComponentePC c : listaComponentePC){
            if (c.getId() == id){
                listaComponentePC.remove(c);
                this.manipulaArquivo.guardar(listaComponentePC);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        listaComponentePC.clear();
        this.manipulaArquivo.guardar(listaComponentePC);
        this.nextID = 0;
    }

    /**
     * Encontra objetos por meio de seus nomes
     *
     * @param nome o nome do objeto a ser encontrado
     * @return a lista de objetos encontrados
     */
    @Override
    public List<ComponentePC> acharPorNome(String nome) {
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        ArrayList<ComponentePC> listaNomes = new ArrayList<ComponentePC>();
        for (ComponentePC c : listaComponentePC){
            if (c.getNome().equals(nome)){
                listaNomes.add(c);
            }
        }
        return listaNomes;
    }

    /**
     * Encontra Componentes por meio de seus preços
     *
     * @param preco o preço sobre os quais os Componentes devem ser encontrados
     * @return lista de Componentes encontrados
     */
    @Override
    public List<ComponentePC> acharPorPreco(Double preco) {
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        ArrayList<ComponentePC> listaPreco = new ArrayList<ComponentePC>();
        for (ComponentePC o : listaComponentePC){
            if (o.getPreco().equals(preco)){
                listaPreco.add(o);
            }
        }
        return listaPreco;
    }

    /**
     * Encontra Componentes por meio de seus custos
     *
     * @param custo o custo sobre os quais os Componentes devem ser encontrados
     * @return lista de Componentes encontrados
     */
    @Override
    public List<ComponentePC> acharPorCusto(Double custo) {
        ArrayList<ComponentePC> listaComponentePC = this.manipulaArquivo.retornar();
        ArrayList<ComponentePC> listaCusto = new ArrayList<ComponentePC>();
        for (ComponentePC o : listaComponentePC){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}