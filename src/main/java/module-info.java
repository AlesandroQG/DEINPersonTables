module com.alesandro.deinpersontables {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alesandro.deinpersontables to javafx.fxml;
    exports com.alesandro.deinpersontables;
    exports control;
    opens control to javafx.fxml;
}