package com.pbl.sistema_gerenciamento.dao.componenteoutro;

import com.pbl.sistema_gerenciamento.model.Administrador;
import com.pbl.sistema_gerenciamento.model.ComponenteOutro;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface ComponenteOutroDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de ComponenteOutro
 */
public class ComponenteOutroFileImpl implements ComponenteOutroDAO{
    private ManipulaArquivo manipulaArquivos;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public ComponenteOutroFileImpl() {
        this.manipulaArquivos = new ManipulaArquivo("componenteOutro.dat");
        ArrayList<ComponenteOutro> lista = manipulaArquivos.retornar();
        this.nextID = lista.get(lista.size() - 1).getId() + 1;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public ComponenteOutro criar(ComponenteOutro obj) {
        ArrayList<ComponenteOutro> lista = this.manipulaArquivos.retornar();

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
    public ComponenteOutro acharPorId(int id) {
        ArrayList<ComponenteOutro> listaComp = this.manipulaArquivos.retornar();
        for (ComponenteOutro o : listaComp){
            if (o.getId() == id){
                return o;
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
        return manipulaArquivos.retornar();
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public ComponenteOutro atualizar(ComponenteOutro obj) {
        ArrayList<ComponenteOutro> listaComp = this.manipulaArquivos.retornar();
        for (ComponenteOutro c : listaComp){
            if (c.getId() == obj.getId()){
                listaComp.set(listaComp.indexOf(c), obj);
                this.manipulaArquivos.guardar(listaComp);
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
        ArrayList<ComponenteOutro> listaComp = this.manipulaArquivos.retornar();
        for (ComponenteOutro c : listaComp){
            if (c.getId() == id){
                listaComp.remove(c);
                this.manipulaArquivos.guardar(listaComp);
                return;
            }
        }

    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<ComponenteOutro> listaComp = this.manipulaArquivos.retornar();
        listaComp.clear();
        this.nextID = 0;
        this.manipulaArquivos.guardar(listaComp);
    }

    /**
     * Encontra ComponenteOutro por meio de suas descrições
     *
     * @param descricao a descrição sobre os quais os Componentes devem ser encontrados
     * @return lista de Componentes encontrados
     */
    @Override
    public List<ComponenteOutro> acharPorDescricao(String descricao) {
        ArrayList<ComponenteOutro> listaComp = this.manipulaArquivos.retornar();
        ArrayList<ComponenteOutro> listaDescr = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComp){
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
        ArrayList<ComponenteOutro> listaComp = this.manipulaArquivos.retornar();
        ArrayList<ComponenteOutro> listaPreco = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComp){
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
        ArrayList<ComponenteOutro> listaComp = this.manipulaArquivos.retornar();
        ArrayList<ComponenteOutro> listaCusto = new ArrayList<ComponenteOutro>();
        for (ComponenteOutro c : listaComp){
            if (c.getCusto().equals(custo)){
                listaCusto.add(c);
            }
        }
        return listaCusto;
    }
}

