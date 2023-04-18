package com.pbl.sistema_gerenciamento.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MontagemTest {

    @Test
    void adicionarComponente() {
        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(new ComponentePC(null, null, null, null));
        lista.add(new ComponenteOutro(null, null, null));

        Montagem montagem = new Montagem(lista);

        montagem.adicionarComponente(new ComponentePC(null, null, null, null));

        lista = montagem.getComponentesUsados();

        assertEquals(3, lista.size());
    }

    @Test
    void removerComponente() {
        Componente comp1 = new ComponentePC(null, null, null, null);
        Componente comp2 = new ComponenteOutro(null, null, null);
        comp1.setId(1);
        comp2.setId(1);

        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(comp1);
        lista.add(comp2);

        Montagem montagem = new Montagem(lista);
        montagem.removerComponente(1, 2);

        lista = montagem.getComponentesUsados();

        assertEquals(1, lista.size());
    }

    @Test
    void getComponentesUsados() {
        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(new ComponentePC(null, null, null, null));
        lista.add(new ComponenteOutro(null, null, null));

        Montagem montagem = new Montagem(lista);

        lista = montagem.getComponentesUsados();

        assertEquals(2, lista.size());
    }

    @Test
    void setComponentesUsados() {
        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(new ComponentePC(null, null, null, null));
        lista.add(new ComponenteOutro(null, null, null));

        Montagem montagem = new Montagem(lista);

        lista = new ArrayList<Componente>();
        lista.add(new ComponenteOutro(null, null, null));
        lista.add(new ComponenteOutro(null, null, null));
        lista.add(new ComponenteOutro(null, null, null));

        montagem.setComponentesUsados(lista);

        lista = montagem.getComponentesUsados();

        assertEquals(3, lista.size());
    }

    @Test
    void getPreco(){
        Componente comp1 = new ComponentePC(10.00, null, null, null);
        Componente comp2 = new ComponenteOutro(10.00, null, null);

        comp1.setId(1);
        comp2.setId(2);

        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(comp1);
        lista.add(comp2);

        Montagem montagem = new Montagem(lista);

        assertEquals(20.00, montagem.getPreco());

        montagem.adicionarComponente(new ComponenteOutro(10.00, null, null));

        assertEquals(30.00, montagem.getPreco());

        montagem.removerComponente(2, 2);

        assertEquals(20.00, montagem.getPreco());
    }

    @Test
    void getCusto(){
        Componente comp1 = new ComponentePC(null, 10.00, null, null);
        Componente comp2 = new ComponenteOutro(null, 10.00, null);

        comp1.setId(1);
        comp2.setId(2);

        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(comp1);
        lista.add(comp2);

        Montagem montagem = new Montagem(lista);

        assertEquals(20.00, montagem.getCusto());

        montagem.adicionarComponente(new ComponenteOutro(null, 10.00, null));

        assertEquals(30.00, montagem.getCusto());

        montagem.removerComponente(2, 2);

        assertEquals(20.00, montagem.getCusto());
    }
}