package org.loose.fis.sre.controllers;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LoginController {

    public Button cancelButton;

    public void setCancelButton(ActionEvent event){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
