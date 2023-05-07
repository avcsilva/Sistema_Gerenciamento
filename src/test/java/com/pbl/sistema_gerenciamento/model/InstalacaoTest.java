package com.pbl.sistema_gerenciamento.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InstalacaoTest {

    @Test
    void adicionarPrograma() {
        Instalacao inst = new Instalacao(0.0);
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("IntelliJ");
        lista.add("QuartusII");
        inst.setProgramas(lista);
        assertEquals(2, inst.getListaProgramas().size());

        inst.adicionarPrograma("VSCode");
        assertEquals(3, inst.getListaProgramas().size());
    }
}