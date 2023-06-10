package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Montagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        }else{
            this.montagemList.remove(montagem);
            DAO.getInstalacaoDAO().deletar(montagem.getId());
            this.erro_msg.setText("Montagem removida com sucesso");
        }

    }

    @FXML
    void btnCriarAction(ActionEvent event) {

    }

    @FXML
    void initialize(){
        this.montagemList = FXCollections.observableArrayList();
        
          this.tabelaPrecos.setCellValueFactory(new PropertyValueFactory<Montagem, Double>("preco"));
          this.tabelaCustos.setCellValueFactory(new PropertyValueFactory<Montagem, Double>("custo"));

          this.tabelaMontagens.setItems(this.montagemList);
    }
}
