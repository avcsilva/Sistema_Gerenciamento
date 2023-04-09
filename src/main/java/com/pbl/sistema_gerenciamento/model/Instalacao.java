package com.pbl.sistema_gerenciamento.model;

import java.util.ArrayList;

/**
 * Subclasse Intalação que extende a superclasse Serviço.
 * Representa um Serviço relacionado à Instalação de programas ou sistemas operacionais,
 * possuindo uma lista de programas a serem instalados e o sistema operacional em questão.
 */
public class Instalacao extends Servico{
    private ArrayList<String> listaProgramas;
    private String sistemaOperacional;

    /**
     * Cria um novo Serviço de Instalação com preço, custo, lista de programas e sistema operacional definidos
     *
     * @param preco o preço da Instalação
     * @param custo o custo da Instalação
     * @param programas a lista de programas a serem instalados
     * @param sistema o sistema operacional a ser utilizado
     */
    public Instalacao(Double preco, Double custo, ArrayList<String> programas, String sistema) {
        this.setPreco(preco);
        this.setCusto(custo);
        this.listaProgramas = programas;
        this.sistemaOperacional = sistema;
    }

    /**
     * Define uma nova lista de programas a serem instalados na Instalação
     *
     * @param programas a lista de programas a serem instalados
     */
    public void setProgramas(ArrayList<String> programas) {
        this.listaProgramas = programas;
    }

    /**
     * Adiciona um novo programa à lista a ser utilizada na Instalação
     *
     * @param p o programa a ser adicionado à lista
     */
    public void adicionarPrograma(String p){
        this.listaProgramas.add(p);
    }

    /**
     * Define o sistema operacional da Instalação
     *
     * @param sistemaOperacional o sistema operacional da Instalação
     */
    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    /**
     * Retorna a lista de programas a serem utilizados na Instalação
     * @return a lista de programas a serem utilizados
     */
    public ArrayList<String> getListaProgramas() {
        return listaProgramas;
    }

    /**
     * Retorna o sistema operacional da Instalação
     *
     * @return o sistema operacional da Instalação
     */
    public String getSistemaOperacional() {
        return sistemaOperacional;
    }
}
