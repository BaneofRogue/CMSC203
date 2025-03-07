
package myself;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	
	//student Task #2
	//Declare the buttons, label, and textfield, 2 hBoxes
	private Button btnHello, btnHowdy, btnChinese, btnClear, btnExit;
    private Label lblFeedback;
    private TextField txtField;
    private HBox hbox1, hbox2;

    private DataManager dataManager;
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		btnHello = new Button("Hello");
        btnHowdy = new Button("Howdy");
        btnChinese = new Button("Chinese");
        btnClear = new Button("Clear");
        btnExit = new Button("Exit");

        lblFeedback = new Label("Feedback:");
        txtField = new TextField();

        hbox1 = new HBox();
        hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
        dataManager = new DataManager();
		//  set margins and set alignment of the components
        HBox.setMargin(btnHello, new Insets(5));
        HBox.setMargin(btnHowdy, new Insets(5));
        HBox.setMargin(btnChinese, new Insets(5));
        HBox.setMargin(btnClear, new Insets(5));
        HBox.setMargin(btnExit, new Insets(5));
        HBox.setMargin(lblFeedback, new Insets(5));
        HBox.setMargin(txtField, new Insets(5));

        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
		
      //student Task #3:
        //  add the label and textfield to one of the HBoxes
        hbox1.getChildren().addAll(lblFeedback, txtField);
        
        //  add the buttons to the other HBox
        hbox2.getChildren().addAll(btnHello, btnHowdy, btnChinese, btnClear, btnExit);
        
        //  add the HBoxes to this FXMainPanel (a VBox)
        getChildren().addAll(hbox1, hbox2);
        
        //button actions
        btnHello.setOnAction(new ButtonHandler());
        btnHowdy.setOnAction(new ButtonHandler());
        btnChinese.setOnAction(new ButtonHandler());
        btnClear.setOnAction(new ButtonHandler());
        btnExit.setOnAction(new ButtonHandler());
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
        
        public void handle(ActionEvent event) {
        	//check if matches
            if (event.getTarget() == btnHello) {
                txtField.setText(dataManager.getHello());
            } else if (event.getTarget() == btnHowdy) {
                txtField.setText(dataManager.getHowdy());
            } else if (event.getTarget() == btnChinese) {
                txtField.setText(dataManager.getChinese());
            } else if (event.getTarget() == btnClear) {
                txtField.setText(""); //clear the text OUT!!!
            } else if (event.getTarget() == btnExit) {
                Platform.exit(); // we leaving
                System.exit(0);
            }
        }
    }
}
	
