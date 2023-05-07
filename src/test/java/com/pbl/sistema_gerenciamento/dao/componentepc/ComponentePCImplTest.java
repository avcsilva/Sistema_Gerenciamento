package com.pbl.sistema_gerenciamento.dao.componentepc;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.ComponentePC;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentePCImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {DAO.getComponentePCDAO().deletarTodos();
    }

    @Test
    void criar() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        ComponentePC comp1 = new ComponentePC(0.0, 0.0, "ram", "kingston");
        ComponentePC comp2 = new ComponentePC(0.0, 0.0, "ram", "kingston");

        comp1.setId(0);
        comp2.setId(1);

        ComponentePC novo1 = dao.criar(comp1);
        ComponentePC novo2 = dao.criar(comp2);

        assertEquals(novo1, comp1);
        assertEquals(novo2, comp2);
    }

    @Test
    void acharPorId() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));
        dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));

        ComponentePC comp = dao.acharPorId(1);
        assertEquals(1, comp.getId());

        comp = dao.acharPorId(7);
        assertNull(comp);
    }

    @Test
    void acharTodos() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));
        dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));

        List<ComponentePC> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        ComponentePC comp = dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));

        comp.setFabricante("hyperx");
        dao.atualizar(comp);

        assertEquals(comp.getFabricante(), dao.acharPorId(comp.getId()).getFabricante());
    }

    @Test
    void deletar() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));
        dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<ComponentePC> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));
        dao.criar(new ComponentePC(0.0, 0.0, "ram", "kingston"));

        dao.deletarTodos();

        List<ComponentePC> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorNome() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        ComponentePC comp1 = new ComponentePC(0.0, 0.0, "ram", "kingston");
        ComponentePC comp2 = new ComponentePC(0.0, 0.0, "placa", "nvidia");

        dao.criar(comp1);
        dao.criar(comp2);

        List<ComponentePC> lista = dao.acharPorNome("ram");

        assertEquals(1, lista.size());
    }

    @Test
    void acharPorPreco() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        ComponentePC comp1 = new ComponentePC(12.25, 0.0, "ram", "kingston");
        ComponentePC comp2 = new ComponentePC(10.00, 0.0, "ram", "kingston");
        ComponentePC comp3 = new ComponentePC(12.25, 0.0, "ram", "kingston");

        dao.criar(comp1);
        dao.criar(comp2);
        dao.criar(comp3);

        List<ComponentePC> lista = dao.acharPorPreco(12.25);

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorCusto() {
        ComponentePCDAO dao = DAO.getComponentePCDAO();

        ComponentePC comp1 = new ComponentePC(0.0, 12.25, "ram", "kingston");
        ComponentePC comp2 = new ComponentePC(0.0, 10.00, "ram", "kingston");
        ComponentePC comp3 = new ComponentePC(0.0, 12.25, "ram", "kingston");

        dao.criar(comp1);
        dao.criar(comp2);
        dao.criar(comp3);

        List<ComponentePC> lista = dao.acharPorCusto(12.25);

        assertEquals(2, lista.size());
    }
}