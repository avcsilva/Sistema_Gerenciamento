package com.pbl.sistema_gerenciamento.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RecepcionistaController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private Label erro_msg;

    @FXML
    private TextField recepcionistaEmail;

    @FXML
    private TextField recepcionistaNome;

    @FXML
    private TableColumn<?, ?> tabelaEmails;

    @FXML
    private TableColumn<?, ?> tabelaNomes;

    @FXML
    private TableView<?> tabelaReceps;

    @FXML
    void btnApgAction(ActionEvent event) {

    }

    @FXML
    void btnAttAction(ActionEvent event) {

    }

    @FXML
    void btnCriaAction(ActionEvent event) {

    }

}
