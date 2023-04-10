package com.pbl.sistema_gerenciamento.dao.ordemservico;

import com.pbl.sistema_gerenciamento.model.Cliente;
import com.pbl.sistema_gerenciamento.model.OrdemServico;
import com.pbl.sistema_gerenciamento.model.Tecnico;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdemServicoListImplTest {
    @Test
    void criar() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        OrdemServico ordem1 = new OrdemServico(null, null, null);
        OrdemServico ordem2 = new OrdemServico(null, null, null);

        ordem1.setId(0);
        ordem2.setId(1);

        OrdemServico novo1 = dao.criar(ordem1);
        OrdemServico novo2 = dao.criar(ordem2);

        assertEquals(ordem1, novo1);
        assertEquals(ordem2, novo2);
    }

    @Test
    void acharPorId() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        dao.criar(new OrdemServico(null, null, null));
        dao.criar(new OrdemServico(null, null, null));

        OrdemServico ordem = dao.acharPorId(1);
        assertEquals(1, ordem.getId());

        ordem = dao.acharPorId(7);
        assertNull(ordem);
    }

    @Test
    void acharTodos() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        dao.criar(new OrdemServico(null, null, null));
        dao.criar(new OrdemServico(null, null, null));

        List<OrdemServico> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        OrdemServico ordem1 = new OrdemServico(null, null, null);
        ordem1.setStatus("Ok");
        ordem1 = dao.criar(ordem1);

        ordem1.setStatus("Fim");

        dao.atualizar(ordem1);

        assertEquals(ordem1.getStatus(), dao.acharPorId(ordem1.getId()).getStatus());
    }

    @Test
    void deletar() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        dao.criar(new OrdemServico(null, null, null));
        dao.criar(new OrdemServico(null, null, null));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<OrdemServico> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        dao.criar(new OrdemServico(null, null, null));
        dao.criar(new OrdemServico(null, null, null));

        dao.deletarTodos();

        assertNull(dao.acharTodos());
    }

    @Test
    void acharPorTecnico() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        Tecnico tecn1 = new Tecnico(null, null);
        Tecnico tecn2 = new Tecnico(null, null);

        tecn1.setId(1);
        tecn2.setId(2);

        OrdemServico ordem1 = new OrdemServico(null, null, null);
        OrdemServico ordem2 = new OrdemServico(null, null, null);
        OrdemServico ordem3 = new OrdemServico(null, null, null);

        ordem1.setTecnico(tecn1);
        ordem2.setTecnico(tecn2);
        ordem3.setTecnico(tecn1);

        dao.criar(ordem1);
        dao.criar(ordem2);
        dao.criar(ordem3);

        List<OrdemServico> lista = dao.acharPorTecnico(1);

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorStatus() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        OrdemServico ordem1 = new OrdemServico(null, null, null);
        OrdemServico ordem2 = new OrdemServico(null, null, null);
        OrdemServico ordem3 = new OrdemServico(null, null, null);
        OrdemServico ordem4 = new OrdemServico(null, null, null);

        ordem1.setStatus("Ok");
        ordem2.setStatus("Fim");
        ordem3.setStatus("Fim");
        ordem4.setStatus("Ok");

        dao.criar(ordem1);
        dao.criar(ordem2);
        dao.criar(ordem3);
        dao.criar(ordem4);

        List<OrdemServico> lista = dao.acharPorStatus("Fim");

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorCliente() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        Cliente cliente1 = new Cliente(null, null, null, null);
        Cliente cliente2 = new Cliente(null, null, null, null);

        cliente1.setId(1);
        cliente2.setId(2);

        dao.criar(new OrdemServico(null, cliente1, null));
        dao.criar(new OrdemServico(null, cliente2, null));
        dao.criar(new OrdemServico(null, cliente1, null));

        List<OrdemServico> lista = dao.acharPorCliente(2);

        assertEquals(1, lista.size());
    }

    @Test
    void acharPorDataC() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        dao.criar(new OrdemServico(null, null, "10/05/2020"));
        dao.criar(new OrdemServico(null, null, "01/04/2020"));
        dao.criar(new OrdemServico(null, null, "25/05/2020"));
        dao.criar(new OrdemServico(null, null, "20/09/2020"));


        List<OrdemServico> lista = dao.acharPorDataC("01/04/2020");

        assertEquals(1, lista.size());
    }

    @Test
    void acharPorDataF() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        OrdemServico ordem1 = new OrdemServico(null, null, "10/05/2020");
        OrdemServico ordem2 = new OrdemServico(null, null, "01/04/2020");
        OrdemServico ordem3 = new OrdemServico(null, null, "25/05/2020");
        OrdemServico ordem4 = new OrdemServico(null, null, "20/09/2020");

        ordem1.setFinalizacao("10/05/2020");
        ordem2.setFinalizacao("01/04/2020");
        ordem3.setFinalizacao("25/05/2020");
        ordem4.setFinalizacao("20/09/2020");

        dao.criar(ordem1);
        dao.criar(ordem2);
        dao.criar(ordem3);
        dao.criar(ordem4);

        List<OrdemServico> lista = dao.acharPorDataF("25/05/2020");

        assertEquals(1, lista.size());
    }

    @Test
    void acharPorPreco() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        OrdemServico ordem1 = new OrdemServico(null, null, null);
        OrdemServico ordem2 = new OrdemServico(null, null, null);
        OrdemServico ordem3 = new OrdemServico(null, null, null);

        ordem1.setPreco(12.25);
        ordem2.setPreco(10.00);
        ordem3.setPreco(12.25);

        dao.criar(ordem1);
        dao.criar(ordem2);
        dao.criar(ordem3);

        List<OrdemServico> lista = dao.acharPorPreco(12.25);

        assertEquals(2, lista.size());

    }

    @Test
    void acharPorCusto() {
        OrdemServicoDAO dao = new OrdemServicoListImpl();

        OrdemServico ordem1 = new OrdemServico(null, null, null);
        OrdemServico ordem2 = new OrdemServico(null, null, null);
        OrdemServico ordem3 = new OrdemServico(null, null, null);

        ordem1.setCusto(12.25);
        ordem2.setCusto(10.00);
        ordem3.setCusto(12.25);

        dao.criar(ordem1);
        dao.criar(ordem2);
        dao.criar(ordem3);

        List<OrdemServico> lista = dao.acharPorCusto(12.25);

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorMetPag() {
        OrdemServicoDAO dao =  new OrdemServicoListImpl();

        OrdemServico ordem1 = new OrdemServico(null, null, null);
        OrdemServico ordem2 = new OrdemServico(null, null, null);
        OrdemServico ordem3 = new OrdemServico(null, null, null);
        OrdemServico ordem4 = new OrdemServico(null, null, null);

        ordem1.setMetodoPagamento("Cartao");
        ordem2.setMetodoPagamento("Boleto");
        ordem3.setMetodoPagamento("Pix");
        ordem4.setMetodoPagamento("Cartao");

        dao.criar(ordem1);
        dao.criar(ordem2);
        dao.criar(ordem3);
        dao.criar(ordem4);

        List<OrdemServico> lista = dao.acharPorMetPag("Pix");

        assertEquals(1, lista.size());
    }
}