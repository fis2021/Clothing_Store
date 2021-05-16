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
import org.loose.fis.sre.exceptions.WeakPasswordException;
import org.loose.fis.sre.services.UserService;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterController {
    public Button backButton;

    public void setBackButton(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.setTitle("Welcome!");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        stageBack.setScene(new Scene(root, 600, 350));
        stageBack.show();
    }

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
    @FXML
    TextField emailField;
    @FXML
    ChoiceBox role;

    public void initialize() {
        role.getItems().addAll("Seller", "Buyer");
    }
    private static Message prepareMessage(Session session, String myAccEmail, String receptioner) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptioner));
            message.getSubject();
            message.setText("Welcome to our Clothing Store");
            return message;

        } catch (Exception e) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public static void sendMail(String receptioner) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccEmail = "clothingstore344@gmail.com";
        String pass = "clothingstore";

        Session session = Session.getInstance(properties, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthenticatoin() {
                return new PasswordAuthentication(myAccEmail, pass);
            }
        });
        Message message = prepareMessage(session, myAccEmail, receptioner);
        Transport.send(message);
        System.out.println("Sent");

    }
  @FXML
    public void handleRegisterAction(javafx.event.ActionEvent login) throws Exception {

        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), passwordconfirmField.getText(),
                    firstnameField.getText(), secondnameField.getText(), phonenumberField.getText(),
                    addressField.getText(),emailField.getText(),(String) role.getValue());

            usernameField.clear();
            passwordField.clear();
            passwordconfirmField.clear();
            firstnameField.clear();
            secondnameField.clear();
            phonenumberField.clear();
            addressField.clear();
            emailField.clear();


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
        catch (WeakPasswordException e) {
            registrationMessage.setText(e.getMessage());
            passwordField.clear();
            passwordconfirmField.clear();



            } catch (Exception e) {
            e.printStackTrace();
        }
//fx:controller="org.loose.fis.sre.controllers.RegisterController"

}}
