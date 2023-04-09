package com.pbl.sistema_gerenciamento.model;

/**
 * Classe Cliente, que representa um cliente a requisitar uma Ordem de Serviço.
 * Definido por um id, nome, telefone, e-mail e endereço físico.
 */
public class Cliente {

    private int id;

    private String nome;

    private String endereco;

    private String telefone;

    private String email;

    /**
     * Cria um Cliente com nome, telefone, e-mail e endereço definidos
     *
     * @param nome o nome do Cliente
     * @param telefone o telefone do Cliente
     * @param email o e-mail do Cliente
     * @param endereco o endereço do Cliente
     */
    public Cliente(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    /**
     * Retorna o id do Cliente
     *
     * @return o id do Cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Define o id do Cliente
     *
     * @param id o id do Cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do Cliente
     *
     * @return o nome do Cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do Cliente
     *
     * @param nome o nome do Cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o telefone do Cliente
     *
     * @return o telefone do Cliente
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do Cliente
     *
     * @param telefone o telefone do Cliente
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o e-mail do Cliente
     *
     * @return o e-mail do Cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do Cliente
     *
     * @param email o e-mail do Cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o endereço do Cliente
     *
     * @return o endereço do Cliente
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do Cliente
     *
     * @param endereco o endereço do Cliente
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
