package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL fxmlURL=getClass().getResource("/sources/1.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			//BorderPane root = new BorderPane();
			Scene scene = new Scene((VBox) root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ma première fenêtre JavaFX");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}}