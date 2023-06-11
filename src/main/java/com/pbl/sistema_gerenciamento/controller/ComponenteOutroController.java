package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.ComponenteOutro;
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

public class ComponenteOutroController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private TextField componenteoutroCusto;

    @FXML
    private TextField componenteoutroDescricao;

    @FXML
    private TextField componenteoutroPreco;

    @FXML
    private Label erro_msg;

    @FXML
    private TableView<ComponenteOutro> tabelaCompOut;

    @FXML
    private TableColumn<ComponenteOutro, Double> tabelaCustos;

    @FXML
    private TableColumn<ComponenteOutro, String> tabelaDescricoes;

    @FXML
    private TableColumn<ComponenteOutro, Double> tabelaPrecos;

    private ObservableList<ComponenteOutro> componentesoutrosLista;

    @FXML
    void btnApgAction(ActionEvent event) {
ComponenteOutro componenteOutro = tabelaCompOut.getSelectionModel().getSelectedItem();
        if (componenteOutro == null){
            this.erro_msg.setText("Selecione um componente!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            DAO.getComponenteOutroDAO().deletar(componenteOutro.getId());
            this.componentesoutrosLista.remove(componenteOutro);
            this.erro_msg.setText("Componente removido com sucesso!");
            this.erro_msg.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    void btnAttAction(ActionEvent event) {
        ComponenteOutro componenteOutro = tabelaCompOut.getSelectionModel().getSelectedItem();
        if (componenteOutro == null){
            this.erro_msg.setText("Selecione um componente!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            if (componenteoutroCusto.getText().isEmpty() || componenteoutroDescricao.getText().isEmpty() || componenteoutroPreco.getText().isEmpty()){
                erro_msg.setText("Preencha todos os campos!");
            } else{
                try{
                    Double custo = Double.parseDouble(componenteoutroCusto.getText());
                    Double preco = Double.parseDouble(componenteoutroPreco.getText());
                    componenteOutro.setCusto(custo);
                    componenteOutro.setPreco(preco);
                    componenteOutro.setDescricao(componenteoutroDescricao.getText());
                    DAO.getComponenteOutroDAO().atualizar(componenteOutro);
                    this.componentesoutrosLista.set(this.tabelaCompOut.getSelectionModel().getSelectedIndex(), componenteOutro);
                    erro_msg.setText("Componente atualizado com sucesso!");
                    this.erro_msg.setStyle("-fx-text-fill: green;");
                    this.componenteoutroCusto.clear();
                    this.componenteoutroDescricao.clear();
                    this.componenteoutroPreco.clear();
                } catch (NumberFormatException e){
                    erro_msg.setText("Preencha os campos corretamente!");
                    this.erro_msg.setStyle("-fx-text-fill: red;");
                }
            }
        }
    }

    @FXML
    void btnCriaAction(ActionEvent event) {
        if (componenteoutroCusto.getText().isEmpty() || componenteoutroDescricao.getText().isEmpty() || componenteoutroPreco.getText().isEmpty()){
            erro_msg.setText("Preencha todos os campos!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            try{
                Double custo = Double.parseDouble(componenteoutroCusto.getText());
                Double preco = Double.parseDouble(componenteoutroPreco.getText());
                ComponenteOutro componenteOutro = new ComponenteOutro(preco, custo, componenteoutroDescricao.getText());
                DAO.getComponenteOutroDAO().criar(componenteOutro);
                this.componentesoutrosLista.add(componenteOutro);
                erro_msg.setText("Componente criado com sucesso!");
                this.erro_msg.setStyle("-fx-text-fill: green;");
            } catch (NumberFormatException e){
                erro_msg.setText("Preencha os campos corretamente!");
                this.erro_msg.setStyle("-fx-text-fill: red;");
            }
        }
    }

    @FXML
    void initialize(){
        this.componentesoutrosLista = FXCollections.observableArrayList(DAO.getComponenteOutroDAO().acharTodos());

        this.tabelaCustos.setCellValueFactory(new PropertyValueFactory<ComponenteOutro, Double>("custo"));
        this.tabelaDescricoes.setCellValueFactory(new PropertyValueFactory<ComponenteOutro, String>("descricao"));
        this.tabelaPrecos.setCellValueFactory(new PropertyValueFactory<ComponenteOutro, Double>("preco"));

        this.tabelaCompOut.setItems(componentesoutrosLista);
    }

}
