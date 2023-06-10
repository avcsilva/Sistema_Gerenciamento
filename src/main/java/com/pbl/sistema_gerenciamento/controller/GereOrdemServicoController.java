package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GereOrdemServicoController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnRmv;

    @FXML
    private ChoiceBox<Cliente> choiceCliente;

    @FXML
    private ChoiceBox<Instalacao> choiceInst;

    @FXML
    private ChoiceBox<Limpeza> choiceLimp;

    @FXML
    private ChoiceBox<Montagem> choiceMont;

    @FXML
    private Label clienteDefinido;

    @FXML
    private TableColumn<Instalacao, Double> colunaInstPreco;

    @FXML
    private TableColumn<Limpeza, Double> colunaLimpPreco;

    @FXML
    private TableColumn<Montagem, Double> colunaMontCusto;

    @FXML
    private TableColumn<Montagem, Double> colunaMontPreco;

    @FXML
    private TableColumn<Instalacao, String> colunaProgr;

    @FXML
    private TableColumn<Instalacao, String> colunaSO;

    @FXML
    private TextField dataCria;

    @FXML
    private Label dataDefinida;

    @FXML
    private Label msg_erro;

    @FXML
    private TableView<Instalacao> tabelaInstalacao;

    @FXML
    private TableView<Limpeza> tabelaLimpeza;

    @FXML
    private TableView<Montagem> tabelaMontagem;

    private ObservableList<Instalacao> instalacoes = FXCollections.observableArrayList();
    private ObservableList<Limpeza> limpezas = FXCollections.observableArrayList();
    private ObservableList<Montagem> montagens = FXCollections.observableArrayList();

    @FXML
    void btnAddAction(ActionEvent event) {

    }

    @FXML
    void btnConfirmAction(ActionEvent event) {
        
    }

    @FXML
    void btnRmvAction(ActionEvent event) {
    }

    @FXML
    void initialize(){
        OrdemServico ordemServico = new OrdemServico(null, null);

        this.instalacoes = FXCollections.observableArrayList();
        this.limpezas = FXCollections.observableArrayList();
        this.montagens = FXCollections.observableArrayList();

        ObservableList<Cliente> clientes = FXCollections.observableArrayList(DAO.getClienteDAO().acharTodos());
        choiceCliente.setItems(clientes);
        ObservableList<Instalacao> instalacoes = FXCollections.observableArrayList(DAO.getInstalacaoDAO().acharTodos());
        choiceInst.setItems(instalacoes);
        ObservableList<Limpeza> limpezas = FXCollections.observableArrayList(DAO.getLimpezaDAO().acharTodos());
        choiceLimp.setItems(limpezas);
        ObservableList<Montagem> montagens = FXCollections.observableArrayList(DAO.getMontagemDAO().acharTodos());
        choiceMont.setItems(montagens);

        this.colunaLimpPreco.setCellValueFactory(new PropertyValueFactory<Limpeza, Double>("preco"));
        this.colunaInstPreco.setCellValueFactory(new PropertyValueFactory<Instalacao, Double>("preco"));
        this.colunaMontCusto.setCellValueFactory(new PropertyValueFactory<Montagem, Double>("custo"));
        this.colunaMontPreco.setCellValueFactory(new PropertyValueFactory<Montagem, Double>("preco"));
        this.colunaProgr.setCellValueFactory(new PropertyValueFactory<Instalacao, String>("Programa"));
        this.colunaSO.setCellValueFactory(new PropertyValueFactory<Instalacao, String>("sistemaOperacional"));

        this.tabelaInstalacao.setItems(this.instalacoes);
        this.tabelaLimpeza.setItems(this.limpezas);
        this.tabelaMontagem.setItems(this.montagens);
    }

}
