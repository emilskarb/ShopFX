package com.example.shopfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    public Button login_button;

    @FXML
    private TextField login_id;

    @FXML
    private TextField password_id;

    @FXML
    private List<User> users;

    @FXML
    public void handleLogin() {         //Funkcja jest odpowiedzialna za walidację danych i przejśćie do strony sklepu po wpisaniu odpowiednich danych
        String login = login_id.getText();
        String password = password_id.getText();

        boolean userFound = users.stream().anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password));      //Szukamy w liście użytkowników

        if (userFound) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-view.fxml"));
                Scene mainScene = new Scene(fxmlLoader.load(), 785, 545);
                Stage stage = (Stage) login_button.getScene().getWindow();
                stage.setScene(mainScene);
                stage.setTitle("Panel sklepu");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (login.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd logowania");
            alert.setHeaderText(null);
            alert.setContentText("Pola login i hasło nie mogą być puste!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd logowania");
            alert.setHeaderText(null);
            alert.setContentText("Niepoprawne dana logowania");
            alert.showAndWait();
        }
    }

    public class User {
        private String login;
        private String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }
        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }

    @FXML
    public void initialize() {
        users = new ArrayList<>();
        users.add(new User("admin", "admin"));
        users.add(new User("login1", "password1"));
        users.add(new User("login2", "password2"));
    }

}

