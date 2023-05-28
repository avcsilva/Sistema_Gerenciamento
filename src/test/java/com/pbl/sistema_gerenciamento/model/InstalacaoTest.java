package com.pbl.sistema_gerenciamento.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InstalacaoTest {

    @Test
    void adicionarPrograma() {
        Instalacao inst = new Instalacao(0.0);
        inst.setPrograma("Programa 1");
        assertEquals("Programa 1", inst.getPrograma());
    }
}