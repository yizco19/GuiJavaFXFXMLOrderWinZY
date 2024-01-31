/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.zy;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author yang
 */
public class OrderZYController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private Label time;
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        // TODO
        Thread taskThread = new Thread(() -> {
            while (true) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
                String fechaHora = format.format(calendar.getTime());

                // Update the label
                time.setText(fechaHora);
                });
            }
        });

        taskThread.start();
    }    
    
    @FXML
    private void handleViewFullOrder(ActionEvent event) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION, "Full Order.");
    alert.showAndWait();
    }

    @FXML
    private void handleCalculator(ActionEvent event) throws IOException {
        App.setRoot("/fxml/calculadora",415,595);
        
    }

    @FXML
    private void handleExit(ActionEvent event) {
        // Prompt the user to confirm before exiting the application
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit the application?");
    alert.showAndWait();

    if (alert.getResult() == ButtonType.OK) {
        // Close the application
        System.exit(0);
    }
    }

    @FXML
    private void handleInformation(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION, "Information.");
    alert.showAndWait();
    }

    @FXML
    private void handleCompany(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Company.");
    alert.showAndWait();
    }

    @FXML
    private void handleAbout(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "About.");
    alert.showAndWait();
    }

}
