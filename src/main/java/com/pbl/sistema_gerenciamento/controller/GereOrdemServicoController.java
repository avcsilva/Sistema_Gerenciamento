package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.*;
import com.pbl.sistema_gerenciamento.utils.StageController;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GereOrdemServicoController {

    @FXML
    private Button btnAddCliente;

    @FXML
    private Button btnAddData;

    @FXML
    private Button btnAddInst;

    @FXML
    private Button btnAddLimp;

    @FXML
    private Button btnAddMont;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnRmvInst;

    @FXML
    private Button btnRmvLimp;

    @FXML
    private Button btnRmvMont;

    @FXML
    private ChoiceBox<Integer> choiceCliente;

    @FXML
    private ChoiceBox<Integer> choiceInst;

    @FXML
    private ChoiceBox<Integer> choiceLimp;

    @FXML
    private ChoiceBox<Integer> choiceMont;

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
    private OrdemServico ordemServico;

    @FXML
    void btnAddClienteAction(ActionEvent event) {
        Cliente cliente = DAO.getClienteDAO().acharPorId(this.choiceCliente.getSelectionModel().getSelectedItem());
        if (cliente == null){
            this.msg_erro.setText("Selecione um cliente");
            this.msg_erro.setStyle("-fx-text-fill: red");
        } else {
            this.ordemServico.setCliente(cliente);
            this.clienteDefinido.setText(cliente.getNome());
            this.msg_erro.setText("Cliente adicionado com sucesso!");
            this.msg_erro.setStyle("-fx-text-fill: green");
        }
    }

    @FXML
    void btnAddDataAction(ActionEvent event) {
        if (this.dataCria.getText().isEmpty()){
            this.msg_erro.setText("Insira uma data");
            this.msg_erro.setStyle("-fx-text-fill: red");
        } else {
            this.ordemServico.setCriacao(this.dataCria.getText());
            this.dataDefinida.setText(this.dataCria.getText());
            this.msg_erro.setText("Data adicionada com sucesso!");
            this.msg_erro.setStyle("-fx-text-fill: green");
        }
    }

    @FXML
    void btnAddInstAction(ActionEvent event) {
        Instalacao instalacao = DAO.getInstalacaoDAO().acharPorId(this.choiceInst.getSelectionModel().getSelectedItem());
        if (instalacao == null){
            this.msg_erro.setText("Selecione uma instalação");
            this.msg_erro.setStyle("-fx-text-fill: red");
        } else {
            this.instalacoes.add(instalacao);
            this.ordemServico.adicionaServico(instalacao);
            this.msg_erro.setText("Instalação adicionada com sucesso!");
            this.msg_erro.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    void btnAddLimpAction(ActionEvent event) {
        Limpeza limpeza = DAO.getLimpezaDAO().acharPorId(this.choiceLimp.getSelectionModel().getSelectedItem());
        if(limpeza == null){
            this.msg_erro.setText("Selecione uma limpeza");
            this.msg_erro.setStyle("-fx-text-fill: red;");
        } else {
            this.limpezas.add(limpeza);
            this.ordemServico.adicionaServico(limpeza);
            this.msg_erro.setText("Limpeza adicionada com sucesso!");
            this.msg_erro.setStyle("-fx-text-fill: green;");
        }

    }

    @FXML
    void btnAddMontAction(ActionEvent event) {
        Montagem montagem = DAO.getMontagemDAO().acharPorId(this.choiceMont.getSelectionModel().getSelectedItem());
        if (montagem == null){
            this.msg_erro.setText("Selecione uma montagem");
            this.msg_erro.setStyle("-fx-text-fill: red;");
        } else{
            this.montagens.add(montagem);
            this.ordemServico.adicionaServico(montagem);
            this.msg_erro.setText("Montagem adicionada com sucesso!");
            this.msg_erro.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    void btnConfirmAction(ActionEvent event) {
        if (this.clienteDefinido.getText().isEmpty() || this.dataDefinida.getText().isEmpty()){
            this.msg_erro.setText("Defina o cliente e a data da ordem de serviço");
            this.msg_erro.setStyle("-fx-text-fill: red;");
        } else {
            DAO.getOrdemServicoDAO().criar(this.ordemServico);
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaOrdemServico.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = StageController.getStage(event);
                stage.setScene(scene);
                stage.setTitle("Registro de ordem de serviço");
                stage.setResizable(true);
                stage.centerOnScreen();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnRmvInstAction(ActionEvent event) {
        Instalacao instalacao = this.tabelaInstalacao.getSelectionModel().getSelectedItem();
        if(instalacao == null){
            this.msg_erro.setText("Selecione uma instalação");
            this.msg_erro.setStyle("-fx-text-fill: red;");
        } else{
            this.instalacoes.remove(instalacao);
            this.ordemServico.removeServico(instalacao.getId(), 1);
            this.msg_erro.setText("Instalação removida com sucesso");
            this.msg_erro.setStyle("-fx-text-fill: green;");
        }

    }

    @FXML
    void btnRmvLimpAction(ActionEvent event) {
        Limpeza limpeza = this.tabelaLimpeza.getSelectionModel().getSelectedItem();
        if (limpeza == null){
            this.msg_erro.setText("Selecione uma limpeza");
        } else{
            this.limpezas.remove(limpeza);
            this.ordemServico.removeServico(limpeza.getId(), 2);
            this.msg_erro.setText("Limpeza removida com sucesso!");
        }
    }

    @FXML
    void btnRmvMontAction(ActionEvent event) {
        Montagem montagem = this.tabelaMontagem.getSelectionModel().getSelectedItem();
        if (montagem == null){
            this.msg_erro.setText("Selecione uma montagem");
        } else{
            this.montagens.remove(montagem);
            this.ordemServico.removeServico(montagem.getId(), 3);
            this.msg_erro.setText("Montagem removida com sucesso!");
        }
    }

    @FXML
    void initialize(){
        this.ordemServico = new OrdemServico(null, null);
        this.ordemServico.setStatus("em aberto");

        this.instalacoes = FXCollections.observableArrayList();
        this.limpezas = FXCollections.observableArrayList();
        this.montagens = FXCollections.observableArrayList();


        ArrayList<Integer> clienteIds = new ArrayList<Integer>();
        for(Cliente cliente : DAO.getClienteDAO().acharTodos()){
            clienteIds.add(cliente.getId());
        }
        choiceCliente.setItems(FXCollections.observableArrayList(clienteIds));

        ArrayList<Integer> instalacoesIds = new ArrayList<Integer>();
        for(Instalacao instalacao : DAO.getInstalacaoDAO().acharTodos()){
            instalacoesIds.add(instalacao.getId());
        }
        choiceInst.setItems(FXCollections.observableArrayList(instalacoesIds));

        ArrayList<Integer> limpezasIds = new ArrayList<Integer>();
        for(Limpeza limpeza : DAO.getLimpezaDAO().acharTodos()){
            limpezasIds.add(limpeza.getId());
        }
        choiceLimp.setItems(FXCollections.observableArrayList(limpezasIds));

        ArrayList<Integer> montagensIds = new ArrayList<Integer>();
        for(Montagem montagem : DAO.getMontagemDAO().acharTodos()){
            montagensIds.add(montagem.getId());
        }
        choiceMont.setItems(FXCollections.observableArrayList(montagensIds));


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
