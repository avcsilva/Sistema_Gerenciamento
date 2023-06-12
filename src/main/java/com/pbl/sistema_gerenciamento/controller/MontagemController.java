package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Montagem;
import com.pbl.sistema_gerenciamento.utils.StageController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class MontagemController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnCriar;

    @FXML
    private Label erro_msg;

    @FXML
    private TableColumn<Montagem, Double> tabelaCustos;

    @FXML
    private TableView<Montagem> tabelaMontagens;

    @FXML
    private TableColumn<Montagem, Double> tabelaPrecos;

    private ObservableList<Montagem> montagemList;

    @FXML
    void btnApgAction(ActionEvent event) {
        Montagem montagem = this.tabelaMontagens.getSelectionModel().getSelectedItem();
        if(montagem ==  null){
            this.erro_msg.setText("Montagem não selecionada");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        }else{
            this.montagemList.remove(montagem);
            DAO.getMontagemDAO().deletar(montagem.getId());
            this.erro_msg.setText("Montagem removida com sucesso");
            this.erro_msg.setStyle("-fx-text-fill: green;");
        }

    }

    @FXML
    void btnCriarAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaGereMontagem.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = StageController.getStage(event);
            stage.setScene(scene);
            stage.setTitle("Gerenciar Montagem");
            stage.setResizable(true);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize(){
        this.montagemList = FXCollections.observableArrayList(DAO.getMontagemDAO().acharTodos());
        this.tabelaPrecos.setCellValueFactory(new PropertyValueFactory<Montagem, Double>("preco"));
        this.tabelaCustos.setCellValueFactory(new PropertyValueFactory<Montagem, Double>("custo"));
        this.tabelaMontagens.setItems(this.montagemList);
    }
}
