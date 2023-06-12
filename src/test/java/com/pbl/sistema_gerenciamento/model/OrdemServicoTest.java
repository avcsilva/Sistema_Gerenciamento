package com.pbl.sistema_gerenciamento.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrdemServicoTest {

    @Test
    void getId() {
        Cliente cliente = new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br");
        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setId(7);

        assertEquals(7, ordemServico.getId());
    }

    @Test
    void setId() {
        Cliente cliente = new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br");
        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setId(7);

        ordemServico.setId(2);

        assertEquals(2, ordemServico.getId());
    }

    @Test
    void getListaServicos() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(0.0));
        lista.add(new Montagem());
        lista.add(new Instalacao(0.0));

        OrdemServico ordemServico = new OrdemServico(cliente, "11/11/2011");
        ordemServico.setListaServicos(lista);

        lista = ordemServico.getListaServicos();

        assertEquals(3, lista.size());
    }

    @Test
    void setListaServicos() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(0.0));
        lista.add(new Montagem());
        lista.add(new Instalacao(0.0));

        OrdemServico ordemServico = new OrdemServico(cliente, "11/11/2011");
        ordemServico.setListaServicos(lista);

        lista = new ArrayList<Servico>();
        lista.add(new Limpeza(0.0));
        lista.add(new Instalacao(0.0));

        ordemServico.setListaServicos(lista);

        lista = ordemServico.getListaServicos();

        assertEquals(2, lista.size());
    }

    @Test
    void adicionaServico() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(0.0));
        lista.add(new Montagem());
        lista.add(new Instalacao(0.0));

        OrdemServico ordemServico = new OrdemServico(cliente,"12/12/2012");
        ordemServico.setListaServicos(lista);

        ordemServico.adicionaServico(new Limpeza(0.0));

        lista = ordemServico.getListaServicos();

        assertEquals(4, lista.size());
    }

    @Test
    void removeServico() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        Servico serv1 = new Limpeza(0.0);
        Servico serv2 = new Montagem();
        Servico serv3 = new Instalacao(0.0);
        serv1.setId(1);
        serv2.setId(1);
        serv3.setId(1);

        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(serv1);
        lista.add(serv2);
        lista.add(serv3);

        OrdemServico ordemServico = new OrdemServico(cliente,"12/12/2012");
        ordemServico.setListaServicos(lista);
        ordemServico.removeServico(1, 2);

        lista = ordemServico.getListaServicos();

        assertEquals(2, lista.size());
    }

    @Test
    void getTecnico() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        Tecnico tecn = new Tecnico("Mestre", "master@tecno.com", "12345678");
        tecn.setId(7);

        OrdemServico ordemServico = new OrdemServico(cliente, "12/12/2012");
        ordemServico.setTecnico(tecn);

        assertEquals(7, ordemServico.getTecnico().getId());
    }

    @Test
    void setTecnico() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        Tecnico tecn = new Tecnico("Mestre", "master@tecno.com", "12345678");
        tecn.setId(7);

        OrdemServico ordemServico = new OrdemServico(cliente,"12/12/2012");
        ordemServico.setTecnico(tecn);

    tecn = new Tecnico("Senior", "top@tecno.com", "87654321");
        tecn.setId(2);

        ordemServico.setTecnico(tecn);

        assertEquals(2, ordemServico.getTecnico().getId());
    }

    @Test
    void getStatus() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setStatus("Ok");

        assertEquals("Ok", ordemServico.getStatus());
    }

    @Test
    void setStatus() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setStatus("Ok");

        ordemServico.setStatus("Fim");

        assertEquals("Fim", ordemServico.getStatus());
    }

    @Test
    void getCliente() {
        Cliente cliente1 = new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br");
        cliente1.setId(7);

        OrdemServico ordemServico = new OrdemServico(cliente1,"10/05/2003" );

        assertEquals(7, ordemServico.getCliente().getId());
    }

    @Test
    void setCliente() {
        Cliente cliente = new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br");
        cliente.setId(7);

        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");

        cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        cliente.setId(2);

        ordemServico.setCliente(cliente);

        assertEquals(2, ordemServico.getCliente().getId());
    }

    @Test
    void getCriacao() {
        Cliente cliente = new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br");
        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");

        assertEquals("10/10/2010", ordemServico.getCriacao());
    }

    @Test
    void setCriacao() {
        Cliente cliente = new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br");
        OrdemServico ordemServico = new OrdemServico(cliente,  "10/10/2010");
        ordemServico.setCriacao("02/02/2002");

        assertEquals("02/02/2002", ordemServico.getCriacao());
    }

    @Test
    void getFinalizacao() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setFinalizacao("10/10/2010");

        assertEquals("10/10/2010", ordemServico.getFinalizacao());
    }

    @Test
    void getPreco() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(10.00));
        lista.add(new Limpeza(10.00));
        lista.add(new Instalacao(10.00));

        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setListaServicos(lista);

        assertEquals(30.00, ordemServico.getPreco());

        Limpeza limp = new Limpeza(10.00);
        limp.setId(3);

        ordemServico.adicionaServico(limp);

        assertEquals(40.00, ordemServico.getPreco());

        ordemServico.removeServico(3, 2);

        assertEquals(30.00, ordemServico.getPreco());
    }

    @Test
    void setPreco() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        ArrayList<Servico> lista = new ArrayList<Servico>();
        lista.add(new Limpeza(10.00));
        lista.add(new Limpeza(10.00));
        lista.add(new Instalacao(10.00));

        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setListaServicos(lista);

        ordemServico.setPreco(20.00);

        assertEquals(20.00, ordemServico.getPreco());
    }

    @Test
    void getCusto() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        ArrayList<Servico> lista = new ArrayList<Servico>();

        Limpeza limp1 = new Limpeza(10.00);
        limp1.setCusto(10.00);
        Limpeza limp2 = new Limpeza(10.00);
        limp2.setCusto(10.00);
        Instalacao inst = new Instalacao(10.00);
        inst.setCusto(10.00);
        lista.add(limp1);
        lista.add(limp2);
        lista.add(inst);

        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setListaServicos(lista);

        assertEquals(30.00, ordemServico.getCusto());

        Limpeza limp3 = new Limpeza(10.00);
        limp3.setCusto(10.00);
        limp3.setId(3);

        ordemServico.adicionaServico(limp3);

        assertEquals(40.00, ordemServico.getCusto());

        ordemServico.removeServico(3, 2);

        assertEquals(30.00, ordemServico.getCusto());
    }

    @Test
    void setCusto() {
        Cliente cliente = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");
        ArrayList<Servico> lista = new ArrayList<Servico>();
        Limpeza limp1 = new Limpeza(10.00);
        limp1.setCusto(10.00);
        Limpeza limp2 = new Limpeza(10.00);
        limp2.setCusto(10.00);
        Instalacao inst = new Instalacao(10.00);
        inst.setCusto(10.00);
        lista.add(limp1);
        lista.add(limp2);
        lista.add(inst);

        OrdemServico ordemServico = new OrdemServico(cliente, "10/10/2010");
        ordemServico.setListaServicos(lista);

        ordemServico.setCusto(20.00);

        assertEquals(20.00, ordemServico.getCusto());
    }
}