package com.pbl.sistema_gerenciamento.model;

import java.util.ArrayList;

/**
 * Subclasse Intalação que extende a superclasse Serviço.
 * Representa um Serviço relacionado à Instalação de programas ou sistemas operacionais,
 * possuindo uma lista de programas a serem instalados e o sistema operacional em questão.
 */
public class Instalacao extends Servico{
    private String Programa;
    private String sistemaOperacional;

    /**
     * Cria um novo Serviço de Instalação com preço, custo, lista de programas e sistema operacional definidos
     *
     * @param preco o preço da Instalação
     */
    public Instalacao(Double preco) {
        super(preco, 0.0);
    }

    /**
     * Define uma nova lista de programas a serem instalados na Instalação
     *
     * @param programa a lista de programas a serem instalados
     */
    public void setPrograma(String programa) {
        this.Programa = programa;
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
    public String getPrograma() {
        return Programa;
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
