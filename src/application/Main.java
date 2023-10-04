package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws LoadException,IllegalArgumentException,NullPointerException {
		try {

			Parent root=FXMLLoader.load(getClass().getResource("Login.fxml")); //hayedt .getClassLoader()
			Scene scene = new Scene(root); 
			primaryStage.setTitle("Login page");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
