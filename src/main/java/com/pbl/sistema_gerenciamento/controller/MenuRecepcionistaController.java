package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.model.Recepcionista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuRecepcionistaController {

    @FXML
    private Button btnGereClie;

    @FXML
    private Button btnGereInst;

    @FXML
    private Button btnGereLimp;

    @FXML
    private Button btnGereMont;

    @FXML
    private Button btnGereOrdem;

    private Recepcionista recepcionista;

    @FXML
    void btnGereClieAction(ActionEvent event) {

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

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    @FXML
    void initialize(){

    }
}
