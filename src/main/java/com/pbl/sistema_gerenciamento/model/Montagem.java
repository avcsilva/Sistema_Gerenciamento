package com.pbl.sistema_gerenciamento.model;

import java.util.ArrayList;

/**
 * Subclasse Montagem que extende a superclasse Serviço.
 * Representa um serviço relacionado à montagem de um computador,
 * possuindo uma lista de componentes a serem utilizados para sua realização.
 */
public class Montagem extends Servico{
    private ArrayList<Componente> componentesUsados;

    /**
     * Cria um serviço de Montagem com uma lista de componentes especificada.
     * O preço e custo total do serviço de Montagem serão definidos a partir
     * dos preços e custos dos componentes presentes na lista.
     *
     * @param comp a lista de componentes para a realização do serviço
     */
    public Montagem(int id, ArrayList<Componente> comp) {
        super(id);
        this.setPreco(0.0);
        this.setCusto(0.0);
        this.componentesUsados = comp;
        for (Componente c : comp){
            this.setPreco(this.getPreco() + c.getPreco());
            this.setCusto(this.getCusto() + c.getCusto());
        }
    }

    /**
     * Adiciona um novo componente à lista para a realização da montagem.
     * O preço e custo do serviço são atualizados de acordo com os preços e custos
     * dos novos componentes adicionados à lista.
     *
     * @param comp o componente a ser adicionado à lista
     */
    public void adicionarComponente(Componente comp){
        this.componentesUsados.add(comp);
        this.setCusto(this.getCusto() + comp.getCusto());
        this.setPreco(this.getPreco() + comp.getPreco());
    }

    /**
     * Remove um Componente da lista com base no id
     *
     * @param id o id do Componente a ser removido
     */
    public void removerComponente(int id){
        for (Componente c : this.componentesUsados){
            if (c.getId() == id){
                this.componentesUsados.remove(c);
            }
        }
    }

    /**
     * Retorna a lista de componentes para a realização da Montagem.
     *
     * @return a lista de componentes para a realização da Montagem.
     */
    public ArrayList<Componente> getComponentesUsados() {
        return componentesUsados;
    }

    /**
     * Define uma nova lista de componentes para a realização da Montagem.
     * O preço e custo do serviço serão definidos a partir dos preços e custos
     * dos componentes presentes na lista.
     *
     * @param componentesUsados a lista de componentes para a realização do serviço
     */
    public void setComponentesUsados(ArrayList<Componente> componentesUsados) {
        this.setCusto(0.0);
        this.setPreco(0.0);
        this.componentesUsados = componentesUsados;

        for (Componente c : componentesUsados){
            this.setCusto(this.getCusto() + c.getCusto());
            this.setPreco(this.getPreco() + c.getPreco());
        }
    }
}