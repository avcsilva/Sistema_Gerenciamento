module com.pbl.sistema_gerenciamento {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.pbl.sistema_gerenciamento.dao.montagem;
    opens com.pbl.sistema_gerenciamento.dao.instalacao;
    opens com.pbl.sistema_gerenciamento.dao.administrador;
    opens com.pbl.sistema_gerenciamento.dao.cliente;
    opens com.pbl.sistema_gerenciamento.dao.componenteoutro;
    opens com.pbl.sistema_gerenciamento.dao.limpeza;
    opens com.pbl.sistema_gerenciamento.dao.recepcionista;
    opens com.pbl.sistema_gerenciamento.dao.tecnico;
    opens com.pbl.sistema_gerenciamento.dao.ordemservico;
    opens com.pbl.sistema_gerenciamento.dao.componentepc;
    opens com.pbl.sistema_gerenciamento.model;

    opens com.pbl.sistema_gerenciamento to javafx.fxml;
    exports com.pbl.sistema_gerenciamento;
}