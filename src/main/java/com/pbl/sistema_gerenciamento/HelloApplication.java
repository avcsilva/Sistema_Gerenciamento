package com.pbl.sistema_gerenciamento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("JanelaLogin.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}