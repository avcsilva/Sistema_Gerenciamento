package com.pbl.sistema_gerenciamento.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrdemServicoTest {

    @Test
    void getId() {
        OrdemServico ordemServico = new OrdemServico(null, null, null);
        ordemServico.setId(7);

        assertEquals(7, ordemServico.getId());
    }

    @Test
    void setId() {
        OrdemServico ordemServico = new OrdemServico(null, null, null);
        ordemServico.setId(7);

        ordemServico.setId(2);

        assertEquals(2, ordemServico.getId());
    }

    @Test
    void getListaServicos() {
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(null, null));
        lista.add(new Montagem(null));
        lista.add(new Instalacao(null, null, null, null));

        OrdemServico ordemServico = new OrdemServico(lista, null, null);

        lista = ordemServico.getListaServicos();

        assertEquals(3, lista.size());
    }

    @Test
    void setListaServicos() {
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(null, null));
        lista.add(new Montagem(null));
        lista.add(new Instalacao(null, null, null, null));

        OrdemServico ordemServico = new OrdemServico(lista, null, null);

        lista = new ArrayList<Servico>();
        lista.add(new Limpeza(null, null));
        lista.add(new Instalacao(null, null, null, null));

        ordemServico.setListaServicos(lista);

        lista = ordemServico.getListaServicos();

        assertEquals(2, lista.size());
    }

    @Test
    void adicionaServico() {
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(null, null));
        lista.add(new Montagem(null));
        lista.add(new Instalacao(null, null, null, null));

        OrdemServico ordemServico = new OrdemServico(lista, null, null);

        ordemServico.adicionaServico(new Limpeza(null, null));

        lista = ordemServico.getListaServicos();

        assertEquals(4, lista.size());
    }

    @Test
    void removeServico() {
        Servico serv1 = new Limpeza(null, null);
        Servico serv2 = new Montagem(null);
        Servico serv3 = new Instalacao(null, null, null, null);
        serv1.setId(1);
        serv2.setId(1);
        serv3.setId(1);

        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(serv1);
        lista.add(serv2);
        lista.add(serv3);

        OrdemServico ordemServico = new OrdemServico(lista, null, null);
        ordemServico.removeServico(1, 2);

        lista = ordemServico.getListaServicos();

        assertEquals(2, lista.size());
    }

    @Test
    void getTecnico() {
        Tecnico tecn = new Tecnico(null, null);
        tecn.setId(7);

        OrdemServico ordemServico = new OrdemServico(null, null, null);
        ordemServico.setTecnico(tecn);

        assertEquals(7, ordemServico.getTecnico().getId());
    }

    @Test
    void setTecnico() {
        Tecnico tecn = new Tecnico(null, null);
        tecn.setId(7);

        OrdemServico ordemServico = new OrdemServico(null, null, null);
        ordemServico.setTecnico(tecn);

        tecn = new Tecnico(null, null);
        tecn.setId(2);

        ordemServico.setTecnico(tecn);

        assertEquals(2, ordemServico.getTecnico().getId());
    }

    @Test
    void getStatus() {
        OrdemServico ordemServico = new OrdemServico(null, null, null);
        ordemServico.setStatus("Ok");

        assertEquals("Ok", ordemServico.getStatus());
    }

    @Test
    void setStatus() {
        OrdemServico ordemServico = new OrdemServico(null, null, null);
        ordemServico.setStatus("Ok");

        ordemServico.setStatus("Fim");

        assertEquals("Fim", ordemServico.getStatus());
    }

    @Test
    void getCliente() {
        Cliente cliente = new Cliente(null, null, null, null);
        cliente.setId(7);

        OrdemServico ordemServico = new OrdemServico(null, cliente, null);

        assertEquals(7, ordemServico.getCliente().getId());
    }

    @Test
    void setCliente() {
        Cliente cliente = new Cliente(null, null, null, null);
        cliente.setId(7);

        OrdemServico ordemServico = new OrdemServico(null, cliente, null);

        cliente = new Cliente(null, null, null, null);
        cliente.setId(2);

        ordemServico.setCliente(cliente);

        assertEquals(2, ordemServico.getCliente().getId());
    }

    @Test
    void getCriacao() {
        OrdemServico ordemServico = new OrdemServico(null, null, "10/10/2010");

        assertEquals("10/10/2010", ordemServico.getCriacao());
    }

    @Test
    void setCriacao() {
        OrdemServico ordemServico = new OrdemServico(null, null, "10/10/2010");
        ordemServico.setCriacao("02/02/2002");

        assertEquals("02/02/2002", ordemServico.getCriacao());
    }

    @Test
    void getFinalizacao() {
        OrdemServico ordemServico = new OrdemServico(null, null, null);
        ordemServico.setFinalizacao("10/10/2010");

        assertEquals("10/10/2010", ordemServico.getFinalizacao());
    }

    @Test
    void getPreco() {
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(10.00, null));
        lista.add(new Limpeza(10.00, null));
        lista.add(new Instalacao(10.00, null, null, null));

        OrdemServico ordemServico = new OrdemServico(lista, null, null);

        assertEquals(30.00, ordemServico.getPreco());

        ordemServico.adicionaServico(new Limpeza(10.00, null));

        assertEquals(40.00, ordemServico.getPreco());
    }

    @Test
    void setPreco() {
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(10.00, null));
        lista.add(new Limpeza(10.00, null));
        lista.add(new Instalacao(10.00, null, null, null));

        OrdemServico ordemServico = new OrdemServico(lista, null, null);

        ordemServico.setPreco(20.00);

        assertEquals(20.00, ordemServico.getPreco());
    }

    @Test
    void getCusto() {
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(null, 10.00));
        lista.add(new Limpeza(null, 10.00));
        lista.add(new Instalacao(null, 10.00, null, null));

        OrdemServico ordemServico = new OrdemServico(lista, null, null);

        assertEquals(30.00, ordemServico.getCusto());

        ordemServico.adicionaServico(new Limpeza(null, 10.00));

        assertEquals(40.00, ordemServico.getCusto());
    }

    @Test
    void setCusto() {
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(null, 10.00));
        lista.add(new Limpeza(null, 10.00));
        lista.add(new Instalacao(null, 10.00, null, null));

        OrdemServico ordemServico = new OrdemServico(lista, null, null);

        ordemServico.setCusto(20.00);

        assertEquals(20.00, ordemServico.getCusto());
    }
}