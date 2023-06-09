package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.HelloApplication;
import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Cliente;
import com.pbl.sistema_gerenciamento.model.OrdemServico;
import com.pbl.sistema_gerenciamento.model.Tecnico;
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

public class OrdemServicoController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnCriar;

    @FXML
    private TableColumn<OrdemServico, Integer> colunaId;

    @FXML
    private TableColumn<OrdemServico, Cliente> colunaNomeCliente;

    @FXML
    private TableColumn<OrdemServico, String> colunaDatac;

    @FXML
    private TableColumn<OrdemServico, String> colunaStatus;

    @FXML
    private TableColumn<OrdemServico, String> colunaDataf;

    @FXML
    private TableColumn<OrdemServico, Double> colunaPreco;

    @FXML
    private TableColumn<OrdemServico, Double> colunaCusto;

    @FXML
    private Label erro_msg;

    @FXML
    private TableView<OrdemServico> tabelaOrdens;

    private ObservableList<OrdemServico> ordensLista;

    @FXML
    void btnApgAction(ActionEvent event) {
        OrdemServico ordem = this.tabelaOrdens.getSelectionModel().getSelectedItem();
        if (ordem == null){
            this.erro_msg.setText("Selecione uma ordem de serviço!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            DAO.getOrdemServicoDAO().deletar(ordem.getId());
            this.ordensLista.remove(ordem);
            this.erro_msg.setText("Ordem de serviço removida com sucesso!");
            this.erro_msg.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    void btnCriarAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaGereOrdemServico.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = StageController.getStage(event);
            stage.setScene(scene);
            stage.setTitle("Gerenciar Ordem de Serviço");
            stage.setResizable(true);
            stage.centerOnScreen();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    void initialize(){
        this.ordensLista = FXCollections.observableArrayList(DAO.getOrdemServicoDAO().acharTodos());

        this.colunaId.setCellValueFactory(new PropertyValueFactory<OrdemServico, Integer>("id"));
        this.colunaNomeCliente.setCellValueFactory(new PropertyValueFactory<OrdemServico, Cliente>("clienteNome"));
        this.colunaDatac.setCellValueFactory(new PropertyValueFactory<OrdemServico, String>("criacao"));
        this.colunaStatus.setCellValueFactory(new PropertyValueFactory<OrdemServico, String>("status"));
        this.colunaDataf.setCellValueFactory(new PropertyValueFactory<OrdemServico, String>("finalizacao"));
        this.colunaPreco.setCellValueFactory(new PropertyValueFactory<OrdemServico, Double>("preco"));
        this.colunaCusto.setCellValueFactory(new PropertyValueFactory<OrdemServico, Double>("custo"));

        this.tabelaOrdens.setItems(this.ordensLista);
    }

}
