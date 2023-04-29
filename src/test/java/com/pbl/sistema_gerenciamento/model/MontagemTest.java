package com.pbl.sistema_gerenciamento.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MontagemTest {

    @Test
    void adicionarComponente() {
        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(new ComponentePC(0.0, 0.0, "ssd", "kingston"));
        lista.add(new ComponenteOutro(0.0, 0.0, "pasta termica"));

        Montagem montagem = new Montagem();

        montagem.setComponentesUsados(lista);

        montagem.adicionarComponente(new ComponentePC(0.0, 0.0, "ssd", "kingston"));

        lista = montagem.getComponentesUsados();

        assertEquals(3, lista.size());
    }

    @Test
    void removerComponente() {
        Componente comp1 = new ComponentePC(0.0, 0.0, "ssd", "kingston");
        Componente comp2 = new ComponenteOutro(0.0, 0.0, "pasta termica");
        comp1.setId(1);
        comp2.setId(1);

        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(comp1);
        lista.add(comp2);

        Montagem montagem = new Montagem();
        montagem.setComponentesUsados(lista);

        montagem.removerComponente(1, 2);

        lista = montagem.getComponentesUsados();

        assertEquals(1, lista.size());
    }

    @Test
    void getComponentesUsados() {
        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(new ComponentePC(0.0, 0.0, "ssd", "kingston"));
        lista.add(new ComponenteOutro(0.0, 0.0, "pasta termica"));

        Montagem montagem = new Montagem();
        montagem.setComponentesUsados(lista);

        lista = montagem.getComponentesUsados();

        assertEquals(2, lista.size());
    }

    @Test
    void setComponentesUsados() {
        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(new ComponentePC(0.0, 0.0, "ssd", "kingston"));
        lista.add(new ComponenteOutro(0.0, 0.0, "pasta termica"));

        Montagem montagem = new Montagem();
        montagem.setComponentesUsados(lista);

        lista = new ArrayList<Componente>();
        lista.add(new ComponenteOutro(0.0, 0.0, "pasta termica"));
        lista.add(new ComponenteOutro(0.0, 0.0, "ventoinha"));
        lista.add(new ComponenteOutro(0.0, 0.0, "cabo"));

        montagem.setComponentesUsados(lista);

        lista = montagem.getComponentesUsados();

        assertEquals(3, lista.size());
    }

    @Test
    void getPreco(){
        Componente comp1 = new ComponentePC(10.00, 0.0, "ssd", "kingston");
        Componente comp2 = new ComponenteOutro(10.00, 0.0, "cabo");

        comp1.setId(1);
        comp2.setId(2);

        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(comp1);
        lista.add(comp2);

        Montagem montagem = new Montagem();
        montagem.setComponentesUsados(lista);

        assertEquals(20.00, montagem.getPreco());

        montagem.adicionarComponente(new ComponenteOutro(10.00, 0.0, "cabo"));

        assertEquals(30.00, montagem.getPreco());

        montagem.removerComponente(2, 2);

        assertEquals(20.00, montagem.getPreco());
    }

    @Test
    void getCusto(){
        Componente comp1 = new ComponentePC(0.0, 10.00, "ssd", "kingston");
        Componente comp2 = new ComponenteOutro(0.0, 10.00, "pasta");

        comp1.setId(1);
        comp2.setId(2);

        ArrayList<Componente> lista = new ArrayList<Componente>();
        lista.add(comp1);
        lista.add(comp2);

        Montagem montagem = new Montagem();
        montagem.setComponentesUsados(lista);

        assertEquals(20.00, montagem.getCusto());

        montagem.adicionarComponente(new ComponenteOutro(0.0, 10.00, "ventoinha"));

        assertEquals(30.00, montagem.getCusto());

        montagem.removerComponente(2, 2);

        assertEquals(20.00, montagem.getCusto());
    }
}