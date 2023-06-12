package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.model.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Label erro_msg;

    @FXML
    private Label ordemAssociada;

    private Tecnico tecnico;

    @FXML
    void btnFaturaAction(ActionEvent event) {

    }

    @FXML
    void btnGereClieAction(ActionEvent event) {

    }

    @FXML
    void btnGereCompcAction(ActionEvent event) {

    }

    @FXML
    void btnGereCompoutAction(ActionEvent event) {

    }

    @FXML
    void btnGereInstAction(ActionEvent event) {

    }

    @FXML
    void btnGereLimpAction(ActionEvent event) {

    }

    @FXML
    void btnGereMontAction(ActionEvent event) {

    }

    @FXML
    void btnGereOrdemAction(ActionEvent event) {

    }

    @FXML
    void btnPegaOrdAction(ActionEvent event) {

    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @FXML
    void initialize(){

    }
}
