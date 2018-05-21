package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

public class SignInSceneController implements Initializable {
	
	private static final String HOVERED_BACK_BUTTON_STYLE = 
			"-fx-scale-x: 1.1; -fx-scale-y: 1.1; -fx-scale-z: 1.1;";
	private static final String IDLE_BACK_BUTTON_STYLE = 
			"-fx-scale-x: 1.0; -fx-scale-y: 1.0; -fx-scale-z: 1.0;";
	
	
	private static final String HOVERED_BUTTON_STYLE = 
    		"-fx-background-color: white; -fx-border-color: black; "
    		+ "-fx-background-radius: 100, 100, 100, 100; -fx-border-radius: 100 100 100 100;"
    		+ "-fx-scale-x: 1.05; -fx-scale-y: 1.05; -fx-scale-z: 1.05;";
	
	private static final String IDLE_BUTTON_STYLE = 
    		"-fx-background-color: white; -fx-background-radius: 30, 30, 30, 30; -fx-border-radius: 10 10 0 0;"
    		+ "-fx-scale-x: 1.0; -fx-scale-y: 1.0; -fx-scale-z: 1.0;";
    
    // private static final String IDLE_BUTTON_STYLE = 
    		// "-fx-background-color: white; -fx-background-radius: 30, 30, 30, 30; -fx-border-radius: 10 10 0 0;";
    
	@FXML
	private ImageView backgroundImage;
	@FXML
	private Label signInButton;
	@FXML
	private TextField emailTF;
	@FXML
	private TextField passwordTF;
	
	@FXML 
	private Label incorrectInfoLabel;
	
	@FXML
	private ImageView backButton;

	// Event Listener on Label[#signInButton].onMouseClicked
	@FXML
	public void signIn(MouseEvent event) {
		
		if (emailTF.getText().isEmpty() || passwordTF.getText().isEmpty()) 
			incorrectInfoLabel.setVisible(true);
		
	}
	
	@FXML
	public void backToMainMenu(MouseEvent event)
	{
		ViewNavigator.loadScene("Welcome to NutritionEffex", ViewNavigator.LAUNCH_SCREEN_SCENE);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			backButton.setStyle(IDLE_BACK_BUTTON_STYLE);
			backButton.setOnMouseEntered(e -> backButton.setStyle(HOVERED_BACK_BUTTON_STYLE));
			backButton.setOnMouseExited(e -> backButton.setStyle(IDLE_BACK_BUTTON_STYLE));
			
			signInButton.setStyle(IDLE_BUTTON_STYLE);
			signInButton.setOnMouseEntered(e -> signInButton.setStyle(HOVERED_BUTTON_STYLE));
			signInButton.setOnMouseExited(e -> signInButton.setStyle(IDLE_BUTTON_STYLE));
			}
			catch (NullPointerException e) {
				System.out.println("Transferring scenes");
			}
		
	}
	
	
}
