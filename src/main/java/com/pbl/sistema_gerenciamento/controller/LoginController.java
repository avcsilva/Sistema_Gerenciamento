package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.utils.StageController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnConfirma;

    @FXML
    private Label erro_msg;

    @FXML
    private TextField loginBox;

    @FXML
    private TextField senhaBox;

    @FXML
    private ComboBox<String> tipoUsuario;

    @FXML
    void btnConfirmaAction(ActionEvent event) {
        if (loginBox.getText().isEmpty() && senhaBox.getText().isEmpty()) {
            this.erro_msg.setText("Login e senha não podem ser vazios");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ALGUMAJANELAQUIPORFAVOR.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = StageController.getStage(event);
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void initialize(){
        ObservableList<String> tipos = FXCollections.observableArrayList("Administrador","Técnico", "Recepcionista");
        this.tipoUsuario.setItems(tipos);
    }
}
