package edu.examenRecup.controller;

import edu.examenRecup.dao.UserDAO;
import edu.examenRecup.model.Role;
import edu.examenRecup.model.Sesion;
import edu.examenRecup.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button btnLogout;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNickname;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEdad;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox cmbRole;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Label lblErrorFormulario;

    @FXML
    public void handleLogout(ActionEvent event) throws IOException {
        Sesion.cerrarSesion();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    @FXML
    public void handleClear(ActionEvent event) {
        txtId.clear();
        txtNombre.clear();
        txtNickname.clear();
        txtEmail.clear();
        txtEdad.clear();
        txtPassword.clear();
    }

    @FXML
    public void handleAdd(ActionEvent event) {
        if (validarFormulario().isEmpty()) {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String nickname = txtNickname.getText();
            String email = txtEmail.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String password = txtPassword.getText();
            Role role = Role.valueOf(cmbRole.getSelectionModel().getSelectedItem().toString());

            User usuario = new User(id, nombre, nickname, email, edad, password, role);
            UserDAO dao = new UserDAO();
            dao.createUser(usuario);
        }

    }

    @FXML
    public void handleUpdate(ActionEvent event) {

    }

    @FXML
    public void handleDelete(ActionEvent event) {
        if (validarFormulario().isEmpty()) {
            int id = txtId;
        }
    }

    private String validarFormulario() {
        if (txtNombre.getText().trim().isEmpty()) {
            return "El nombre no puede estar vacío.";
        }

        if (txtNickname.getText().trim().isEmpty()) {
            return "El nickname no puede estar vacío.";
        }

        if (txtEmail.getText().trim().isEmpty()) {
            return "El email no puede estar vacío";
        }

        try {
            Integer.parseInt(txtEdad.getText());
        } catch (Exception e) {
            return "La edad tiene que ser un número";
        }

        if (txtPassword.getText().trim().isEmpty()) {
            return "La contraseña no puede estar vacía.";
        }

        return "";
    }
}
