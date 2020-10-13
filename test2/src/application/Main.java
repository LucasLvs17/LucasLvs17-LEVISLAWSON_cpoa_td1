package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL fxmlURL=getClass().getResource("/sources/1.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			AnchorPane root = (AnchorPane) fxmlLoader.load();
			//BorderPane root2 = new BorderPane();
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		primaryStage.setTitle("Ma première fenêtre JavaFX");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}}