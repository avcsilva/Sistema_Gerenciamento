package com.pbl.sistema_gerenciamento.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ComponentePCController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private TextField componentepcCusto;

    @FXML
    private TextField componentepcFabricante;

    @FXML
    private TextField componentepcNome;

    @FXML
    private TextField componentepcPreco;

    @FXML
    private Label erro_msg;

    @FXML
    private TableView<?> tabelaCompPC;

    @FXML
    private TableColumn<?, ?> tabelaCustos;

    @FXML
    private TableColumn<?, ?> tabelaFabricantes;

    @FXML
    private TableColumn<?, ?> tabelaNomes;

    @FXML
    private TableColumn<?, ?> tabelaPrecos;

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
