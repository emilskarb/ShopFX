module com.example.shopfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.shopfx to javafx.fxml;
    exports com.example.shopfx;
}