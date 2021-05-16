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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FieldNotCompletedException;
import org.loose.fis.sre.exceptions.ProductDoesntExistException;
import org.loose.fis.sre.exceptions.WrongPasswordException;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.AddProductService;
import org.loose.fis.sre.services.UserService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class AddProductController {
    private final ObjectRepository<User> REPOSITORY = UserService.getUsers();
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
    Text errorText;
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

    public void addProductAction(javafx.event.ActionEvent event) throws IOException {

        try {
       AddProductService.addProduct(productNameField.getText(),
                    productDescriptionField.getText(),
                    (String) selectSizeButton.getValue(),
                    path, productPriceField.getText(), usernameField.getText());
            productNameField.clear();
            productDescriptionField.clear();
       {
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getClassLoader().getResource("MyProducts.fxml"));
                Parent viewuserlogin = Loader.load();
                Scene loginscene = new Scene(viewuserlogin, 650, 450);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(loginscene);
                window.show();
            }
        } catch (FieldNotCompletedException e) {
                errorText.setText(e.getMessage());

            }
        catch (ProductDoesntExistException e) {
            errorText.setText(e.getMessage());

        }
        }
        public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SellerPage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }



}
