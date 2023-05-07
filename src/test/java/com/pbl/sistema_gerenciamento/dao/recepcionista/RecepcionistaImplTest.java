package com.pbl.sistema_gerenciamento.dao.recepcionista;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Recepcionista;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecepcionistaImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        DAO.getRecepcionistaDAO().deletarTodos();
    }

    @Test
    void criar() {
        RecepcionistaDAO dao = DAO.getRecepcionistaDAO();

        Recepcionista recepcionista1 = new Recepcionista("Marcio Vitor", "marciovitor@uefs.br");
        Recepcionista recepcionista2 = new Recepcionista("Raynan Azkaban", "raynanzinho@uefs.br");

        recepcionista1.setId(0);
        recepcionista2.setId(1);

        Recepcionista novo1 = dao.criar(recepcionista1);
        Recepcionista novo2 = dao.criar(recepcionista2);

        assertEquals(novo1, recepcionista1);
        assertEquals(novo2, recepcionista2);
    }

    @Test
    void acharPorId() {
        RecepcionistaDAO dao = DAO.getRecepcionistaDAO();

        dao.criar(new Recepcionista("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Recepcionista("Raynan Azkaban", "raynanzinho@uefs.br"));

        Recepcionista recp = dao.acharPorId(1);
        assertEquals(1, recp.getId());

        recp = dao.acharPorId(7);
        assertNull(recp);
    }

    @Test
    void acharTodos() {
        RecepcionistaDAO dao = DAO.getRecepcionistaDAO();

        dao.criar(new Recepcionista("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Recepcionista("Raynan Azkaban", "raynanzinho@uefs.br"));

        List<Recepcionista> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
        RecepcionistaDAO dao = DAO.getRecepcionistaDAO();

        Recepcionista rec1 = dao.criar(new Recepcionista("Marcio Vitor", "marciovitor@uefs.br"));

        rec1.setEmail("vitormarcio@uefs.br");
        dao.atualizar(rec1);

        assertEquals(rec1.getEmail(), dao.acharPorId(rec1.getId()).getEmail());
    }

    @Test
    void deletar() {
        RecepcionistaDAO dao = DAO.getRecepcionistaDAO();

        dao.criar(new Recepcionista("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Recepcionista("Raynan Azkaban", "raynanzinho@uefs.br"));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<Recepcionista> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        RecepcionistaDAO dao = DAO.getRecepcionistaDAO();

        dao.criar(new Recepcionista("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Recepcionista("Raynan Azkaban", "raynanzinho@uefs.br"));

        dao.deletarTodos();

        List<Recepcionista> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorNome() {
        RecepcionistaDAO dao = DAO.getRecepcionistaDAO();

        Recepcionista recepcionista1 = dao.criar(new Recepcionista("Marcio Vitor", "marciovitor@uefs.br"));
        Recepcionista recepcionista2 = dao.criar(new Recepcionista("Raynan Azkaban", "raynanzinho@uefs.br"));


        List<Recepcionista> lista = dao.acharPorNome("Marcio Vitor");

        assertEquals(1, lista.size());
    }

    @Test
    void acharPorEmail() {
        RecepcionistaDAO dao = DAO.getRecepcionistaDAO();

        Recepcionista recepcionista1 = dao.criar(new Recepcionista("Marcio Vitor", "marciovitor@uefs.br"));
        Recepcionista recepcionista2 = dao.criar(new Recepcionista("Raynan Azkaban", "raynanzinho@uefs.br"));


        List<Recepcionista> lista = dao.acharPorEmail("raynanzinho@uefs.br");

        assertEquals(1, lista.size());
    }
}