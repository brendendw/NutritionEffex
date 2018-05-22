package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


/**
 * 
 * @author brendendrew
 * Screen that is showed at launch. Allows the user to select between sign-up and sign-in.
 */
public class LaunchSceneController extends SeamlessViewFX implements Initializable {
	@FXML
	private Label signInButton;
	@FXML
	private Label signUpButton;
	@FXML
	private ImageView backgroundImage;


	// Event Listener on Label[#signInButton].onMouseClicked
	@FXML
	public void signIn(MouseEvent event) {
		signInButton.setOnMousePressed(e -> signInButton.setStyle(SCALE_UP));
		signInButton.setOnMouseReleased(e -> signInButton.setStyle(HOVERED_BUTTON_STYLE));
		ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
	}
	// Event Listener on Label[#signUpButton].onMouseClicked
	@FXML
	public void signUp(MouseEvent event) {
		signUpButton.setOnMousePressed(e -> signUpButton.setStyle(SCALE_UP));
		signUpButton.setOnMouseReleased(e -> signUpButton.setStyle(HOVERED_BUTTON_STYLE));
		ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
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
		signInButton.setOnMousePressed(e -> signInButton.setStyle(IDLE_BUTTON_STYLE));
		
		signUpButton.setStyle(IDLE_BUTTON_STYLE);
		signUpButton.setOnMouseEntered(e -> signUpButton.setStyle(HOVERED_BUTTON_STYLE));
		signUpButton.setOnMousePressed(e -> signUpButton.setStyle(IDLE_BUTTON_STYLE));
		signUpButton.setOnMouseExited(e -> signUpButton.setStyle(IDLE_BUTTON_STYLE));
		

		}
		catch (NullPointerException e) {
			System.out.println("Transferring scenes");
		}
		
	}


	
	
}
