
package myself;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {
	   
	/**
	 * The main method for the GUI example program JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	
	public static void main(String[] args) {
		launch(args);   
	}
		   
	@Override
	public void start(Stage stage) throws IOException {
		// Task #1: Instantiate FXMainPane
		FXMainPane root = new FXMainPane();

		// Set the scene with specified width and height (e.g., 400x300)
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);

		// Set stage title
		stage.setTitle("Hello World GUI");

		// Display the stage
		stage.show();
	}
}
