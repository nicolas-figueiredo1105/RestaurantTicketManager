module com.example.restaurantticketmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.restaurantticketmanager to javafx.fxml;
    exports com.example.restaurantticketmanager;
}