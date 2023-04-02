package com.pbl.sistema_gerenciamento.model;

import java.util.*;

public class OrdemServico {

    private String id;

    private Cliente cliente;

    private Tecnico tecnico;

    private String status;

    private ArrayList<Servico> servicos;

    private String descricao;

    private Date criado_em;

    private Date terminado_em;

    private Double preco;

    private Double custo;

    private String metodo_pagamento;

    public OrdemServico(String id, Cliente cliente, ArrayList<Servico> servicos, Date criado_em){
        this.id = id;
        this.cliente = cliente;
        this.servicos = servicos;
        this.criado_em = criado_em;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTerminado_em(Date terminado_em) {
        this.terminado_em = terminado_em;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public void setMetodo_pagamento(String metodo_pagamento) {
        this.metodo_pagamento = metodo_pagamento;
    }


}
