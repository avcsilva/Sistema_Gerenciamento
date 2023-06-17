package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.OrdemServico;
import com.pbl.sistema_gerenciamento.model.Tecnico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FinalizaOrdemController {

    @FXML
    private Button btnCancela;

    @FXML
    private Button btnFinaliza;

    @FXML
    private Label erro_msg;

    @FXML
    private Label cliente;

    @FXML
    private Label custo;

    @FXML
    private Label datac;

    @FXML
    private TextField dataf;

    @FXML
    private Label id;

    @FXML
    private ChoiceBox<String> metPag;

    @FXML
    private Label preco;

    private Tecnico tecnico;

    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
        this.id.setText(Integer.toString(this.tecnico.getOrdemAssociada().getId()));
        this.cliente.setText(this.tecnico.getOrdemAssociada().getCliente().getNome());
        this.datac.setText(this.tecnico.getOrdemAssociada().getCriacao());
        this.custo.setText(Double.toString(this.tecnico.getOrdemAssociada().getCusto()));
        this.preco.setText(Double.toString(this.tecnico.getOrdemAssociada().getPreco()));
    }

    @FXML
    void btnCancelaAction(ActionEvent event) {
        if (this.dataf.getText().isEmpty()){
            this.erro_msg.setText("Digite a data de finalização!");
        }
        else {
            OrdemServico ordem = this.tecnico.getOrdemAssociada();
            ordem.setTecnico(null);
            ordem.setStatus("cancelada");
            ordem.setFinalizacao(this.dataf.getText());
            DAO.getOrdemServicoDAO().atualizar(ordem);
            this.tecnico.setOrdemAssociada(null);
            DAO.getTecnicoDAO().atualizar(this.tecnico);
            this.dialogStage.close();
        }
    }

    @FXML
    void btnFinalizaAction(ActionEvent event) {
        if (this.dataf.getText().isEmpty() || this.metPag.getSelectionModel().getSelectedItem() == null){
            this.erro_msg.setText("Preencha todos os campos!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        } else{
            OrdemServico ordem = this.tecnico.getOrdemAssociada();
            ordem.setTecnico(null);
            ordem.setStatus("finalizada");
            ordem.setFinalizacao(this.dataf.getText());
            ordem.setMetodoPagamento(this.metPag.getSelectionModel().getSelectedItem());
            DAO.getOrdemServicoDAO().atualizar(ordem);
            this.tecnico.setOrdemAssociada(null);
            DAO.getTecnicoDAO().atualizar(this.tecnico);
            this.dialogStage.close();
        }
    }

    @FXML
    void initialize(){
        ObservableList<String> metodos = FXCollections.observableArrayList("Dinheiro", "Cartão de Crédito", "Cartão de Débito", "PIX");
        this.metPag.setItems(metodos);
    }
}
