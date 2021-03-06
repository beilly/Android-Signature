package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	private static Stage primaryStage; // **Declare static Stage**

    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return Main.primaryStage;
    }

	@Override
	public void start(Stage primaryStage) {
		try {
			setPrimaryStage(primaryStage); // **Set the Stage**
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Android 签名系统");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
