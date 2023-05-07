package com.pbl.sistema_gerenciamento.dao.limpeza;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Limpeza;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LimpezaImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        DAO.getLimpezaDAO().deletarTodos();
    }

    @Test
    void criar() {
        LimpezaDAO dao = DAO.getLimpezaDAO();

        Limpeza limpeza1 = new Limpeza(0.0);
        Limpeza limpeza2 = new Limpeza(0.0);

        limpeza1.setId(0);
        limpeza2.setId(1);

        Limpeza novo1 = dao.criar(limpeza1);
        Limpeza novo2 = dao.criar(limpeza2);

        assertEquals(novo1, limpeza1);
        assertEquals(novo2, limpeza2);
    }

    @Test
    void acharPorId() {
        LimpezaDAO dao = DAO.getLimpezaDAO();

        dao.criar(new Limpeza(0.0));
        dao.criar(new Limpeza(0.0));

        Limpeza limpeza = dao.acharPorId(1);
        assertEquals(1, limpeza.getId());

        limpeza = dao.acharPorId(7);
        assertNull(limpeza);
    }

    @Test
    void acharTodos() {
        LimpezaDAO dao = DAO.getLimpezaDAO();

        dao.criar(new Limpeza(0.0));
        dao.criar(new Limpeza(0.0));

        List<Limpeza> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
        LimpezaDAO dao = DAO.getLimpezaDAO();

        Limpeza limp = dao.criar(new Limpeza(12.5));

        limp.setPreco(10.2);
        dao.atualizar(limp);

        assertEquals(limp.getPreco(), dao.acharPorId(limp.getId()).getPreco());
    }

    @Test
    void deletar() {
        LimpezaDAO dao = DAO.getLimpezaDAO();

        dao.criar(new Limpeza(0.0));
        dao.criar(new Limpeza(0.0));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<Limpeza> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        LimpezaDAO dao = DAO.getLimpezaDAO();

        dao.criar(new Limpeza(0.0));
        dao.criar(new Limpeza(0.0));

        dao.deletarTodos();

        List<Limpeza> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorPreco() {
        LimpezaDAO dao = DAO.getLimpezaDAO();


        Limpeza limpeza1 = new Limpeza(12.25);
        Limpeza limpeza2 = new Limpeza(10.00);
        Limpeza limpeza3 = new Limpeza(12.25);

        dao.criar(limpeza1);
        dao.criar(limpeza2);
        dao.criar(limpeza3);

        List<Limpeza> lista = dao.acharPorPreco(12.25);

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorCusto() {
        LimpezaDAO dao = DAO.getLimpezaDAO();


        Limpeza limpeza1 = new Limpeza(12.25);
        Limpeza limpeza2 = new Limpeza(10.00);
        Limpeza limpeza3 = new Limpeza(12.25);

        limpeza1.setCusto(12.25);
        limpeza2.setCusto(10.00);
        limpeza3.setCusto(12.25);

        dao.criar(limpeza1);
        dao.criar(limpeza2);
        dao.criar(limpeza3);

        List<Limpeza> lista = dao.acharPorCusto(12.25);

        assertEquals(2, lista.size());
    }
}