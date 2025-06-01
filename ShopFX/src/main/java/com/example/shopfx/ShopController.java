package com.example.shopfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class ShopController {
    @FXML
    public Button login_button;

    @FXML
    private TextField login_id;

    @FXML
    private TextField password_id;

    @FXML
    public void handleLogin() {         //Funkcja jest odpowiedzialna za walidację danych i przejśćie do strony sklepu po wpisaniu odpowiednich danych
        String login = login_id.getText();
        String password = password_id.getText();

        if (login.equals("admin") && password.equals("admin")) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-view.fxml"));
                Scene mainScene = new Scene(fxmlLoader.load(), 720, 640);
                Stage stage = (Stage) login_button.getScene().getWindow();
                stage.setScene(mainScene);
                stage.setTitle("Panel sklepu");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd logowania");
                alert.setHeaderText(null);
                alert.setContentText("Niepoprawne dana logowania");
                alert.showAndWait();
        }
    }
}
