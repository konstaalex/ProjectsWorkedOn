module gui_module {
    requires javafx.controls;
    requires javafx.fxml;

    requires businesslogic_module;
    requires datarecords_module;
    requires org.kordamp.bootstrapfx.core;
    requires com.calendarfx.view;

    opens gui to javafx.fxml;


    exports gui;
    exports gui.Utility;
    opens gui.Utility to javafx.fxml;
}