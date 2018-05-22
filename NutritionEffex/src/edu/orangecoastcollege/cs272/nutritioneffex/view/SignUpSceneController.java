package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

/**
 * Allows the user to sign up to be a member of NutritionFX.
 * @author brendendrew
 *
 */
public class SignUpSceneController extends SeamlessViewFX implements Initializable {
	
	private static Controller controller = Controller.getInstance();
	
	@FXML
	private ImageView backgroundImage;
	@FXML
	private Label signUpButton;
	@FXML
	private TextField nameTF;
	@FXML
	private TextField emailTF;
	@FXML
	private Label incorrectInfoLabel;
	@FXML
	private ImageView backButton;
	@FXML
	private TextField passwordTF;
	@FXML
	private ComboBox ageCB;
	@FXML
	private ComboBox genderCB;
	
	

	// Event Listener on Label[#signUpButton].onMouseClicked
	@FXML
	public boolean signUp(MouseEvent event) {
		if (emailTF.getText().isEmpty() || passwordTF.getText().isEmpty() || ageCB.getChildrenUnmodifiable().isEmpty()
				|| genderCB.getChildrenUnmodifiable().isEmpty() || nameTF.getText().isEmpty()) 
			incorrectInfoLabel.setVisible(true);
		
		String name = nameTF.getText();
		String email = emailTF.getText();
		String password = passwordTF.getText();
		String gender = (String) genderCB.getSelectionModel().getSelectedItem();
		int age = ageCB.getSelectionModel().getSelectedIndex() + 13;
		
		String result = controller.signUpUser(name, email, password, age, gender);
		
		if  (result.equalsIgnoreCase("Success")) {
			System.out.println(result);
			incorrectInfoLabel.setVisible(false);
			ViewNavigator.loadScene("Main Menu", ViewNavigator.ALTERNATE_MAIN_MENU_SCENE);
			incorrectInfoLabel.setVisible(false);
			return true;
		}
		incorrectInfoLabel.setText(result);
		incorrectInfoLabel.setVisible(true);
		return false;
	}
	// Event Listener on ImageView[#backButton].onMouseClicked
	@FXML
	public void backToMainMenu(MouseEvent event) {
		
		ViewNavigator.loadScene("Welcome to NutritionEffex", ViewNavigator.LAUNCH_SCREEN_SCENE);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			incorrectInfoLabel.setVisible(false);
			backButton.setStyle(NORMAL_SCALE);
			backButton.setOnMouseEntered(e -> backButton.setStyle(SCALE_UP));
			backButton.setOnMouseExited(e -> backButton.setStyle(NORMAL_SCALE));
			
			signUpButton.setStyle(IDLE_BUTTON_STYLE);
			signUpButton.setOnMouseEntered(e -> signUpButton.setStyle(HOVERED_BUTTON_STYLE));
			signUpButton.setOnMouseExited(e -> signUpButton.setStyle(IDLE_BUTTON_STYLE));
			}
			catch (NullPointerException e) {
				System.out.println("Transferring scenes");
			}
		genderCB.setItems(controller.getAllGenders());
		ageCB.setItems(controller.getAllowableAges());
	}
	
}
