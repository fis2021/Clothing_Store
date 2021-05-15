package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyerPageController {
    @FXML
    public Button backButton;
    @FXML
    public Button ordersButton;
    @FXML
    public ListView<String> listView;

    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }



    public void setOrdersButton(ActionEvent event) throws IOException {
       // Stage stageBack = (Stage) addProductButton.getScene().getWindow();
       // stageBack.setTitle("Welcome!");
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AddProduct.fxml"));
       // stageBack.setScene(new Scene(root, 600, 350));
       // stageBack.show();
    }
}
