package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.ComponentePC;
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

public class ComponentePCController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private TextField componentepcCusto;

    @FXML
    private TextField componentepcFabricante;

    @FXML
    private TextField componentepcNome;

    @FXML
    private TextField componentepcPreco;

    @FXML
    private Label erro_msg;

    @FXML
    private TableView<ComponentePC> tabelaCompPC;

    @FXML
    private TableColumn<ComponentePC, Double> tabelaCustos;

    @FXML
    private TableColumn<ComponentePC, String> tabelaFabricantes;

    @FXML
    private TableColumn<ComponentePC, String> tabelaNomes;

    @FXML
    private TableColumn<ComponentePC, Double> tabelaPrecos;

    @FXML
    private TableColumn<ComponentePC, Integer> tabelaIds;

    private ObservableList<ComponentePC> componentespcLista;

    @FXML
    void btnApgAction(ActionEvent event) {
        ComponentePC componentePC = this.tabelaCompPC.getSelectionModel().getSelectedItem();
        if(componentePC == null) {
            this.erro_msg.setText("Componente não selecionado!");
            this.erro_msg.setStyle("-fx-text-fill: red");
        }else{
            this.componentespcLista.remove(componentePC);
            DAO.getClienteDAO().deletar(componentePC.getId());
            this.erro_msg.setText("Componente deletado com sucesso!");
            this.erro_msg.setStyle("-fx-text-fill: green");
        }

    }

    @FXML
    void btnAttAction(ActionEvent event) {
        ComponentePC componentePC = this.tabelaCompPC.getSelectionModel().getSelectedItem();
        if (componentePC == null){
            this.erro_msg.setText("Selecione um componente!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            if (this.componentepcNome.getText().isEmpty() || this.componentepcCusto.getText().isEmpty() || this.componentepcPreco.getText().isEmpty() || this.componentepcFabricante.getText().isEmpty()){
                this.erro_msg.setText("Preencha todos os campos!");
                this.erro_msg.setStyle("-fx-text-fill: red;");
            } else{
                try {
                    componentePC.setNome(this.componentepcNome.getText());
                    componentePC.setCusto(Double.parseDouble(this.componentepcCusto.getText()));
                    componentePC.setPreco(Double.parseDouble(this.componentepcPreco.getText()));
                    componentePC.setFabricante(this.componentepcFabricante.getText());
                    DAO.getComponentePCDAO().atualizar(componentePC);
                    this.componentespcLista.set(this.tabelaCompPC.getSelectionModel().getSelectedIndex(), componentePC);
                    this.erro_msg.setText("ComponentePC atualizado com sucesso!");
                    this.erro_msg.setStyle("-fx-text-fill: green;");
                } catch (NumberFormatException e){
                    this.erro_msg.setText("Preço e custo devem ser números!");
                    this.erro_msg.setStyle("-fx-text-fill: red;");
                }
            }
        }
    }

    @FXML
    void btnCriaAction(ActionEvent event) {
        if (this.componentepcNome.getText().isEmpty() || this.componentepcFabricante.getText().isEmpty() || this.componentepcPreco.getText().isEmpty() || this.componentepcCusto.getText().isEmpty()){
            this.erro_msg.setText("Preencha todos os campos!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            try {
                ComponentePC componentePC = new ComponentePC(Double.parseDouble(this.componentepcPreco.getText()), Double.parseDouble(this.componentepcCusto.getText()), this.componentepcNome.getText(), this.componentepcFabricante.getText());
                DAO.getComponentePCDAO().criar(componentePC);
                this.componentespcLista.add(componentePC);
                this.erro_msg.setText("ComponentePC criado com sucesso!");
                this.erro_msg.setStyle("-fx-text-fill: green;");
            } catch (NumberFormatException e){
                this.erro_msg.setText("Preço e custo devem ser números!");
                this.erro_msg.setStyle("-fx-text-fill: red;");
            }
        }
    }

    @FXML
    void initialize() {
        this.componentespcLista = FXCollections.observableArrayList(DAO.getComponentePCDAO().acharTodos());

        this.tabelaNomes.setCellValueFactory(new PropertyValueFactory<ComponentePC, String>("nome"));
        this.tabelaFabricantes.setCellValueFactory(new PropertyValueFactory<ComponentePC, String>("fabricante"));
        this.tabelaPrecos.setCellValueFactory(new PropertyValueFactory<ComponentePC, Double>("preco"));
        this.tabelaCustos.setCellValueFactory(new PropertyValueFactory<ComponentePC, Double>("custo"));
        this.tabelaIds.setCellValueFactory(new PropertyValueFactory<ComponentePC, Integer>("id"));

        this.tabelaCompPC.setItems(componentespcLista);
    }
}













