package   com.pbl.sistema_gerenciamento.model;

import java.io.Serializable;

/**
 * Superclasse Usuário, que representará possíveis utilizadores do sistema.
 * Definido por um id, nome e e-mail.
 */
public abstract class Usuario implements Serializable {
    private int id;
    private String nome;
    private String email;

    /**
     * Cria um Usuário com nome e e-mail definidos.
     *
     * @param nome o nome do Usuário
     * @param email o e-mail do Usuário
     */
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    /**
     * Retorna o id do Usuário
     *
     * @return o id do Usuário
     */
    public int getId() {
        return id;
    }

    /**
     * Define o id do Usuário
     *
     * @param id o id do Usuário
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do Usuário
     *
     * @return o nome do Usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do Usuário
     *
     * @param nome o nome do Usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o e-mail do usuário
     *
     * @return o e-mail do Usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do Usuário
     *
     * @param email o e-mail do Usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }
}