module com.example.data_folder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.data_folder to javafx.fxml;
    exports com.example.data_folder;
}