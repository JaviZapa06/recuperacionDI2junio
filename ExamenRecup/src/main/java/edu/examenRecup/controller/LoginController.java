package edu.examenRecup.controller;

import edu.examenRecup.dao.UserDAO;
import edu.examenRecup.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    public void handleLogin(ActionEvent event) {

        String email =  txtEmail.getText();
        String password = txtPassword.getText();

        User usuario = UserDAO.authenticate(email, password);

        if (usuario == null) {
            lblError.setText("Invalid email or password");
        }
    }
}
