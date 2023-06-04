package com.pbl.sistema_gerenciamento.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ClienteController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private TextField clienteEmail;

    @FXML
    private TextField clienteEndereco;

    @FXML
    private TextField clienteNome;

    @FXML
    private TextField clienteTelefone;

    @FXML
    private Label erro_msg;

    @FXML
    private TableColumn<?, ?> tabelaEmails;

    @FXML
    private TableColumn<?, ?> tabelaEnderecos;

    @FXML
    private TableColumn<?, ?> tabelaNomes;

    @FXML
    private TableColumn<?, ?> tabelaTelefones;

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
