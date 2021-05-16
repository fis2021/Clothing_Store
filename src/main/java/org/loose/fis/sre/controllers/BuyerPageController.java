package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Product;
import org.loose.fis.sre.services.AddProductService;
import org.loose.fis.sre.services.BuyProductService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BuyerPageController {


    private static ObjectRepository<Product> productsRepository = AddProductService.getProductsRepository();
    private static String buyerName;



    @FXML
    public Button backButton;
    @FXML
    public Button ordersButton;
    @FXML
    public Button buyButton;
    @FXML
    public Button refreshButton;
    @FXML
    public ListView<String> productName = new ListView<>();
    public ListView<String> productSize = new ListView<>();
    public ListView<String> productPrice = new ListView<>();
    public ListView<String> productSeller = new ListView<>();
    public ListView<String> productDescription = new ListView<>();




    public String prodName;
    public String prodSize;
    public String prodPrice;
    public String prodSeller;
    public String prodDescription;


    public Text buyMessage;
    public Text buyMessage2;

    @FXML
    private ImageView productImage;

    @FXML
    TextField productID;
    @FXML
    TextField sellerID;
    @FXML
    ChoiceBox sizeID;


    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
    @FXML
    public void initialize() throws IOException {

        buyerName = LoginController.getLoggedUsername();
        buyMessage.setText("");
        buyMessage2.setText("");

        ObservableList<String> a = FXCollections.observableArrayList();
        ObservableList<String> b = FXCollections.observableArrayList();
        ObservableList<String> c = FXCollections.observableArrayList();
        ObservableList<String> d = FXCollections.observableArrayList();
        ObservableList<String> e = FXCollections.observableArrayList();
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
        for (Product product : productsRepository.find()){
            e.add(product.getProductDescription());
            productDescription.setItems(e);
        }

        sizeID.getItems().addAll("XS", "S", "M","L","XL");

        }





        private void updateGUI() throws MalformedURLException {

            for (Product product : productsRepository.find()){

                if(prod2.equals(product.getProductName())){
                File file = new File(product.getPhoto());
               String localUrl = file.toURI().toURL().toExternalForm();
                Image poza = new Image(localUrl, false);
               productImage.setImage(poza);
                productImage.setFitHeight(100);
                productImage.setFitWidth(150);
                productImage.rotateProperty();

                }
            }
    }



public String prod2;


    public void showImage() throws MalformedURLException {


            prod2 = productName.getSelectionModel().getSelectedItem();

            updateGUI();


    }


    public void setOrdersButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) ordersButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MyOrders.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
         stageBack.show();
    }

    public String nameaux;
    public String selleraux;

    public void setBuyButton(javafx.event.ActionEvent event) throws IOException {

 int ok = 0;
        for (Product product : productsRepository.find()) {

            prodName = product.getProductName();
            prodPrice = product.getProductPrice();
            prodSize = product.getProductSize();
            prodDescription = product.getProductDescription();
            prodSeller = product.getSellerName();
            buyerName = LoginController.getLoggedUsername();


            System.out.println(prodName);
            System.out.println(productID.getText());
            nameaux = productID.getText();
            selleraux = sellerID.getText();
            if (prodName.equals(nameaux) && prodSeller.equals(selleraux)) {
               ok=1;
                buyMessage.setText("Produs achizitionat!");
                BuyProductService.buyProduct(prodName, prodDescription, prodSize, prodPrice, prodSeller, buyerName);
                productID.clear();
                sellerID.clear();

                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getClassLoader().getResource("BuyerPage.fxml"));

            }


        }
        if (ok!=1){buyMessage2.setText("Produs/Seller inexistent!");}

    }

public void setRefreshButton() throws IOException {

    Stage stageref = (Stage) refreshButton.getScene().getWindow();
    stageref.setTitle("SHOP");
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("BuyerPage.fxml"));
    stageref.setScene(new Scene(root, 600, 350));
    stageref.show();
}
}

