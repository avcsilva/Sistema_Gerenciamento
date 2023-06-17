package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.OrdemServico;
import com.pbl.sistema_gerenciamento.model.Tecnico;
import com.pbl.sistema_gerenciamento.utils.StageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuTecnicoController {

    @FXML
    private Button btnFatura;

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
    private Button btnPegaOrd;

    @FXML
    private Button btnSair;

    @FXML
    private Label erro_msg;

    @FXML
    private Label ordemAssociada;

    @FXML
    private Label textNome;

    private Tecnico tecnico;

    @FXML
    void btnFaturaAction(ActionEvent event) {
        if (this.tecnico.getOrdemAssociada() == null){
            this.ordemAssociada.setText("Nenhuma");
            this.erro_msg.setText("Nenhuma ordem associada");
            this.erro_msg.setStyle("-fx-text-fill: red");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaFinalizaOrdem.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Finalização de ordem de serviço");
                stage.setResizable(true);
                stage.centerOnScreen();
                stage.initModality(Modality.APPLICATION_MODAL);

                FinalizaOrdemController controller = fxmlLoader.getController();
                controller.setTecnico(this.tecnico);
                controller.setDialogStage(stage);

                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
    void btnPegaOrdAction(ActionEvent event) {
        if (this.tecnico.getOrdemAssociada() != null){
            this.erro_msg.setText("Você já possui uma ordem associada!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        }
        else{
            OrdemServico ordem = DAO.getOrdemServicoDAO().proximaOrdem();
            if (ordem == null){
                this.ordemAssociada.setText("Nenhuma");
                this.erro_msg.setText("Não há ordens de serviço disponíveis!");
                this.erro_msg.setStyle("-fx-text-fill: red;");
            } else {
                ordem.setStatus("em andamento");
                ordem.setTecnico(this.tecnico);
                this.tecnico.setOrdemAssociada(ordem);
                DAO.getTecnicoDAO().atualizar(this.tecnico);
                DAO.getOrdemServicoDAO().atualizar(ordem);
                this.ordemAssociada.setText("ID da ordem de serviço associada: " + this.tecnico.getOrdemAssociada().getId());
                this.erro_msg.setText("ID da ordem associada com sucesso!");
                this.erro_msg.setStyle("-fx-text-fill: green;");
            }
        }
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
        this.textNome.setText(this.tecnico.getNome());
        if (this.tecnico.getOrdemAssociada() != null){
            this.ordemAssociada.setText("ID da ordem de serviço associada: " + this.tecnico.getOrdemAssociada().getId());
        } else{
            this.ordemAssociada.setText("Nenhuma");
        }
    }

    @FXML
    void initialize(){

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
