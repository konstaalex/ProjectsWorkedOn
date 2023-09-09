package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController  {

    @FXML
    public void onSalesOfficerButtonClick(ActionEvent event){
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScene(SceneManager.SceneType.SALES_OFFICER_SCENE);
    }

    @FXML
    public void onSalesEmployeeButtonClick(ActionEvent event){
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScene(SceneManager.SceneType.SALES_EMPLOYEE_SCENE);
    }



//    @FXML
//    private void onSalesManagerButtonClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("sales_manager.fxml"));
//        Parent root = loader.load();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.show();
//    }

    //@FXML
//    private void onSalesEmployeeButtonClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("sales_employee.fxml"));
//        Parent root = loader.load();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.show();
//    }

}
