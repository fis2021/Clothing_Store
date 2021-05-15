package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UsernameDoesNotExistsException;
import org.loose.fis.sre.exceptions.WrongPasswordException;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.util.Objects;

import static org.loose.fis.sre.services.UserService.getUsers;

public class LoginController {
    @FXML
    public Button cancelButton;
    public Button backButton;
    public Button loginButton;
    @FXML
    private Text loginMessage;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private static String loggedUsername;
    @FXML
    String role;


    public void setCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }
    public void setLoginButton(ActionEvent event) throws IOException {

        try {
            UserService.loginUser(usernameField.getText(), passwordField.getText(), role);
            for (User user : getUsers().find()) {
                if (Objects.equals(usernameField.getText(), user.getUsername())) {
                    this.loggedUsername = user.getUsername();
                    this.role=user.getRole();

                }


            if(Objects.equals(role,"Seller"))
            {
                Stage stageLogin=(Stage) loginButton.getScene().getWindow();
                stageLogin.setTitle("LOGIN");
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SellerPage.fxml"));
                stageLogin.setScene(new Scene(root, 600, 350));
                stageLogin.show();
            }
                if(Objects.equals(role,"Buyer")){
                Stage stageLogin=(Stage) loginButton.getScene().getWindow();
                stageLogin.setTitle("LOGIN");
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("BuyerPage.fxml"));
                stageLogin.setScene(new Scene(root, 600, 350));
                stageLogin.show();
            }
            }



        } catch (UsernameDoesNotExistsException e) {
            System.out.println("Usermane dont exist");

        } catch (WrongPasswordException e) {
           System.out.println("Wrong password");

        }
    }
    }

