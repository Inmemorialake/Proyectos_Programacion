module com.project2.project2fpoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project2.project2fpoe to javafx.fxml;
    exports com.project2.project2fpoe;
}