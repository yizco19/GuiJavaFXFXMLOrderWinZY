module com.zy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.zy to javafx.fxml;
    exports com.zy;
}
