package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 * View that allows the user to sign into the application, given their information is currently in the database.
 * @author brendendrew
 *
 */
public class SignInSceneController extends SeamlessViewFX implements Initializable {
	
	private static Controller controller = Controller.getInstance();
	public FadeTransition fadeOut = new FadeTransition(Duration.millis(4000));

	@FXML
	private ImageView backgroundImage;
	@FXML
	private Label signInButton;
	@FXML
	private TextField emailTF;
	@FXML
	private PasswordField passwordPF;
	
	@FXML 
	private Label incorrectInfoLabel;
	
	@FXML
	private ImageView backButton;

	// Event Listener on Label[#signInButton].onMouseClicked
	@FXML
	public void signIn() {
		
		if (emailTF.getText().isEmpty() || passwordPF.getText().isEmpty()) {
			
			fadeOutLabelWithText("incorrect log-in info");
	    	return;
		
		}
		// Read information from the user
		String email = emailTF.getText();
		String password = passwordPF.getText();
		
		// Attempt to log user in with email & password
		String result = controller.signInUser(email, password);
		if (result.equalsIgnoreCase("success"))
			return;
		
		// must be a way so that this doesn't have to be repeated
		fadeOutLabelWithText(result);
		
	}
	
	public void fadeOutLabelWithText(String string)
	{
		incorrectInfoLabel.setVisible(true);
		incorrectInfoLabel.setText(string);
		fadeOut.setNode(incorrectInfoLabel);
		fadeOut.setFromValue(1.0);
		fadeOut.setToValue(0.0);
    	fadeOut.setCycleCount(1);
    	fadeOut.setAutoReverse(false);
    	fadeOut.playFromStart();
	}
	
	@FXML
	public void backToMainMenu()
	{
		ViewNavigator.loadScene("Welcome to NutritionEffex", ViewNavigator.LAUNCH_SCREEN_SCENE);
	}
	
	// Allows user to sign in by pressing "Enter" or return to email by pressing
	// backspace if field is empty
	public void enterSignIn(KeyEvent e) {
		if (e.getCode() == KeyCode.ENTER) signIn();
		
		if (passwordPF.getText().isEmpty() && e.getCode() == KeyCode.BACK_SPACE) emailTF.requestFocus();
	}
	// Allows uer to go back by pressing "delete" & go to next field by pressing "enter"
	public void deleteBack(KeyEvent e) {
		if (emailTF.getText().isEmpty() && e.getCode() == KeyCode.BACK_SPACE) 
			backToMainMenu();
		
		if (e.getCode() == KeyCode.ENTER) passwordPF.requestFocus();
			
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			backButton.setStyle(NORMAL_SCALE);
			backButton.setOnMouseEntered(e -> backButton.setStyle(SCALE_UP));
			backButton.setOnMousePressed(e -> backButton.setStyle(NORMAL_SCALE));
			backButton.setOnMouseExited(e -> backButton.setStyle(NORMAL_SCALE));
			
			signInButton.setStyle(IDLE_BUTTON_STYLE);
			signInButton.setOnMouseEntered(e -> signInButton.setStyle(HOVERED_BUTTON_STYLE));
			signInButton.setOnMouseExited(e -> signInButton.setStyle(IDLE_BUTTON_STYLE));
			incorrectInfoLabel.setVisible(false);
			incorrectInfoLabel.setAlignment(Pos.CENTER);
			incorrectInfoLabel.setTextAlignment(TextAlignment.CENTER);
			emailTF.setOnKeyPressed(e -> deleteBack(e));
			passwordPF.setOnKeyPressed(e -> enterSignIn(e));

			}
			catch (NullPointerException e) {
				System.out.println("Transferring scenes");
			}
		
	}
	
	
}
