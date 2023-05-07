package com.pbl.sistema_gerenciamento.dao.montagem;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Montagem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MontagemImplTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        DAO.getMontagemDAO().deletarTodos();
    }

    @Test
    void criar() {
        MontagemDAO dao = DAO.getMontagemDAO();

        Montagem montagem1 = new Montagem();
        Montagem montagem2 = new Montagem();

        montagem1.setId(0);
        montagem1.setId(1);

        Montagem novo1 = dao.criar(montagem1);
        Montagem novo2 = dao.criar(montagem2);

        assertEquals(novo1, montagem1);
        assertEquals(novo2, montagem2);


    }

    @Test
    void acharPorId() {
        MontagemDAO dao = DAO.getMontagemDAO();

        dao.criar(new Montagem());
        dao.criar(new Montagem());

        Montagem montagem = dao.acharPorId(1);
        assertEquals(1, montagem.getId());

        montagem = dao.acharPorId(7);
        assertNull(montagem);
    }

    @Test
    void acharTodos() {
        MontagemDAO dao = DAO.getMontagemDAO();

        dao.criar(new Montagem());
        dao.criar(new Montagem());

        List<Montagem> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
    }

    @Test
    void deletar() {
        MontagemDAO dao = DAO.getMontagemDAO();

        dao.criar(new Montagem());
        dao.criar(new Montagem());

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<Montagem> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        MontagemDAO dao = DAO.getMontagemDAO();

        dao.criar(new Montagem());
        dao.criar(new Montagem());

        dao.deletarTodos();

        List<Montagem> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorPreco() {
        MontagemDAO dao = DAO.getMontagemDAO();


        Montagem montagem1 = new Montagem();
        Montagem montagem2 = new Montagem();
        Montagem montagem3 = new Montagem();

        montagem1.setPreco(12.25);
        montagem2.setPreco(10.00);
        montagem3.setPreco(12.25);

        dao.criar(montagem1);
        dao.criar(montagem2);
        dao.criar(montagem3);

        List<Montagem> lista = dao.acharPorPreco(12.25);

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorCusto() {
        MontagemDAO dao = DAO.getMontagemDAO();


        Montagem montagem1 = new Montagem();
        Montagem montagem2 = new Montagem();
        Montagem montagem3 = new Montagem();

        montagem1.setCusto(12.25);
        montagem2.setCusto(10.00);
        montagem3.setCusto(12.25);

        dao.criar(montagem1);
        dao.criar(montagem2);
        dao.criar(montagem3);

        List<Montagem> lista = dao.acharPorCusto(12.25);

        assertEquals(2, lista.size());
    }
}