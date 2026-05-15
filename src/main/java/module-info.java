module com.example.restaurantticketmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restaurantticketmanager to javafx.fxml;
    exports com.example.restaurantticketmanager;
}