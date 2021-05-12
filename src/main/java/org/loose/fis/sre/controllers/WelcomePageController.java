package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.io.IOException;

public class WelcomePageController {
    @FXML
    public Button cancelButton;
    public Button loginButton;
    public Button registerButton;

    public void cancelButtonOnAction(ActionEvent event){
        Stage stageCancel=(Stage) cancelButton.getScene().getWindow();
        stageCancel.close();
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        Stage stageLogin=(Stage) loginButton.getScene().getWindow();
        stageLogin.setTitle("LOGIN");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        stageLogin.setScene(new Scene(root, 600, 350));
        stageLogin.show();
    }

    public void registerButtonOnAction(ActionEvent event) throws IOException {
        Stage stageRegister=(Stage) registerButton.getScene().getWindow();
        stageRegister.setTitle("REGISTER");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        stageRegister.setScene(new Scene(root, 600, 350));
        stageRegister.show();
    }
}