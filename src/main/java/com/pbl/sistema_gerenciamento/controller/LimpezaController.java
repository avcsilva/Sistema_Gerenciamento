package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Limpeza;
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

public class LimpezaController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private Label erro_msg;

    @FXML
    private TextField limpezaPreco;

    @FXML
    private TableView<Limpeza> tabelaLimpeza;

    @FXML
    private TableColumn<Limpeza, Double> tabelaPrecos;

    @FXML
    private ObservableList<Limpeza> limpezaList;

    @FXML
    void btnApgAction(ActionEvent event) {
        Limpeza limpeza = this.tabelaLimpeza.getSelectionModel().getSelectedItem();
        if(limpeza ==  null){
            this.erro_msg.setText("Limpeza não selecionada");
        }else{
            this.limpezaList.remove(limpeza);
            DAO.getInstalacaoDAO().deletar(limpeza.getId());
            this.erro_msg.setText("Limpeza removida com sucesso");
        }

    }

    @FXML
    void btnAttAction(ActionEvent event) {
        Limpeza limpeza = this.tabelaLimpeza.getSelectionModel().getSelectedItem();
        if(limpeza == null){
            this.erro_msg.setText("Limpeza não selecionada");
        }else{
            if(this.limpezaPreco.getText().isEmpty()) {
                try{
                    limpeza.setPreco(Double.parseDouble(this.limpezaPreco.getText()));
                    DAO.getLimpezaDAO().atualizar(limpeza);
                    this.erro_msg.setText("Limpeza atualizada com sucesso");
                    this.limpezaPreco.clear();

                }catch (NumberFormatException e){
                    this.erro_msg.setText("Preço inválido");
                }
            }
        }
    }

    @FXML
    void btnCriaAction(ActionEvent event) {
        if (this.limpezaPreco.getText().isEmpty()) {
            this.erro_msg.setText("Campo Preço vazio");
        } else{
            try{
                Limpeza limpeza = new Limpeza(Double.parseDouble(this.limpezaPreco.getText()));
                DAO.getLimpezaDAO().criar(limpeza);
                this.limpezaList.add(limpeza);
                this.erro_msg.setText("Limpeza criada com sucesso");
                this.limpezaPreco.clear();
            } catch (NumberFormatException e){
                this.erro_msg.setText("Preço inválido");
            }
        }
    }

    @FXML
    void initialize(){
        this.limpezaList = FXCollections.observableArrayList(DAO.getLimpezaDAO().acharTodos());

        this.tabelaPrecos.setCellValueFactory(new PropertyValueFactory<Limpeza, Double>("preco"));

        this.tabelaLimpeza.setItems(limpezaList);
    }

}
