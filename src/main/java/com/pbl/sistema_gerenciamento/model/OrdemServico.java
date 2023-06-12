package com.pbl.sistema_gerenciamento.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Ordem de Serviço, que representa uma série de trabalhos requisitados por um Cliente,
 * a serem realizados por um Técnico. Definido por um id para sua identificação, por sua lista de serviços,
 * técnico ao qual foi atribuída, status, cliente pelo qual foi requisitado, sua data de criação e finalização,
 * preço, custo e método de pagamento.
 */
public class OrdemServico implements Serializable {
    private int id;
    private ArrayList<Servico> listaServicos;
    private Tecnico tecnico;
    private String status;
    private Cliente cliente;
    private String criacao;
    private String finalizacao;
    private Double preco;
    private Double custo;
    private String metodoPagamento;

    /**
     * Cria uma Ordem de Serviço com seu id, lista de serviços, cliente e data de criação definidos.
     * Preço e custo da Ordem de Serviço serão definidos com base na lista de Serviços atribuída.
     *
     * @param cliente o Cliente pelo qual a Ordem de Serviço foi requisitada
     * @param criacao a data de criação da Ordem de Serviço
     */
    public OrdemServico(Cliente cliente, String criacao) {
        this.cliente = cliente;
        this.criacao = criacao;
        this.preco = 0.0;
        this.custo = 0.0;
        this.listaServicos = new ArrayList<Servico>();
    }

    /**
     * Retorna o id da Ordem de Serviço
     *
     * @return o id da Ordem de Serviço
     */
    public int getId() {
        return id;
    }

    /**
     * Define o id da Ordem de Serviço
     *
     * @param id o id da Ordem de Serviço
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a lista de Serviços a serem realizados
     *
     * @return a lista de Serviços
     */
    public ArrayList<Servico> getListaServicos() {
        return listaServicos;
    }

    /**
     * Define uma nova lista de Serviços a serem realizados
     *
     * @param listaServicos a lista de Serviços
     */
    public void setListaServicos(ArrayList<Servico> listaServicos) {
        this.preco = 0.0;
        this.custo = 0.0;
        this.listaServicos = listaServicos;

        for (Servico s : listaServicos){
            this.preco = this.preco + s.getPreco();
            this.custo = this.custo + s.getCusto();
        }
    }

    /**
     * Adiciona um Serviço à lista de Serviços
     *
     * @param serv o Serviço a ser adicionado
     */
    public void adicionaServico(Servico serv){
        this.listaServicos.add(serv);
        this.preco = this.preco + serv.getPreco();
        this.custo = this.custo + serv.getCusto();
    }

    /**
     * Remove um Serviço da lista de Serviços com base no id e na opção de Serviço escolhida
     *
     * @param id o id do Serviço a ser removido
     * @param opc o tipo de Serviço a ser removido. 1 para Instalação, 2 para Limpeza, 3 para Montagem
     */
    public void removeServico(int id, int opc){
        for (Servico s : this.listaServicos){
            if (s.getId() == id){
                if (opc == 1 && s instanceof Instalacao) {
                    this.preco = this.preco - s.getPreco();
                    this.custo = this.custo - s.getCusto();
                    this.listaServicos.remove(s);
                    return;

                }
                if (opc == 2 && s instanceof Limpeza) {
                    this.preco = this.preco - s.getPreco();
                    this.custo = this.custo - s.getCusto();
                    this.listaServicos.remove(s);
                    return;
                }
                if (opc == 3 && s instanceof Montagem) {
                    this.preco = this.preco - s.getPreco();
                    this.custo = this.custo - s.getCusto();
                    this.listaServicos.remove(s);
                    return;
                }
            }
        }
    }

    /**
     * Retorna o Técnico responsável pela Ordem de Serviço
     *
     * @return o Técnico responsável pela Ordem de Serviço
     */
    public Tecnico getTecnico() {
        return tecnico;
    }

    /**
     * Define o Técnico a ser responsável pela Ordem de Serviço
     *
     * @param tecnico o Técnico a ser responsável pela Ordem de Serviço
     */
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * Retorna o status atual da Ordem de Serviço
     *
     * @return o status atual da Ordem de Serviço
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status atual da Ordem de Serviço
     *
     * @param status o status atual da Ordem de Serviço
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retorna o Cliente relacionado à Ordem de Serviço
     *
     * @return o Cliente relacionado à Ordem de Serviço
     */
    public Cliente getCliente() {
        return cliente;
    }

    public String getClienteNome() {
        return cliente.getNome();
    }

    /**
     * Define o Cliente relacionado à Ordem de Serviço
     *
     * @param cliente o Cliente relacionado à Ordem de Serviço
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna a data de criação da Ordem de Serviço
     *
     * @return a data de criação da Ordem de Serviço
     */
    public String getCriacao() {
        return criacao;
    }

    /**
     * Define a data de criação da Ordem de Serviço
     *
     * @param criacao a data de criação da Ordem de Serviço
     */
    public void setCriacao(String criacao) {
        this.criacao = criacao;
    }

    /**
     * Retorna a data de finalização da Ordem de Serviço
     *
     * @return a data de finalização da Ordem de Serviço
     */
    public String getFinalizacao() {
        return finalizacao;
    }

    /**
     * Define a data de finalização da Ordem de Serviço
     *
     * @param finalizacao a data de finalização da Ordem de Serviço
     */
    public void setFinalizacao(String finalizacao) {
        this.finalizacao = finalizacao;
    }

    /**
     * Retorna o preço da Ordem de Serviço
     *
     * @return o preço da Ordem de Serviço
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Define o preço da Ordem de Serviço
     *
     * @param preco o preço da Ordem de Serviço
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * Retorna o custo da Ordem de Serviço
     *
     * @return o custo da Ordem de Serviço
     */
    public Double getCusto() {
        return custo;
    }

    /**
     * Define o custo da Ordem de Serviço
     *
     * @param custo o custo da Ordem de Serviço
     */
    public void setCusto(Double custo) {
        this.custo = custo;
    }

    /**
     * Retorna o método de pagamento para a Ordem de Serviço
     *
     * @return o método de pagamento para a Ordem de Serviço
     */
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    /**
     * Define o método de pagamento para a Ordem de Serviço
     *
     * @param metodoPagamento o método de pagamento para a Ordem de Serviço
     */
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}