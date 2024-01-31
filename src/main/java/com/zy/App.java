package com.zy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * @author Zhi Yang
 * @version 1.0
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/fxml/loginZY"));
        // Cargar el ícono desde el directorio 'resources'


        this.stage=stage;
        this.stage.setScene(scene);
        Image icon = new Image(getClass().getResource("/vr/icon.png").toExternalForm());

        // Establecer el ícono para la aplicación
        stage.getIcons().add(icon);
        stage.setTitle("Calculator ZY");
        this.stage.show();
        this.stage.resizableProperty().set(false);
    }

    static void setRoot(String fxml,double width,double height) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.setWidth(width);
        stage.setHeight(height);
    }
    void setCss(){
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

    }
    

    private static Parent loadFXML(String fxml) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}