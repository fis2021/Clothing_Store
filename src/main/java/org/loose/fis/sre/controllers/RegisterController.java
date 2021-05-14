package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.FieldNotCompletedException;
import org.loose.fis.sre.exceptions.PasswordConfirmationException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class RegisterController {
    public Button backButton;
    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack=(Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
    /*@FXML
    private String registrationMessage="Account created";
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;


    public void initialize() {
        role.getItems().addAll("Seller", "Buyer");
    }


    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            System.out.println(registrationMessage);
        } catch (UsernameAlreadyExistsException e) {
            System.out.println("Try again");
        }
    }*/
   @FXML
    private Text registrationMessage = null;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    PasswordField passwordconfirmField;
    @FXML
    TextField firstnameField;
    @FXML
    TextField secondnameField;
    @FXML
    TextField phonenumberField;
    @FXML
    TextField addressField;
   // @FXML
    //public File file;
    //@FXML
   // public String path ;
    @FXML
   ChoiceBox role;

    @FXML
   /* public void initialize() {
        this.role.getItems().addAll(new Object[]{"Seller", "Buyer"});
    }*/
    public void initialize() {
        role.getItems().addAll("Seller", "Buyer");
    }

    @FXML
    public void handleRegisterAction(javafx.event.ActionEvent login) throws IOException {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), passwordconfirmField.getText(),
                    firstnameField.getText(), secondnameField.getText(), phonenumberField.getText(),
                    addressField.getText(),(String) role.getValue());
            //registrationMessage.setText("Account created!");
            usernameField.clear();
            passwordField.clear();
            passwordconfirmField.clear();
            firstnameField.clear();
            secondnameField.clear();
            phonenumberField.clear();
            addressField.clear();

            {
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getClassLoader().getResource("login.fxml"));
                Parent viewuserlogin = Loader.load();
                Scene loginscene = new Scene(viewuserlogin, 650, 450);
                Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
                window.setScene(loginscene);
                window.show();
            }
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
            passwordField.clear();
            passwordconfirmField.clear();

        }catch (FieldNotCompletedException e) {
            registrationMessage.setText(e.getMessage());
            passwordField.clear();
            passwordconfirmField.clear();
        }
        catch (PasswordConfirmationException e) {
            registrationMessage.setText(e.getMessage());
            passwordField.clear();
            passwordconfirmField.clear();

            }



    }
//fx:controller="org.loose.fis.sre.controllers.RegisterController"

}
