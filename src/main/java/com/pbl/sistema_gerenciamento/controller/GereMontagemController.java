package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.ComponenteOutro;
import com.pbl.sistema_gerenciamento.model.ComponentePC;
import com.pbl.sistema_gerenciamento.model.Montagem;
import com.pbl.sistema_gerenciamento.utils.StageController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class GereMontagemController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnRmv;

    @FXML
    private ChoiceBox<ComponenteOutro> choiceCompOutr;

    @FXML
    private ChoiceBox<ComponentePC> choiceCompPC;

    @FXML
    private Label erro_msg;

    @FXML
    private TableView<ComponenteOutro> tabelaCompsOut;

    @FXML
    private TableView<ComponentePC> tabelaCompsPC;

    @FXML
    private TableColumn<ComponenteOutro, Double> tabelaOutroCusto;

    @FXML
    private TableColumn<ComponenteOutro, String> tabelaOutroDescricao;

    @FXML
    private TableColumn<ComponenteOutro, String> tabelaOutroPreco;

    @FXML
    private TableColumn<ComponentePC, Double> tabelaPcCusto;

    @FXML
    private TableColumn<ComponentePC, Double> tabelaPcFabricante;

    @FXML
    private TableColumn<ComponentePC, String > tabelaPcNome;

    @FXML
    private TableColumn<ComponentePC, Double> tabelaPcPreco;

    private ObservableList<ComponenteOutro> compsOutLista;

    private ObservableList<ComponentePC> compsPCLista;

    private Montagem montagem;

    @FXML
    void btnAddAction(ActionEvent event) {
        ComponenteOutro compOut = this.choiceCompOutr.getSelectionModel().getSelectedItem();
        ComponentePC compPC = this.choiceCompPC.getSelectionModel().getSelectedItem();
        if(compOut == null && compPC == null){
            this.erro_msg.setText("Componente não selecionado");
            this.erro_msg.setStyle("-fx-text-fill: red");
        }else{
            this.montagem.adicionarComponente(compOut);
            this.compsOutLista.add(compOut);
            this.montagem.adicionarComponente(compPC);
            this.compsPCLista.add(compPC);
            this.erro_msg.setText("Componente adicionado com sucesso");
            this.erro_msg.setStyle("-fx-text-fill: green");
        }
    }

    @FXML
    void btnConfirmAction(ActionEvent event) {
        try {
            DAO.getMontagemDAO().criar(this.montagem);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaMontagem.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = StageController.getStage(event);
            stage.setScene(scene);
            stage.setTitle("Registro de montagem");
            stage.setResizable(true);
            stage.centerOnScreen();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnRmvAction(ActionEvent event) {
        ComponenteOutro compOut = this.tabelaCompsOut.getSelectionModel().getSelectedItem();
        ComponentePC compPC = this.tabelaCompsPC.getSelectionModel().getSelectedItem();
        if (compOut == null && compPC == null) {
            this.erro_msg.setText("Componente não selecionado");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else {
            if (compOut != null && compPC != null) {
                this.montagem.removerComponente(compOut.getId(), 2);
                this.compsOutLista.remove(compOut);
                this.montagem.removerComponente(compPC.getId(), 1);
                this.compsPCLista.remove(compPC);
                this.erro_msg.setText("Componente removido com sucesso");
                this.erro_msg.setStyle("-fx-text-fill: green;");
            } else if (compOut != null) {
                this.montagem.removerComponente(compOut.getId(), 2);
                this.compsOutLista.remove(compOut);
                this.erro_msg.setText("Componente removido com sucesso");
                this.erro_msg.setStyle("-fx-text-fill: green;");
            } else {
                this.montagem.removerComponente(compPC.getId(), 1);
                this.compsPCLista.remove(compPC);
                this.erro_msg.setText("Componente removido com sucesso");
                this.erro_msg.setStyle("-fx-text-fill: green;");
            }
        }
    }

    @FXML
    void initialize(){
        this.montagem = new Montagem();
        this.compsOutLista = FXCollections.observableArrayList();
        this.compsPCLista = FXCollections.observableArrayList();

        ObservableList<ComponenteOutro> compoutList = FXCollections.observableArrayList(DAO.getComponenteOutroDAO().acharTodos());
        ObservableList<ComponentePC> comppcList = FXCollections.observableArrayList(DAO.getComponentePCDAO().acharTodos());

        this.choiceCompOutr.setItems(compoutList);
        this.choiceCompPC.setItems(comppcList);

        this.tabelaOutroCusto.setCellValueFactory(new PropertyValueFactory<ComponenteOutro, Double>("custo"));
        this.tabelaOutroPreco.setCellValueFactory(new PropertyValueFactory<ComponenteOutro, String>("preco"));
        this.tabelaOutroDescricao.setCellValueFactory(new PropertyValueFactory<ComponenteOutro, String>("descricao"));

        this.tabelaPcNome.setCellValueFactory(new PropertyValueFactory<ComponentePC, String>("nome"));
        this.tabelaPcFabricante.setCellValueFactory(new PropertyValueFactory<ComponentePC, Double>("fabricante"));
        this.tabelaPcPreco.setCellValueFactory(new PropertyValueFactory<ComponentePC, Double>("preco"));
        this.tabelaPcCusto.setCellValueFactory(new PropertyValueFactory<ComponentePC, Double>("custo"));

        this.tabelaCompsOut.setItems(this.compsOutLista);
        this.tabelaCompsPC.setItems(this.compsPCLista);
    }

}
