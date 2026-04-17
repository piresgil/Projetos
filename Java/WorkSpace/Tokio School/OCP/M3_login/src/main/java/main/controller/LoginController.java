package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.model.LoginModel;

// class Controladora
public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    // modelo de autenticação
    private final LoginModel model = new LoginModel();

    // Ação do botão,chama a autenticação e mostra menssagem
    @FXML
    private void onLoginButtonClick() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (model.autenticar(user, pass)) {
            messageLabel.setText("Login com sucesso!");
        } else {
            messageLabel.setText("Nome de utilizador ou palavra-passe incorretos!");
        }
    }
}
