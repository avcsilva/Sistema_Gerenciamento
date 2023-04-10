package com.pbl.sistema_gerenciamento.dao.componenteoutro;

import com.pbl.sistema_gerenciamento.model.ComponenteOutro;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface ComponenteOutroDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de ComponenteOutro
 */
public class ComponenteOutroListImpl implements ComponenteOutroDAO{
    private ArrayList<ComponenteOutro> listaComponenteOutros;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public ComponenteOutroListImpl() {
        this.listaComponenteOutros = new ArrayList<ComponenteOutro>();
        this.nextID = 0;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public ComponenteOutro criar(ComponenteOutro obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaComponenteOutros.add(obj);
        return obj;
    }

    /**
     * Encontra um objeto por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    @Override
    public ComponenteOutro acharPorId(int id) {
        for(ComponenteOutro c: listaComponenteOutros){
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
    public List<ComponenteOutro> acharTodos() {
        return listaComponenteOutros;
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public ComponenteOutro atualizar(ComponenteOutro obj) {
        for (ComponenteOutro c : listaComponenteOutros){
            if (c.getId() == obj.getId()){
                this.listaComponenteOutros.set(listaComponenteOutros.indexOf(c), obj);
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
        for (ComponenteOutro c: listaComponenteOutros){
            if (c.getId() == id ){
                this.listaComponenteOutros.remove(c);
                return;
            }
        }

    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        this.listaComponenteOutros.clear();
        this.nextID = 0;
    }

    /**
     * Encontra ComponenteOutro por meio de suas descrições
     *
     * @param descricao a descrição sobre os quais os Componentes devem ser encontrados
     * @return lista de Componentes encontrados
     */
    @Override
    public List<ComponenteOutro> acharPorDescricao(String descricao) {
        ArrayList<ComponenteOutro> listaDescr = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComponenteOutros){
            if (c.getDescricao().equals(descricao)){
                listaDescr.add(c);
            }
        }
        return listaDescr;
    }

    /**
     * Encontra Componentes por meio de seus preços
     *
     * @param preco o preço sobre os quais os Componentes devem ser encontrados
     * @return lista de Componentes encontrados
     */
    @Override
    public List<ComponenteOutro> acharPorPreco(Double preco) {
        ArrayList<ComponenteOutro> listaPreco = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComponenteOutros){
            if (c.getPreco().equals(preco)){
                listaPreco.add(c);
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
    public List<ComponenteOutro> acharPorCusto(Double custo) {
        ArrayList<ComponenteOutro> listaCusto = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComponenteOutros){
            if (c.getCusto().equals(custo)){
                listaCusto.add(c);
            }
        }
        return listaCusto;
    }
}
