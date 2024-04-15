module org.example.javalms {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.jfoenix;
    requires java.sql;


    opens org.example.javalms to javafx.fxml;
    exports org.example.javalms;
}