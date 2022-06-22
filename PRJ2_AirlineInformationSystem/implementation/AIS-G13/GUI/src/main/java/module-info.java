module nl.fontys.ais.guis {
    requires javafx.controls;
    requires javafx.fxml;


    opens nl.fontys.ais.gui to javafx.fxml;
    exports nl.fontys.ais.gui;
}