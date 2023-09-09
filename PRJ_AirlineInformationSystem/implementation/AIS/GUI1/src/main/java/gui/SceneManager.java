package gui;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SceneManager {

    public enum SceneType {
        FIRST_SCENE,
        SALES_OFFICER_SCENE,

        SALES_EMPLOYEE_SCENE
    }

    private static SceneManager instance = new SceneManager();

    private final List<Scene> scenes;
    private SceneType currentScene;
    private Stage stage;

    private SceneManager() {
        scenes = new ArrayList<>();
        currentScene = SceneType.FIRST_SCENE;

        try {
            FXMLLoader.setDefaultClassLoader(getClass().getClassLoader());

            Parent firstSceneRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-sceen.fxml")));
            Scene firstScene = new Scene(firstSceneRoot);

            Parent salesOfficerRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sales-officer.fxml")));
            Scene salesOfficerScene = new Scene(salesOfficerRoot);

            Parent salesEmployeeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sales-employee.fxml")));
            Scene salesEmployeeScene = new Scene(salesEmployeeRoot);

            scenes.add(firstScene);
            scenes.add(salesOfficerScene);
            scenes.add(salesEmployeeScene);

        } catch (IOException e) {
            System.out.println("Failed to load FXML file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static SceneManager getInstance() {
        return instance;
    }

    public static SceneManager getInstance(Stage stage) {
        instance.stage = stage;
        return instance;
    }

    public Scene getCurrentScene() {
        if (!scenes.isEmpty()) {
            return scenes.get(currentScene.ordinal());
        } else {
            throw new IllegalStateException("Scene list is empty");
        }
    }

    public void changeScene(SceneType sceneType) {
        currentScene = sceneType;
        stage.setScene(getCurrentScene());
    }
}
