package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Cliente;
import com.pbl.sistema_gerenciamento.model.OrdemServico;
import com.pbl.sistema_gerenciamento.model.Tecnico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<OrdemServico, Tecnico> colunaNomeTecnico;

    @FXML
    private TableColumn<OrdemServico, String> colunaStatus;

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
        } else{
            DAO.getOrdemServicoDAO().deletar(ordem.getId());
            this.ordensLista.remove(ordem);
            this.erro_msg.setText("Ordem de serviço removida com sucesso!");
        }
    }

    @FXML
    void btnCriarAction(ActionEvent event) {

    }

    @FXML
    void initialize(){
        this.ordensLista = FXCollections.observableArrayList(DAO.getOrdemServicoDAO().acharTodos());
        this.colunaId.setCellValueFactory(new PropertyValueFactory<OrdemServico, Integer>("id"));
        this.colunaNomeCliente.setCellValueFactory(new PropertyValueFactory<OrdemServico, Cliente>("cliente"));
        this.colunaNomeTecnico.setCellValueFactory(new PropertyValueFactory<OrdemServico, Tecnico>("tecnico"));
        this.colunaStatus.setCellValueFactory(new PropertyValueFactory<OrdemServico, String>("status"));
        this.tabelaOrdens.setItems(this.ordensLista);
    }

}
