package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.ComponenteOutro;
import com.pbl.sistema_gerenciamento.model.ComponentePC;
import com.pbl.sistema_gerenciamento.model.Montagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @FXML
    private ObservableList<ComponenteOutro> compsOutLista;

    @FXML
    private ObservableList<ComponentePC> compsPCLista;

    @FXML
    private Montagem montagem;

    @FXML
    void btnAddAction(ActionEvent event) {
        ComponenteOutro compOut = this.choiceCompOutr.getSelectionModel().getSelectedItem();
        ComponentePC compPC = this.choiceCompPC.getSelectionModel().getSelectedItem();
        if(compOut == null && compPC == null){
            this.erro_msg.setText("Componente não selecionado");
        }else{
            this.montagem.adicionarComponente(compOut);
            this.compsOutLista.add(compOut);
            this.montagem.adicionarComponente(compPC);
            this.compsPCLista.add(compPC);
            this.erro_msg.setText("Componente adicionado com sucesso");
        }
    }

    @FXML
    void btnConfirmAction(ActionEvent event) {
        DAO.getMontagemDAO().criar(this.montagem);
        //Mudar de volta para janela do MontagemController
    }

    @FXML
    void btnRmvAction(ActionEvent event) {
        ComponenteOutro compOut = this.tabelaCompsOut.getSelectionModel().getSelectedItem();
        ComponentePC compPC = this.tabelaCompsPC.getSelectionModel().getSelectedItem();
        if (compOut == null && compPC == null) {
            this.erro_msg.setText("Componente não selecionado");
        } else {
            if (compOut != null && compPC != null) {
                this.montagem.removerComponente(compOut.getId(), 2);
                this.compsOutLista.remove(compOut);
                this.montagem.removerComponente(compPC.getId(), 1);
                this.compsPCLista.remove(compPC);
                this.erro_msg.setText("Componente removido com sucesso");
            } else if (compOut != null) {
                this.montagem.removerComponente(compOut.getId(), 2);
                this.compsOutLista.remove(compOut);
                this.erro_msg.setText("Componente removido com sucesso");
            } else {
                this.montagem.removerComponente(compPC.getId(), 1);
                this.compsPCLista.remove(compPC);
                this.erro_msg.setText("Componente removido com sucesso");
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
