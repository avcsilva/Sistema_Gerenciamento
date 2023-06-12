package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.utils.StageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField loginBox;

    @FXML
    private TextField senhaBox;

    @FXML
    private ComboBox<?> tipoUsuario;

    @FXML
    void initialize(){
        if (loginBox.getText().isEmpty() && senhaBox.getText().isEmpty()) {
            this.erro.setText("Login e senha não podem ser vazios");
            this.erro.setStyle("-fx-text-fill: red;");
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
}
