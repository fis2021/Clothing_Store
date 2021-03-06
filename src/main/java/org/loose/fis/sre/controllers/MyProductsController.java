package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FieldNotCompletedException;
import org.loose.fis.sre.exceptions.ProductDoesntExistException;
import org.loose.fis.sre.model.Product;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.AddProductService;
import org.loose.fis.sre.services.UserService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;


public class MyProductsController {

    private static String loggedUser;
    @FXML
    public TextField prodField;
    @FXML
    public TextField userField;
    @FXML
    public TextField prodNameField;
    @FXML
    public Button backButton;
    @FXML
    public Text errorText;
    @FXML
    public Button deleteButton;
    @FXML
    public Button editButton;
    public String name;
    @FXML
    private ImageView productImage;

    private static ObjectRepository<Product> productsRepository = AddProductService.getProductsRepository();
    private static ObjectRepository<User> userRepository = UserService.getUsers();




    @FXML
    public ListView<String> productName = new ListView<>();
    public ListView<String> productSize = new ListView<>();
    public ListView<String> productPrice = new ListView<>();
    public ListView<String> productDescription = new ListView<>();

    @FXML
    public void initialize() throws IOException {
        ObservableList<String> a = FXCollections.observableArrayList();
        ObservableList<String> b = FXCollections.observableArrayList();
        ObservableList<String> c = FXCollections.observableArrayList();
        ObservableList<String> d = FXCollections.observableArrayList();
        loggedUser = LoginController.getLoggedUsername();
                for (Product product : productsRepository.find())
                if (Objects.equals(loggedUser, product.getSellerName())) {
                    a.add(product.getProductName());
                    productName.setItems(a);
                    d.add(product.getProductDescription());
                    productDescription.setItems(d);

                    c.add(product.getProductPrice());
                    productPrice.setItems(c);
                    b.add(product.getProductSize());
                    productSize.setItems(b);
                }

    }

    public void setEditButton (ActionEvent event) throws IOException, FieldNotCompletedException {
                Stage stageBack = (Stage) editButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("EditProduct.fxml"));
            stageBack.setScene(new Scene(root, 600, 350));
            stageBack.show();}

    public void setDeleteButton (ActionEvent event) throws IOException,FieldNotCompletedException, ProductDoesntExistException {
            try {
                AddProductService.deleteAd(prodField.getText(), userField.getText());
                {
                    Stage stageBack = (Stage) deleteButton.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MyProducts.fxml"));
                    stageBack.setScene(new Scene(root, 600, 350));
                    stageBack.show();
                }
            }
            catch (ProductDoesntExistException r) {
                prodField.clear();
                errorText.setText(r.getMessage());

            }catch (FieldNotCompletedException e) {
                    errorText.setText(e.getMessage()); }

            }

    private void updateGUI() throws MalformedURLException {

        for (Product product : productsRepository.find()){

            if(prod2.equals(product.getProductName())){
                File file = new File(product.getPhoto());
                String localUrl = file.toURI().toURL().toExternalForm();
                Image poza = new Image(localUrl, false);
                productImage.setImage(poza);
                productImage.setFitHeight(183);
                productImage.setFitWidth(139);
                productImage.rotateProperty();

            }
        }
    }

    public String prod2;
    public void showImage() throws MalformedURLException {
        prod2 = productName.getSelectionModel().getSelectedItem();
        updateGUI();
    }

        public void setBackButton (ActionEvent event) throws IOException {
            Stage stageBack = (Stage) backButton.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SellerPage.fxml"));
            stageBack.setScene(new Scene(root, 600, 350));
            stageBack.show();
        }

}
