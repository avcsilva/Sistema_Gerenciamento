package com.pbl.sistema_gerenciamento.dao.administrador;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.dao.montagem.MontagemDAO;
import com.pbl.sistema_gerenciamento.dao.ordemservico.OrdemServicoDAO;
import com.pbl.sistema_gerenciamento.model.Administrador;
import com.pbl.sistema_gerenciamento.model.Cliente;
import com.pbl.sistema_gerenciamento.model.Montagem;
import com.pbl.sistema_gerenciamento.model.OrdemServico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorImplTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        DAO.getAdministradorDAO().deletarTodos();
    }

    @Test
    void criar() {
        AdministradorDAO dao = DAO.getAdministradorDAO();

        Administrador administrador1 = new Administrador("Marcio Vitor", "marciovitor@uefs.br");
        Administrador administrador2 = new Administrador("Raynan Azkaban", "raynanzinho@uefs.br");

        administrador1.setId(0);
        administrador2.setId(1);

        Administrador novo1 = dao.criar(administrador1);
        Administrador novo2 = dao.criar(administrador2);

        assertEquals(novo1, administrador1);
        assertEquals(novo2, administrador2);
    }

    @Test
    void acharPorId() {
        AdministradorDAO dao = DAO.getAdministradorDAO();

        dao.criar(new Administrador("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Administrador("Raynan Azkaban", "raynanzinho@uefs.br"));

        Administrador adm = dao.acharPorId(1);
        assertEquals(1, adm.getId());

        adm = dao.acharPorId(7);
        assertNull(adm);
    }

    @Test
    void acharTodos() {
        AdministradorDAO dao = DAO.getAdministradorDAO();

        dao.criar(new Administrador("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Administrador("Raynan Azkaban", "raynanzinho@uefs.br"));

        List<Administrador> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
        AdministradorDAO dao = DAO.getAdministradorDAO();

        Administrador adm1 = dao.criar(new Administrador("Marcio Vitor", "marciovitor@uefs.br"));

        adm1.setEmail("vitormarcio@uefs.br");
        dao.atualizar(adm1);

        assertEquals(adm1.getEmail(), dao.acharPorId(adm1.getId()).getEmail());
    }

    @Test
    void deletar() {
        AdministradorDAO dao = DAO.getAdministradorDAO();

        dao.criar(new Administrador("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Administrador("Raynan Azkaban", "raynanzinho@uefs.br"));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<Administrador> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        AdministradorDAO dao = DAO.getAdministradorDAO();

        dao.criar(new Administrador("Marcio Vitor", "marciovitor@uefs.br"));
        dao.criar(new Administrador("Raynan Azkaban", "raynanzinho@uefs.br"));

        dao.deletarTodos();

        List<Administrador> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorNome() {
        AdministradorDAO dao = DAO.getAdministradorDAO();

        Administrador adm1 = dao.criar(new Administrador("Marcio Vitor", "marciovitor@uefs.br"));
        Administrador adm2 = dao.criar(new Administrador("Raynan Azkaban", "raynanzinho@uefs.br"));


        List<Administrador> lista = dao.acharPorNome("Marcio Vitor");

        assertEquals(1, lista.size());
    }

    @Test
    void acharPorEmail() {
        AdministradorDAO dao = DAO.getAdministradorDAO();

        Administrador adm1 = dao.criar(new Administrador("Marcio Vitor", "marciovitor@uefs.br"));
        Administrador adm2 = dao.criar(new Administrador("Raynan Azkaban", "raynanzinho@uefs.br"));

        List<Administrador> lista = dao.acharPorEmail("raynanzinho@uefs.br");

        assertEquals(1, lista.size());
    }
}