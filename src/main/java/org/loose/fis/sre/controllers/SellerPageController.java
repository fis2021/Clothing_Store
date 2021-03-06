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
    public Button backButton;
    public Button ordersButton;
    public Button addProductButton;
    public Button myProductsButton;
    public MyProductsController myprod;

    public void setCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
    public void setMyProductsButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) myProductsButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MyProducts.fxml"));
        stageBack.setScene(new Scene(root, 700, 450));
        stageBack.show();
    }
    public void setOrdersButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) ordersButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("InboxPage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
    public void setAddProductButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) addProductButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AddProduct.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
}
