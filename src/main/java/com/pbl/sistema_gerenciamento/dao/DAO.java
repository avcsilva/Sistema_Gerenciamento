package com.pbl.sistema_gerenciamento.dao;

import com.pbl.sistema_gerenciamento.dao.administrador.AdministradorDAO;
import com.pbl.sistema_gerenciamento.dao.administrador.AdministradorFileImpl;
import com.pbl.sistema_gerenciamento.dao.cliente.ClienteDAO;
import com.pbl.sistema_gerenciamento.dao.cliente.ClienteFileImpl;
import com.pbl.sistema_gerenciamento.dao.componenteoutro.ComponenteOutroDAO;
import com.pbl.sistema_gerenciamento.dao.componenteoutro.ComponenteOutroFileImpl;
import com.pbl.sistema_gerenciamento.dao.componentepc.ComponentePCDAO;
import com.pbl.sistema_gerenciamento.dao.componentepc.ComponentePCFileImpl;
import com.pbl.sistema_gerenciamento.dao.instalacao.InstalacaoDAO;
import com.pbl.sistema_gerenciamento.dao.instalacao.InstalacaoFileImpl;
import com.pbl.sistema_gerenciamento.dao.limpeza.LimpezaDAO;
import com.pbl.sistema_gerenciamento.dao.limpeza.LimpezaFileImpl;
import com.pbl.sistema_gerenciamento.dao.montagem.MontagemDAO;
import com.pbl.sistema_gerenciamento.dao.montagem.MontagemFileImpl;
import com.pbl.sistema_gerenciamento.dao.ordemservico.OrdemServicoDAO;
import com.pbl.sistema_gerenciamento.dao.ordemservico.OrdemServicoFileImpl;
import com.pbl.sistema_gerenciamento.dao.recepcionista.RecepcionistaDAO;
import com.pbl.sistema_gerenciamento.dao.recepcionista.RecepcionistaFileImpl;
import com.pbl.sistema_gerenciamento.dao.tecnico.TecnicoDAO;
import com.pbl.sistema_gerenciamento.dao.tecnico.TecnicoFileImpl;

public class DAO {
    private static AdministradorDAO administradorDAO;
    private static ClienteDAO clienteDAO;
    private static ComponenteOutroDAO componenteOutroDAO;
    private static ComponentePCDAO componentePCDAO;
    private static InstalacaoDAO instalacaoDAO;
    private static LimpezaDAO limpezaDAO;
    private static MontagemDAO montagemDAO;
    private static OrdemServicoDAO ordemServicoDAO;
    private static RecepcionistaDAO recepcionistaDAO;
    private static TecnicoDAO tecnicoDAO;

    public static AdministradorDAO getAdministradorDAO() {
        if (administradorDAO == null){
            administradorDAO = new AdministradorFileImpl();
        }
        return administradorDAO;
    }

    public static ClienteDAO getClienteDAO() {
        if (clienteDAO ==  null){
            clienteDAO = new ClienteFileImpl();
        }
        return clienteDAO;
    }

    public static ComponenteOutroDAO getComponenteOutroDAO() {
        if (componenteOutroDAO == null){
            componenteOutroDAO =  new ComponenteOutroFileImpl();
        }
        return componenteOutroDAO;
    }

    public static ComponentePCDAO getComponentePCDAO() {
        if (componentePCDAO == null){
            componentePCDAO = new ComponentePCFileImpl();
        }
        return componentePCDAO;
    }

    public static InstalacaoDAO getInstalacaoDAO() {
        if (instalacaoDAO ==  null){
            instalacaoDAO =  new InstalacaoFileImpl();

        }
        return instalacaoDAO;
    }

    public static LimpezaDAO getLimpezaDAO() {
        if (limpezaDAO == null){
            limpezaDAO = new LimpezaFileImpl();
        }
        return limpezaDAO;
    }

    public static MontagemDAO getMontagemDAO() {
        if(montagemDAO == null){
            montagemDAO = new MontagemFileImpl();
        }
        return montagemDAO;
    }

    public static OrdemServicoDAO getOrdemServicoDAO() {
        if (ordemServicoDAO == null){
            ordemServicoDAO = new OrdemServicoFileImpl();
        }
        return ordemServicoDAO;
    }

    public static RecepcionistaDAO getRecepcionistaDAO() {
        if (recepcionistaDAO == null){
            recepcionistaDAO = new RecepcionistaFileImpl();
        }
        return recepcionistaDAO;
    }

    public static TecnicoDAO getTecnicoDAO() {
        if (tecnicoDAO == null){
            tecnicoDAO = new TecnicoFileImpl();
        }
        return tecnicoDAO;
    }
}
