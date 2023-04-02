package com.pbl.sistema_gerenciamento.model;

public class Cliente {

    private String id;

    private String nome;

    private String endereco;

    private String telefone;

    private String email;


    public Cliente(String id, String nome, String endereco, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

}
