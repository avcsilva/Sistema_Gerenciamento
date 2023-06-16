package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.utils.StageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdmController {

    @FXML
    private Button btnGereClie;

    @FXML
    private Button btnGereCompc;

    @FXML
    private Button btnGereCompout;

    @FXML
    private Button btnGereInst;

    @FXML
    private Button btnGereLimp;

    @FXML
    private Button btnGereMont;

    @FXML
    private Button btnGereOrdem;

    @FXML
    private Button btnGereRecep;

    @FXML
    private Button btnGereTecn;

    @FXML
    private Button btnSair;

    @FXML
    void btnGereClieAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaCliente.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de cliente");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnGereCompcAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaComponentePC.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de componente PC");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnGereCompoutAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaComponenteOutro.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de componente outro");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnGereInstAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaInstalacao.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de instalação");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnGereLimpAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaLimpeza.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de limpeza");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnGereMontAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaMontagem.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de montagem");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnGereOrdemAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaOrdemServico.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de ordem de serviço");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnGereRecepAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaRecepcionista.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de recepcionista");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnGereTecnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaTecnico.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de técnico");
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnVoltarPagina(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = StageController.getStage(event);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
