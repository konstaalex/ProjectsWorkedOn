package gui.Utility;

import businessLogic.FlightServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
    }

    public static void allFieldsRequiredError (){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("All fields are required.");
        alert.showAndWait();
        return;
    }

    public static void successWindow (String message,String flightNr){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(message);
        alert.setHeaderText(message +" "+ flightNr + " created successfully.");
        alert.showAndWait();
    }

    public static void successWindow(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    public static void generalErrorWindow(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(message);
        alert.setHeaderText(message);
        alert.showAndWait();
    }


//    public ErrorController(Supplier<SceneManager> sceneManagerSupplier) {
//        this.sceneManagerSupplier = sceneManagerSupplier;
//    }
}
