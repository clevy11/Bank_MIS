module com.example.bankmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.bankmanagementsystem to javafx.fxml;
    exports com.example.bankmanagementsystem;
}