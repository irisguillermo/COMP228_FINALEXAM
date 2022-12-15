module com.example.finaltest2022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql.rowset;
    requires java.desktop;


    opens com.example.finaltest2022 to javafx.fxml;
    exports com.example.finaltest2022;
}