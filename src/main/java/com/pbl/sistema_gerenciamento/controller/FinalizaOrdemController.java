package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.model.Tecnico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FinalizaOrdemController {

    @FXML
    private Button btnCancela;

    @FXML
    private Button btnFinaliza;

    @FXML
    private Label cliente;

    @FXML
    private Label custo;

    @FXML
    private Label datac;

    @FXML
    private TextField dataf;

    @FXML
    private Label id;

    @FXML
    private ChoiceBox<String> metPag;

    @FXML
    private Label preco;

    private Tecnico tecnico;

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @FXML
    void btnCancelaAction(ActionEvent event) {
    }

    @FXML
    void btnFinalizaAction(ActionEvent event) {

    }

    @FXML
    void initialize(){
        ObservableList<String> metodos = FXCollections.observableArrayList("Dinheiro", "Cartão de Crédito", "Cartão de Débito", "PIX");
        this.metPag.setItems(metodos);
    }

}
