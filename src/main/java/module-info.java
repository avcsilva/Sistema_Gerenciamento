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

    opens com.pbl.sistema_gerenciamento to javafx.fxml, javafx.graphics, javafx.base;
    opens com.pbl.sistema_gerenciamento.controller to javafx.fxml, javafx.graphics, javafx.base;
    opens com.pbl.sistema_gerenciamento.model to javafx.fxml, javafx.graphics, javafx.base;
    exports com.pbl.sistema_gerenciamento;
}