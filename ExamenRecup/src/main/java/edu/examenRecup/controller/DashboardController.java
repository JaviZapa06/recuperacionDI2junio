package edu.examenRecup.controller;

import edu.examenRecup.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button btnLogout;

    @FXML
    public void handleLogout(ActionEvent event) throws IOException {
        Sesion.cerrarSesion();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
}
