package gui;
import javafx.application.Application;
import javafx.stage.Stage;
//test
public class GUIApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager sceneManager = SceneManager.getInstance(primaryStage);
        primaryStage.setTitle("Airline Information System");
        primaryStage.setScene(sceneManager.getCurrentScene());
        sceneManager.changeScene(SceneManager.SceneType.FIRST_SCENE);
        primaryStage.show();

    }

    public void startApp() {
        launch();
    }
}
