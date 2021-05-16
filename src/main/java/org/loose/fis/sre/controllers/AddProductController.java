package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.FieldNotCompletedException;
import org.loose.fis.sre.services.AddProductService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class AddProductController {

    @FXML
    TextField productNameField;
    @FXML
    TextField productDescriptionField;
    @FXML
    TextField productPriceField;
    @FXML
    ChoiceBox selectSizeButton;
    @FXML
    ImageView photoPath;
    @FXML
    public Button finishButton;
    @FXML
    public Button backButton;
    public File file;
    public String path;
    @FXML
    public TextField usernameField;

    public void initialize() {
        selectSizeButton.getItems().addAll("XS", "S", "M","L","XL");
    }
    public void addPictureOnAction() throws MalformedURLException{
        Stage stage=new Stage();
        FileChooser chooser=new FileChooser();
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg files", "*.jpg"));
        file= chooser.showOpenDialog(stage);
        path=file.getAbsolutePath();
        chooser.setInitialDirectory(file.getParentFile());
        File file=new File(path);
        String url=file.toURI().toURL().toExternalForm();
        Image pic=new Image(url,false);
        photoPath.setImage(pic);
        photoPath.setFitHeight(285);
        photoPath.setFitWidth(285);
        photoPath.rotateProperty();
    }

    @FXML
    public void addProductAction(javafx.event.ActionEvent login) throws IOException {

        try {
            AddProductService.addProduct(productNameField.getText(), productDescriptionField.getText(), (String) selectSizeButton.getValue(), path, productPriceField.getText(), usernameField.getText());
            productNameField.clear();
            productDescriptionField.clear();
       {
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getClassLoader().getResource("MyProducts.fxml"));
                Parent viewuserlogin = Loader.load();
                Scene loginscene = new Scene(viewuserlogin, 650, 450);
                Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
                window.setScene(loginscene);
                window.show();
            }
        } catch (FieldNotCompletedException e) {
            System.out.println("Field not completed");
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
