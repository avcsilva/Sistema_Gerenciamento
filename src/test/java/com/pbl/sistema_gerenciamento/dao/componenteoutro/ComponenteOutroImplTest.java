package com.pbl.sistema_gerenciamento.dao.componenteoutro;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.ComponenteOutro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponenteOutroImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {DAO.getComponenteOutroDAO().deletarTodos();
    }

    @Test
    void criar() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        ComponenteOutro comp1 = new ComponenteOutro(0.0, 0.0, "cooler");
        ComponenteOutro comp2 = new ComponenteOutro(0.0, 0.0, "pasta");

        comp1.setId(0);
        comp2.setId(1);

        ComponenteOutro novo1 = dao.criar(comp1);
        ComponenteOutro novo2 = dao.criar(comp2);

        assertEquals(novo1, comp1);
        assertEquals(novo2, comp2);
    }

    @Test
    void acharPorId() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        dao.criar(new ComponenteOutro(0.0, 0.0, "cooler"));
        dao.criar(new ComponenteOutro(0.0, 0.0, "pasta"));

        ComponenteOutro comp = dao.acharPorId(1);
        assertEquals(1, comp.getId());

        comp = dao.acharPorId(7);
        assertNull(comp);
    }

    @Test
    void acharTodos() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        dao.criar(new ComponenteOutro(0.0, 0.0, "cooler"));
        dao.criar(new ComponenteOutro(0.0, 0.0, "pasta"));

        List<ComponenteOutro> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        ComponenteOutro comp = dao.criar(new ComponenteOutro(0.0, 0.0, "cooler"));
        comp.setDescricao("pasta");
        dao.atualizar(comp);

        assertEquals(comp.getDescricao(), dao.acharPorId(comp.getId()).getDescricao());
    }

    @Test
    void deletar() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        dao.criar(new ComponenteOutro(0.0, 0.0, "cooler"));
        dao.criar(new ComponenteOutro(0.0, 0.0, "pasta"));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<ComponenteOutro> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        dao.criar(new ComponenteOutro(0.0, 0.0, "cooler"));
        dao.criar(new ComponenteOutro(0.0, 0.0, "pasta"));

        dao.deletarTodos();

        List<ComponenteOutro> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorDescricao() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        dao.criar(new ComponenteOutro(0.0, 0.0, "cooler"));
        dao.criar(new ComponenteOutro(0.0, 0.0, "pasta"));
        dao.criar(new ComponenteOutro(0.0, 0.0, "cooler"));
        dao.criar(new ComponenteOutro(0.0, 0.0, "pasta"));

        List<ComponenteOutro> lista = dao.acharPorDescricao("cooler");

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorPreco() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        ComponenteOutro comp1 = new ComponenteOutro(12.25, 0.0, "cooler");
        ComponenteOutro comp2 = new ComponenteOutro(10.00, 0.0, "cooler");
        ComponenteOutro comp3 = new ComponenteOutro(12.25, 0.0, "cooler");

        dao.criar(comp1);
        dao.criar(comp2);
        dao.criar(comp3);

        List<ComponenteOutro> lista = dao.acharPorPreco(12.25);

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorCusto() {
        ComponenteOutroDAO dao = DAO.getComponenteOutroDAO();

        ComponenteOutro comp1 = new ComponenteOutro(0.0, 12.25, "cooler");
        ComponenteOutro comp2 = new ComponenteOutro(0.0, 10.00, "cooler");
        ComponenteOutro comp3 = new ComponenteOutro(0.0, 12.25, "cooler");


        dao.criar(comp1);
        dao.criar(comp2);
        dao.criar(comp3);

        List<ComponenteOutro> lista = dao.acharPorCusto(12.25);

        assertEquals(2, lista.size());
    }
}