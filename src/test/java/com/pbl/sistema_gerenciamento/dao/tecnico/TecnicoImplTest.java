package com.pbl.sistema_gerenciamento.dao.tecnico;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.dao.administrador.AdministradorDAO;
import com.pbl.sistema_gerenciamento.model.Administrador;
import com.pbl.sistema_gerenciamento.model.Tecnico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TecnicoImplTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        DAO.getTecnicoDAO().deletarTodos();
    }

    @Test
    void criar() {
        TecnicoDAO dao = DAO.getTecnicoDAO();

        Tecnico tecnico1 = new Tecnico ("Marcio Vitor", "marciovitor@uefs.br");
        Tecnico tecnico2 = new Tecnico ("Raynan Azkaban", "raynanzinho@uefs.br");

        tecnico1.setId(0);
        tecnico2.setId(1);

        Tecnico novo1 = dao.criar(tecnico1);
        Tecnico novo2 = dao.criar(tecnico2);

        assertEquals(novo1, tecnico1);
        assertEquals(novo2, tecnico2);
    }

    @Test
    void acharPorId() {
        TecnicoDAO dao = DAO.getTecnicoDAO();

        dao.criar(new Tecnico ("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Tecnico ("Raynan Azkaban", "raynanzinho@uefs.br"));

        Tecnico tecnico1 = dao.acharPorId(1);
        assertEquals(1, tecnico1.getId());

        tecnico1 = dao.acharPorId(7);
        assertNull(tecnico1);
    }

    @Test
    void acharTodos() {
        TecnicoDAO dao = DAO.getTecnicoDAO();

        dao.criar(new Tecnico ("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Tecnico ("Raynan Azkaban", "raynanzinho@uefs.br"));

        List<Tecnico> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
    }

    @Test
    void deletar() {
        TecnicoDAO dao = DAO.getTecnicoDAO();

        dao.criar(new Tecnico ("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Tecnico ("Raynan Azkaban", "raynanzinho@uefs.br"));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<Tecnico> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        TecnicoDAO dao = DAO.getTecnicoDAO();

        dao.criar(new Tecnico ("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Tecnico ("Raynan Azkaban", "raynanzinho@uefs.br"));

        dao.deletarTodos();

        List<Tecnico> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorNome() {
        TecnicoDAO dao = DAO.getTecnicoDAO();

        Tecnico tecnico1 = new Tecnico ("Marcio Vitor", "marciovitor@uefs.br");
        Tecnico tecnico2 = new Tecnico ("Raynan Azkaban", "raynanzinho@uefs.br");

        dao.criar(tecnico1);
        dao.criar(tecnico2);

        List<Tecnico> lista = dao.acharPorNome("Marcio Vitor");

        assertEquals(1, lista.size());
    }

    @Test
    void acharPorEmail() {
        TecnicoDAO dao = DAO.getTecnicoDAO();

        Tecnico tecnico1 = new Tecnico ("Marcio Vitor", "marciovitor@uefs.br");
        Tecnico tecnico2 = new Tecnico ("Raynan Azkaban", "raynanzinho@uefs.br");

        dao.criar(tecnico1);
        dao.criar(tecnico2);

        List<Tecnico> lista = dao.acharPorNome("marciovitor@uefs.br");

        assertEquals(1, lista.size());
    }
}