/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.zy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author yang
 */
public class LoginZYController implements Initializable {


    @FXML
    private TextField text_username;
    @FXML
    private PasswordField text_password;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_Sign;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void onClick_Login(ActionEvent event) throws IOException {
        App.setRoot("/fxml/orderZY",650,500);
    }

    
}
