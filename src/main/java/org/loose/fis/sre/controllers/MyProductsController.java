package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Product;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.AddProductService;
import org.loose.fis.sre.services.UserService;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MyProductsController {

    @FXML
    public Button backButton;

    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SellerPage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
}
