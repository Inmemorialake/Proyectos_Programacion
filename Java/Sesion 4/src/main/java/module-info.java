module com.example.sesion4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sesion4 to javafx.fxml;
    exports com.example.sesion4;
}