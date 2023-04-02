package com.pbl.sistema_gerenciamento.model;

import java.util.*;

public class Instalacao extends Servico {
    public ArrayList<String> programas;
    public String Sistema_opearacional;
    public Instalacao(Double preco, Double custo) {
        super(preco, custo);
    }
}
