package com.pbl.sistema_gerenciamento.dao.instalacao;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Instalacao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstalacaoImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        DAO.getInstalacaoDAO().deletarTodos();
    }

    @Test
    void criar() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        Instalacao instalacao1 = new Instalacao(0.0);
        Instalacao instalacao2 = new Instalacao(0.0);

        instalacao1.setId(0);
        instalacao2.setId(1);

        Instalacao novo1 = dao.criar(instalacao1);
        Instalacao novo2 = dao.criar(instalacao2);

        assertEquals(novo1, instalacao1);
        assertEquals(novo2, instalacao2);
    }

    @Test
    void acharPorId() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        dao.criar(new Instalacao(0.0));
        dao.criar(new Instalacao(0.0));

        Instalacao instalacao = dao.acharPorId(1);
        assertEquals(1, instalacao.getId());

        instalacao = dao.acharPorId(7);
        assertNull(instalacao);
    }

    @Test
    void acharTodos() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        dao.criar(new Instalacao(0.0));
        dao.criar(new Instalacao(0.0));

        List<Instalacao> lista = dao.acharTodos();

        assertEquals(2, lista.size());
    }

    @Test
    void atualizar() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        Instalacao inst = dao.criar(new Instalacao(12.25));

        inst.setPreco(10.00);
        dao.atualizar(inst);

        assertEquals(inst.getPreco(), dao.acharPorId(inst.getId()).getPreco());
    }

    @Test
    void deletar() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        dao.criar(new Instalacao(0.0));
        dao.criar(new Instalacao(0.0));

        dao.deletar(1);

        assertNull(dao.acharPorId(1));

        List<Instalacao> lista = dao.acharTodos();

        assertEquals(1, lista.size());
    }

    @Test
    void deletarTodos() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        dao.criar(new Instalacao(0.0));
        dao.criar(new Instalacao(0.0));

        dao.deletarTodos();

        List<Instalacao> lista = dao.acharTodos();

        assertEquals(0, lista.size());
    }

    @Test
    void acharPorSO() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        Instalacao instalacao1 = new Instalacao(12.25);
        instalacao1.setSistemaOperacional("windows");
        Instalacao instalacao2 = new Instalacao(10.00);
        instalacao2.setSistemaOperacional("linux");
        Instalacao instalacao3 = new Instalacao(12.25);
        instalacao3.setSistemaOperacional("windows");

        dao.criar(instalacao1);
        dao.criar(instalacao2);
        dao.criar(instalacao3);

        List<Instalacao> lista = dao.acharPorSO("windows");

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorPreco() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        Instalacao instalacao1 = new Instalacao(12.25);
        Instalacao instalacao2 = new Instalacao(10.00);
        Instalacao instalacao3 = new Instalacao(12.25);

        dao.criar(instalacao1);
        dao.criar(instalacao2);
        dao.criar(instalacao3);

        List<Instalacao> lista = dao.acharPorPreco(12.25);

        assertEquals(2, lista.size());
    }

    @Test
    void acharPorCusto() {
        InstalacaoDAO dao = DAO.getInstalacaoDAO();

        Instalacao instalacao1 = new Instalacao(0.0);
        Instalacao instalacao2 = new Instalacao(0.0);
        Instalacao instalacao3 = new Instalacao(0.0);

        instalacao1.setCusto(12.25);
        instalacao2.setCusto(10.00);
        instalacao3.setCusto(12.25);

        dao.criar(instalacao1);
        dao.criar(instalacao2);
        dao.criar(instalacao3);

        List<Instalacao> lista = dao.acharPorCusto(12.25);

        assertEquals(2, lista.size());
    }
}