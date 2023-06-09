package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Instalacao;
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

public class InstalacaoController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private Label erro_msg;

    @FXML
    private TextField instalacaoPreco;

    @FXML
    private TextField instalacaoPrograma;

    @FXML
    private TextField instalacaoSO;

    @FXML
    private TableView<Instalacao> tabelaInstals;

    @FXML
    private TableColumn<Instalacao, Double> tabelaPrecos;

    @FXML
    private TableColumn<Instalacao, String> tabelaProgramas;

    @FXML
    private TableColumn<Instalacao, String> tabelaSO;

    private ObservableList<Instalacao> instalacaoList;

    @FXML
    void btnApgAction(ActionEvent event) {
        Instalacao instalacao = this.tabelaInstals.getSelectionModel().getSelectedItem();
        if(instalacao ==  null){
            this.erro_msg.setText("Instalação não selecionada");
        }else{
            this.instalacaoList.remove(instalacao);
            DAO.getInstalacaoDAO().deletar(instalacao.getId());
            this.erro_msg.setText("Instação removida com sucesso");
        }
    }

    @FXML
    void btnAttAction(ActionEvent event) {
        Instalacao instalacao = this.tabelaInstals.getSelectionModel().getSelectedItem();
        if(instalacao == null){
            this.erro_msg.setText("Instalação não selecionada");
        }else{
            if (this.instalacaoPreco.getText().isEmpty() || this.instalacaoSO.getText().isEmpty() || this.instalacaoPrograma.getText().isEmpty()) {
                try {
                    instalacao.setPreco(Double.parseDouble(this.instalacaoPreco.getText()));
                    instalacao.setPrograma(this.instalacaoPrograma.getText());
                    instalacao.setSistemaOperacional(this.instalacaoSO.getText());
                    DAO.getInstalacaoDAO().atualizar(instalacao);
                    this.instalacaoList.set(this.tabelaInstals.getSelectionModel().getSelectedIndex(), instalacao);
                    this.erro_msg.setText("Instalação atualizada com sucesso");
                    this.instalacaoSO.clear();
                    this.instalacaoPreco.clear();
                    this.instalacaoPrograma.clear();
                } catch (NumberFormatException e) {
                    this.erro_msg.setText("Preço inválido");
                }
            } else {
                this.erro_msg.setText("Preencha todos os campos");
            }
        }
    }

    @FXML
    void btnCriaAction(ActionEvent event) {
        if (this.instalacaoPreco.getText().isEmpty() || this.instalacaoSO.getText().isEmpty() || this.instalacaoPrograma.getText().isEmpty()){
            this.erro_msg.setText("Preencha todos os campos!");
        } else{
            try{
                Instalacao instalacao = new Instalacao(Double.parseDouble(this.instalacaoPreco.getText()));
                instalacao.setPrograma(this.instalacaoPrograma.getText());
                instalacao.setSistemaOperacional(this.instalacaoSO.getText());
                DAO.getInstalacaoDAO().criar(instalacao);
                this.instalacaoList.add(instalacao);
                this.erro_msg.setText("Instalação criada com sucesso!");
                this.instalacaoSO.clear();
                this.instalacaoPreco.clear();
                this.instalacaoPrograma.clear();
            } catch (NumberFormatException e){
                this.erro_msg.setText("Preço inválido!");
            }
        }
    }

    @FXML
    void initialize(){
        this.instalacaoList = FXCollections.observableArrayList(DAO.getInstalacaoDAO().acharTodos());

        this.tabelaPrecos.setCellValueFactory(new PropertyValueFactory<Instalacao, Double>("preco"));
        this.tabelaProgramas.setCellValueFactory(new PropertyValueFactory<Instalacao, String>("programa"));
        this.tabelaSO.setCellValueFactory(new PropertyValueFactory<Instalacao, String>("sistemaOperacional"));

        this.tabelaInstals.setItems(this.instalacaoList);
    }

}
