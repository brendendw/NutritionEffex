package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SignInSceneController extends SeamlessViewFX implements Initializable {
	
	private static Controller controller = Controller.getInstance();

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
		
		if (emailTF.getText().isEmpty() || passwordPF.getText().isEmpty()) 
			incorrectInfoLabel.setVisible(true);
		
		// Read information from the user
		String email = emailTF.getText();
		String password = passwordPF.getText();
		
		// If e-mail or password is empty, failed to log in; show error
		incorrectInfoLabel.setVisible(email.isEmpty() || password.isEmpty());
		if (incorrectInfoLabel.isVisible()) return;
		
		// Attempt to log user in with email & password
		String result = controller.signInUser(email, password);
		if (result.equalsIgnoreCase("success"))
		{
			// Controller transfers scene
			return;
		}
		incorrectInfoLabel.setVisible(true);
		incorrectInfoLabel.setText(result);
		
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
			backButton.setOnMouseExited(e -> backButton.setStyle(NORMAL_SCALE));
			
			signInButton.setStyle(IDLE_BUTTON_STYLE);
			signInButton.setOnMouseEntered(e -> signInButton.setStyle(HOVERED_BUTTON_STYLE));
			signInButton.setOnMouseExited(e -> signInButton.setStyle(IDLE_BUTTON_STYLE));
			incorrectInfoLabel.setVisible(false);
			
			emailTF.setOnKeyPressed(e -> deleteBack(e));
			passwordPF.setOnKeyPressed(e -> enterSignIn(e));

			}
			catch (NullPointerException e) {
				System.out.println("Transferring scenes");
			}
		
	}
	
	
}
