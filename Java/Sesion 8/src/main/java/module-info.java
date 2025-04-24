module com.sesion8.sesion8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sesion8.sesion8 to javafx.fxml;
    exports com.sesion8.sesion8;
}