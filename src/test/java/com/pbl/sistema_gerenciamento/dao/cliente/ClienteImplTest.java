package com.pbl.sistema_gerenciamento.dao.cliente;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        DAO.getClienteDAO().deletarTodos();
    }

    @Test
    void criar() {
        ClienteDAO dao = DAO.getClienteDAO();

        Cliente cliente1 = new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br");
        Cliente cliente2 = new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br");

        cliente1.setId(0);
        cliente2.setId(1);

        Cliente novo1 = dao.criar(cliente1);
        Cliente novo2 = dao.criar(cliente2);

        assertEquals(cliente1, novo1);
        assertEquals(cliente2, novo2);

    }

    @Test
    void acharPorId() {
        ClienteDAO dao = DAO.getClienteDAO();

        dao.criar(new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br"));
        dao.criar(new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br"));

        Cliente cliente= dao.acharPorId(1);
        assertEquals(1, cliente.getId());

        cliente = dao.acharPorId(7);
        assertNull(cliente);

    }

    @Test
    void acharTodos() {
        ClienteDAO dao = DAO.getClienteDAO();

        dao.criar(new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br"));
        dao.criar(new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br"));

        List<Cliente> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
        ClienteDAO dao = DAO.getClienteDAO();

        Cliente cli1 = dao.criar(new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br"));

        cli1.setEmail("vitormarcio@uefs.br");
        dao.atualizar(cli1);

        assertEquals(cli1.getEmail(), dao.acharPorId(cli1.getId()).getEmail());
    }

    @Test
    void deletar() {
        ClienteDAO dao = DAO.getClienteDAO();

        dao.criar(new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br"));
        dao.criar(new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br"));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<Cliente> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        ClienteDAO dao = DAO.getClienteDAO();

        dao.criar(new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br"));
        dao.criar(new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br"));

        dao.deletarTodos();

        List<Cliente> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorNome() {
        ClienteDAO dao = DAO.getClienteDAO();

        Cliente cliente1 = dao.criar(new Cliente("Marcio Vitor", "688", "991018863", "marciovitor@uefs.br"));
        Cliente cliente2 = dao.criar(new Cliente("Raynan Azkaban", "999", "991018864", "raynanzinho@uefs.br"));


        List<Cliente> lista = dao.acharPorNome("Marcio Vitor");

        assertEquals(1, lista.size());
    }
}