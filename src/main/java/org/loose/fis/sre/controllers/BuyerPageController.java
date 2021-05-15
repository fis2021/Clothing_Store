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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Product;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.AddProductService;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class BuyerPageController {

    private static String loggedUser;
    private static ObjectRepository<Product> productsRepository = AddProductService.getProductsRepository();
    private static ObjectRepository<User> userRepository = UserService.getUsers();



    @FXML
    public Button backButton;
    @FXML
    public Button ordersButton;


    @FXML
    public ListView<String> productName = new ListView<>();
    public ListView<String> productSize = new ListView<>();
    public ListView<String> productPrice = new ListView<>();
    public ListView<String> productSeller = new ListView<>();
    @FXML
    private ImageView imageView;

    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
    @FXML
    public void initialize() throws IOException {
        ObservableList<String> a = FXCollections.observableArrayList();
        ObservableList<String> b = FXCollections.observableArrayList();
        ObservableList<String> c = FXCollections.observableArrayList();
        ObservableList<String> d = FXCollections.observableArrayList();

          for (Product product : productsRepository.find()) {
                a.add(product.getProductName());
                productName.setItems(a);}
          for (Product product : productsRepository.find()){
                b.add(product.getProductSize());
                productSize.setItems(b);}
          for (Product product : productsRepository.find()){
                c.add(product.getProductPrice());
                productPrice.setItems(c);
            }
        for (Product product : productsRepository.find()){
            d.add(product.getSellerName());
            productSeller.setItems(d);
        }
        }



    public void setOrdersButton(ActionEvent event) throws IOException {
       // Stage stageBack = (Stage) addProductButton.getScene().getWindow();
       // stageBack.setTitle("Welcome!");
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AddProduct.fxml"));
       // stageBack.setScene(new Scene(root, 600, 350));
       // stageBack.show();
    }
}
