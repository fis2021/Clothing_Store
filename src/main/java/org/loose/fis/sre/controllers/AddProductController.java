package org.loose.fis.sre.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import  javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AddProductController {
    @FXML
    ImageView photoPath;
    @FXML
    public Button finishButton;
    @FXML
    public Button backButton;
    public File file;
    public String path;
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
    public void setFinishButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) finishButton.getScene().getWindow();
        stageBack.setTitle("My Products");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MyProducts.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SellerPage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }

    }
