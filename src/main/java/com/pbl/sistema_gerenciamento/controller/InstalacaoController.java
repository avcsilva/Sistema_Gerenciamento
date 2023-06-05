package com.pbl.sistema_gerenciamento.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InstalacaoController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private Label erro_msg;

    @FXML
    private TextField instalacaoPreco;

    @FXML
    private TextField instalacaoPrograma;

    @FXML
    private TextField instalacaoSO;

    @FXML
    private TableView<?> tabelaInstals;

    @FXML
    private TableColumn<?, ?> tabelaPrecos;

    @FXML
    private TableColumn<?, ?> tabelaProgramas;

    @FXML
    private TableColumn<?, ?> tabelaSO;

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
