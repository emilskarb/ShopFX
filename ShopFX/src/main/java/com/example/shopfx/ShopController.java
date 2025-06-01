package com.example.shopfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;


public class ShopController {
    @FXML
    public Button login_button;

    @FXML
    public void handleLogin() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) login_button.getScene().getWindow();
            stage.setScene(mainScene);
            stage.setTitle("Panel sklepu");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
