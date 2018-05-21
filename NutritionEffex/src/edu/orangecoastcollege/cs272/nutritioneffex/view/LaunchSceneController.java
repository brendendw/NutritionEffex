package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class LaunchSceneController implements Initializable {
	@FXML
	private Label signInButton;
	@FXML
	private Label signUpButton;
	@FXML
	private ImageView backgroundImage;

	private static final String HOVERED_BUTTON_STYLE = 
    		"-fx-background-color: white; -fx-border-color: black; "
    		+ "-fx-background-radius: 100, 100, 100, 100; -fx-border-radius: 100 100 100 100;"
    		+ "-fx-scale-x: 1.05; -fx-scale-y: 1.05; -fx-scale-z: 1.05;";
	
	private static final String IDLE_BUTTON_STYLE = 
    		"-fx-background-color: white; -fx-background-radius: 30, 30, 30, 30; -fx-border-radius: 10 10 0 0;"
    		+ "-fx-scale-x: 1.0; -fx-scale-y: 1.0; -fx-scale-z: 1.0;";
	
    private static final String CLICKED_BUTTON_STYLE = 
    		"-fx-background-color: transparent; color: white; -fx-border-color: black; "
    		+ "-fx-background-radius: 100, 100, 100, 100; -fx-border-radius: 100 100 100 100;"
    		+ "-fx-scale-x: 1.0; -fx-scale-y: 1.0; -fx-scale-z: 1.0;";
    

	// Event Listener on Label[#signInButton].onMouseClicked
	@FXML
	public void signIn(MouseEvent event) {
		signInButton.setOnMousePressed(e -> signInButton.setStyle(CLICKED_BUTTON_STYLE));
		signInButton.setOnMouseReleased(e -> signInButton.setStyle(HOVERED_BUTTON_STYLE));
		ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
	}
	// Event Listener on Label[#signUpButton].onMouseClicked
	@FXML
	public void signUp(MouseEvent event) {
		signUpButton.setOnMousePressed(e -> signUpButton.setStyle(CLICKED_BUTTON_STYLE));
		signUpButton.setOnMouseReleased(e -> signUpButton.setStyle(HOVERED_BUTTON_STYLE));
	}
	
	// Attempting to show background image at start up
	public boolean showImage() {
	    try {
	        Image image = new Image("welcome_background.jpeg");
	    	//this.backgroundImage = new ImageView(new Image(getClass().getResourceAsStream("/assets/imgsrc/welcome_background.jpeg")));
	        backgroundImage.setImage(image);
	        backgroundImage.setCache(true);
	        return true;
	    } catch (Exception e) {
	        System.out.println("Couldn't find image");
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
		signInButton.setStyle(IDLE_BUTTON_STYLE);
		signInButton.setOnMouseEntered(e -> signInButton.setStyle(HOVERED_BUTTON_STYLE));
		signInButton.setOnMouseExited(e -> signInButton.setStyle(IDLE_BUTTON_STYLE));
		signUpButton.setStyle(IDLE_BUTTON_STYLE);
		signUpButton.setOnMouseEntered(e -> signUpButton.setStyle(HOVERED_BUTTON_STYLE));
		signUpButton.setOnMouseExited(e -> signUpButton.setStyle(IDLE_BUTTON_STYLE));
		}
		catch (NullPointerException e) {
			System.out.println("Transferring scenes");
		}
		
	}
	
	
}
