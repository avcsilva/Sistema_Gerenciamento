package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Tecnico;
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

public class TecnicoController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private Label erro_msg;

    @FXML
    private TableColumn<Tecnico, String> tabelaEmails;

    @FXML
    private TableColumn<Tecnico, String> tabelaNomes;

    @FXML
    private TableView<Tecnico> tabelaTecnicos;

    @FXML
    private TextField tecnicoEmail;

    @FXML
    private TextField tecnicoNome;

    private ObservableList<Tecnico> tecnicosLista;

    @FXML
    void btnApgAction(ActionEvent event) {
        Tecnico tecnico = this.tabelaTecnicos.getSelectionModel().getSelectedItem();
        if (tecnico == null){
            this.erro_msg.setText("Selecione um técnico!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            DAO.getTecnicoDAO().deletar(tecnico.getId());
            this.erro_msg.setText("Técnico removido com sucesso!");
            this.erro_msg.setStyle("-fx-text-fill: green;");
            this.tecnicosLista.remove(tecnico);
        }
    }

    @FXML
    void btnAttAction(ActionEvent event) {
        Tecnico tecnico = this.tabelaTecnicos.getSelectionModel().getSelectedItem();
        if (tecnico == null){
            this.erro_msg.setText("Selecione um técnico!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            if (tecnicoNome.getText().isEmpty() || tecnicoEmail.getText().isEmpty()) {
                this.erro_msg.setText("Preencha todos os campos!");
                this.erro_msg.setStyle("-fx-text-fill: red;");
            } else{
                tecnico.setNome(tecnicoNome.getText());
                tecnico.setEmail(tecnicoEmail.getText());
                DAO.getTecnicoDAO().atualizar(tecnico);
                this.erro_msg.setText("Técnico atualizado com sucesso!");
                this.erro_msg.setStyle("-fx-text-fill: green;");
                this.tecnicosLista.set(this.tabelaTecnicos.getSelectionModel().getSelectedIndex(), tecnico);
                this.tecnicoNome.clear();
                this.tecnicoEmail.clear();
            }
        }
    }

    @FXML
    void btnCriaAction(ActionEvent event) {
        if (tecnicoNome.getText().isEmpty() || tecnicoEmail.getText().isEmpty()) {
            this.erro_msg.setText("Preencha todos os campos!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            Tecnico tecnico = new Tecnico(tecnicoNome.getText(), tecnicoEmail.getText());
            DAO.getTecnicoDAO().criar(tecnico);
            this.erro_msg.setText("Técnico criado com sucesso!");
            this.erro_msg.setStyle("-fx-text-fill: green;");
            this.tecnicosLista.add(tecnico);
            this.tecnicoNome.clear();
            this.tecnicoEmail.clear();
        }
    }

    @FXML
    void initialize() {
        this.tecnicosLista = FXCollections.observableArrayList(DAO.getTecnicoDAO().acharTodos());

        this.tabelaNomes.setCellValueFactory(new PropertyValueFactory<Tecnico, String>("nome"));
        this.tabelaEmails.setCellValueFactory(new PropertyValueFactory<Tecnico, String>("email"));

        this.tabelaTecnicos.setItems(tecnicosLista);
    }

}
