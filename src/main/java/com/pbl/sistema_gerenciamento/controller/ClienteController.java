package com.pbl.sistema_gerenciamento.controller;

import com.pbl.sistema_gerenciamento.dao.DAO;
import com.pbl.sistema_gerenciamento.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
        Cliente cliente = this.tabelaClientes.getSelectionModel().getSelectedItem();
        if (cliente == null) {
            this.erro_msg.setText("Selecione um cliente!");
        } else {
            this.clientesLista.remove(cliente);
            DAO.getClienteDAO().deletar(cliente.getId());
            this.erro_msg.setText("Cliente apagado com sucesso!");
        }
    }

    /**
     * Atualiza os dados do cliente selecionado
     * @param event
     */
    @FXML
    void btnAttAction(ActionEvent event) {
        Cliente cliente = this.tabelaClientes.getSelectionModel().getSelectedItem();
        if (cliente == null) {
            this.erro_msg.setText("Selecione um cliente!");
        } else {
            if (clienteNome.getText().isEmpty() || clienteEndereco.getText().isEmpty() || clienteTelefone.getText().isEmpty() || clienteEmail.getText().isEmpty()) {
                this.erro_msg.setText("Preencha todos os campos!");
            } else {
                cliente.setNome(clienteNome.getText());
                cliente.setEndereco(clienteEndereco.getText());
                cliente.setTelefone(clienteTelefone.getText());
                cliente.setEmail(clienteEmail.getText());
                DAO.getClienteDAO().atualizar(cliente);
                this.clientesLista.set(this.tabelaClientes.getSelectionModel().getSelectedIndex(), cliente);
                this.erro_msg.setText("Cliente atualizado com sucesso!");
                this.clienteEmail.clear();
                this.clienteEndereco.clear();
                this.clienteNome.clear();
                this.clienteTelefone.clear();
            }
        }
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
            this.clientesLista.add(cliente);
        }
    }

    /**
     * Inicializa a tela
     */
    @FXML
    void initialize() {
        this.clientesLista = FXCollections.observableArrayList(DAO.getClienteDAO().acharTodos());

        this.tabelaNomes.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        this.tabelaEnderecos.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        this.tabelaTelefones.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
        this.tabelaEmails.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));

        this.tabelaClientes.setItems(clientesLista);
    }

}
