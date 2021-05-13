package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SellerPageController {
    public Button cancelButton;
    public Button addProductButton;

    public void setCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void setAddProductButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) addProductButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AddProduct.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
}
