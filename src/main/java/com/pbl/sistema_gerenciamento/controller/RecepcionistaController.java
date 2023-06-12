package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Recepcionista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField senha;

    @FXML
    private TableColumn<Recepcionista, Integer> tabelaIds;

    @FXML
    private TableColumn<Recepcionista, String> tabelaSenhas;

    @FXML
    private TableColumn<Recepcionista, String> tabelaEmails;

    @FXML
    private TableColumn<Recepcionista, String> tabelaNomes;

    @FXML
    private TableView<Recepcionista> tabelaReceps;

    private ObservableList<Recepcionista> recepsLista;

    @FXML
    void btnApgAction(ActionEvent event) {
        Recepcionista recep = tabelaReceps.getSelectionModel().getSelectedItem();
        if (recep == null){
            this.erro_msg.setText("Selecione um recepcionista!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            DAO.getRecepcionistaDAO().deletar(recep.getId());
            this.recepsLista.remove(recep);
            this.erro_msg.setText("Recepcionista removido com sucesso!");
            this.erro_msg.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    void btnAttAction(ActionEvent event) {
        Recepcionista recep = tabelaReceps.getSelectionModel().getSelectedItem();
        if (recep == null){
            this.erro_msg.setText("Selecione um recepcionista!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            recep.setEmail(recepcionistaEmail.getText());
            recep.setNome(recepcionistaNome.getText());
            recep.setSenha(senha.getText());
            DAO.getRecepcionistaDAO().atualizar(recep);
            this.recepsLista.set(this.tabelaReceps.getSelectionModel().getSelectedIndex(), recep);
            this.erro_msg.setText("Recepcionista atualizado com sucesso!");
            this.erro_msg.setStyle("-fx-text-fill: green;");
            recepcionistaNome.clear();
            recepcionistaEmail.clear();
            senha.clear();
        }
    }

    @FXML
    void btnCriaAction(ActionEvent event) {
        if (recepcionistaNome.getText().isEmpty() || recepcionistaEmail.getText().isEmpty() || senha.getText().isEmpty()) {
            erro_msg.setText("Preencha todos os campos!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else {
            Recepcionista recep = new Recepcionista(recepcionistaNome.getText(), recepcionistaEmail.getText(), senha.getText());
            DAO.getRecepcionistaDAO().criar(recep);
            this.erro_msg.setText("Recepcionista criado com sucesso!");
            this.erro_msg.setStyle("-fx-text-fill: green;");
            recepsLista.add(recep);
            recepcionistaNome.clear();
            recepcionistaEmail.clear();
            senha.clear();
        }
    }

    @FXML
    void initialize(){
        this.recepsLista = FXCollections.observableArrayList(DAO.getRecepcionistaDAO().acharTodos());

        this.tabelaNomes.setCellValueFactory(new PropertyValueFactory<Recepcionista, String>("nome"));
        this.tabelaEmails.setCellValueFactory(new PropertyValueFactory<Recepcionista, String>("email"));
        this.tabelaSenhas.setCellValueFactory(new PropertyValueFactory<Recepcionista, String>("senha"));
        this.tabelaIds.setCellValueFactory(new PropertyValueFactory<Recepcionista, Integer>("id"));

        this.tabelaReceps.setItems(recepsLista);
    }
}
