package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Administrador;
import com.pbl.sistema_gerenciamento.model.Recepcionista;
import com.pbl.sistema_gerenciamento.model.Tecnico;
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
        if (this.tipoUsuario.getSelectionModel().getSelectedItem() == null){
            this.erro_msg.setText("Selecione um tipo de usuário!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else {
            if (loginBox.getText().isEmpty() && senhaBox.getText().isEmpty()) {
                this.erro_msg.setText("Login e senha não podem ser vazios");
                this.erro_msg.setStyle("-fx-text-fill: red;");
            } else {
                if (this.tipoUsuario.getSelectionModel().getSelectedItem().equals("Administrador")){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaMenuAdm.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage = StageController.getStage(event);
                        stage.setScene(scene);
                        stage.setTitle("Menu Administrador");
                        stage.setResizable(false);
                        stage.centerOnScreen();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (this.tipoUsuario.getSelectionModel().getSelectedItem().equals("Técnico")){
                    Tecnico tecn = DAO.getTecnicoDAO().acharPorId(Integer.parseInt(loginBox.getText()));
                    if (tecn == null){
                        this.erro_msg.setText("Técnico não encontrado!");
                        this.erro_msg.setStyle("-fx-text-fill: red;");
                    }
                    else {
                        if (!tecn.getSenha().equals(senhaBox.getText())){
                            this.erro_msg.setText("Senha incorreta!");
                            this.erro_msg.setStyle("-fx-text-fill: red;");
                        }
                        else {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaMenuTecnico.fxml"));
                                Scene scene = new Scene(fxmlLoader.load());
                                Stage stage = StageController.getStage(event);
                                stage.setScene(scene);
                                stage.setTitle("Menu Técnico");
                                stage.setResizable(false);
                                stage.centerOnScreen();

                                MenuTecnicoController controller = fxmlLoader.getController();
                                controller.setTecnico(tecn);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else{
                    Recepcionista recep = DAO.getRecepcionistaDAO().acharPorId(Integer.parseInt(loginBox.getText()));
                    if (recep == null){
                        this.erro_msg.setText("Recepcionista não encontrado!");
                        this.erro_msg.setStyle("-fx-text-fill: red;");
                    } else {
                        if (!recep.getSenha().equals(senhaBox.getText())){
                            this.erro_msg.setText("Senha incorreta!");
                            this.erro_msg.setStyle("-fx-text-fill: red;");
                        } else {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaMenuRecepcionista.fxml"));
                                Scene scene = new Scene(fxmlLoader.load());
                                Stage stage = StageController.getStage(event);
                                stage.setScene(scene);
                                stage.setTitle("Menu Recepcionista");
                                stage.setResizable(false);
                                stage.centerOnScreen();

                                MenuRecepcionistaController controller = fxmlLoader.getController();
                                controller.setRecepcionista(recep);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @FXML
    void initialize(){
        ObservableList<String> tipos = FXCollections.observableArrayList("Administrador","Técnico", "Recepcionista");
        this.tipoUsuario.setItems(tipos);
    }
}
