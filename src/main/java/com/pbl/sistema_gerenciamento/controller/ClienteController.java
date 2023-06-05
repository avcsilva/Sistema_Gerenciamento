package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClienteController {

    @FXML
    private Button btnApg;

    @FXML
    private Button btnAtt;

    @FXML
    private Button btnCria;

    @FXML
    private TextField clienteEmail;

    @FXML
    private TextField clienteEndereco;

    @FXML
    private TextField clienteNome;

    @FXML
    private TextField clienteTelefone;

    @FXML
    private Label erro_msg;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn<Cliente, String> tabelaEmails;

    @FXML
    private TableColumn<Cliente, String> tabelaEnderecos;

    @FXML
    private TableColumn<Cliente, String> tabelaNomes;

    @FXML
    private TableColumn<Cliente, String> tabelaTelefones;

    private ObservableList<Cliente> clientesLista;

    /**
     * Apaga o cliente selecionado
     * @param event
     */
    @FXML
    void btnApgAction(ActionEvent event) {

    }

    /**
     * Atualiza os dados do cliente selecionado
     * @param event
     */
    @FXML
    void btnAttAction(ActionEvent event) {

    }

    /**
     * Cria um novo cliente
     * @param event
     */
    @FXML
    void btnCriaAction(ActionEvent event) {
        if (clienteNome.getText().isEmpty() || clienteEndereco.getText().isEmpty() || clienteTelefone.getText().isEmpty() || clienteEmail.getText().isEmpty()) {
            this.erro_msg.setText("Preencha todos os campos!");
        } else {
            Cliente cliente = new Cliente(clienteNome.getText(), clienteEndereco.getText(), clienteTelefone.getText(), clienteEmail.getText());
            DAO.getClienteDAO().criar(cliente);
            this.erro_msg.setText("Cliente criado com sucesso!");
            this.clienteEmail.clear();
            this.clienteEndereco.clear();
            this.clienteNome.clear();
            this.clienteTelefone.clear();
        }
    }

    /**
     * Inicializa a tela
     */
    @FXML
    void initialize() {
        this.clientesLista = FXCollections.observableArrayList(DAO.getClienteDAO().acharTodos());
        this.tabelaClientes.getColumns().addAll(tabelaNomes, tabelaEnderecos, tabelaTelefones, tabelaEmails);
        this.tabelaClientes.setItems(clientesLista);
    }

}
