package org.loose.fis.sre.controllers;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.loose.fis.sre.controllers.MyProductsController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FieldNotCompletedException;
import org.loose.fis.sre.model.Product;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.AddProductService;
import org.loose.fis.sre.services.UserService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;

public class EditProductController extends MyProductsController{


    private static String loggedUser;
    @FXML
    public TextField prName;
    @FXML
    public TextField prDesc;
    @FXML
    public TextField userField;
    @FXML
    public TextField prPrice;
    @FXML
    public TextField prSize;
    @FXML
    public Button backButton;
    @FXML
    public Button deleteButton;
    @FXML
    public Button editButton;
    public String name;
    public String path;
    @FXML
    ImageView image;
    public File file;

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

    public void setChangeButton(ActionEvent event)throws MalformedURLException{

            Stage stage=new Stage();
            FileChooser chooser=new FileChooser();
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg files", "*.jpg"));
            file= chooser.showOpenDialog(stage);
            path=file.getAbsolutePath();
            chooser.setInitialDirectory(file.getParentFile());
            File file=new File(path);
            String url=file.toURI().toURL().toExternalForm();
            Image pic=new Image(url,false);
            image.setImage(pic);
            image.setFitHeight(150);
            image.setFitWidth(150);
            image.rotateProperty();
        }





    public String aux;
    public void setEditButton(ActionEvent event) throws IOException, FieldNotCompletedException {
        aux = prName.getText();
        for (Product product : productsRepository.find())
            if (aux.equals((product.getProductName()))) {
                try {
                    AddProductService.deleteAd(prName.getText(), userField.getText());

                } catch (FieldNotCompletedException e) {
                    System.out.println("Field not completed");
                }

                    AddProductService.addProduct(prName.getText(),
                            prDesc.getText(),
                            prSize.getText(),
                            path, prPrice.getText(), userField.getText());
                Stage stageBack = (Stage) editButton.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MyProducts.fxml"));
                stageBack.setScene(new Scene(root, 600, 350));
                stageBack.show();

            }
    }



    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SellerPage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }

}

