module com.example.sesion3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sesion3 to javafx.fxml;
    exports com.example.sesion3;
}