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
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.BuyedProduct;
import org.loose.fis.sre.services.BuyProductService;

import java.io.IOException;
import java.util.Objects;

public class MyOrdersController {
    @FXML
    public Button backButton;
    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("BuyerPage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }


    private static ObjectRepository<BuyedProduct> buyedProductsRepository = BuyProductService.getbuyedProductRepository();


    @FXML
    public ListView<String> productName = new ListView<>();
    public ListView<String> productSize = new ListView<>();
    public ListView<String> productPrice = new ListView<>();
    public ListView<String> productSeller = new ListView<>();
    public ListView<String> productDescription = new ListView<>();



    private String loggedUser;

    @FXML
    public void initialize() throws IOException {



        ObservableList<String> a = FXCollections.observableArrayList();
        ObservableList<String> b = FXCollections.observableArrayList();
        ObservableList<String> c = FXCollections.observableArrayList();
        ObservableList<String> d = FXCollections.observableArrayList();
        ObservableList<String> e = FXCollections.observableArrayList();


        loggedUser = LoginController.getLoggedUsername();


            for (BuyedProduct product : buyedProductsRepository.find()) {
                if(Objects.equals(loggedUser,product.getbuyerName())) {
                a.add(product.getbuyedProductName());
                productName.setItems(a);

                b.add(product.getbuyedProductSize());
                productSize.setItems(b);

                c.add(product.getbuyedProductPrice());
                productPrice.setItems(c);


                d.add(product.getbuyedSellerName());
                productSeller.setItems(d);

                e.add(product.getbuyedProductDescription());
                productDescription.setItems(e);
            }
        }
}}
