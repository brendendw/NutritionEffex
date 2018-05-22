package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * ViewController that allows the user to update their settings. Class calls the 
 * controller to update their settings in the database.
 * @author brendendrew
 *
 */
public class AccountSettingsController extends SeamlessViewFX implements Initializable {
	
	Controller controller = Controller.getInstance();
	public FadeTransition fadeOut = new FadeTransition(Duration.millis(3000));


	@FXML
	private ImageView backgroundImage;
	@FXML
	private Label saveButton;
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
	
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox ageCB;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox genderCB;
	
	boolean changed = false;
	boolean saved = false;
	boolean showedWarning = false;
	// Event Listener on Label[#signUpButton].onMouseClicked
	@FXML
	public void save() {
		
		if (changed == false) {
			backToMainMenu();
			return;
		}
		
		String name, email, password, gender;
		int age;
		
		email = emailTF.getText();
		if (!controller.isValidEmail(email)) {
			incorrectInfoLabel.setText("invalid e-mail!");
			incorrectInfoLabel.setVisible(true);
			return;
		}
		
		gender = (String) genderCB.getSelectionModel().getSelectedItem();
		age = ageCB.getSelectionModel().getSelectedIndex() + 13;
		
		if (gender == null || age < 13) {
			incorrectInfoLabel.setText("please fill out all fields!" );
			incorrectInfoLabel.setVisible(true);
			return;
		}
		
		name = nameTF.getText();
		password = passwordTF.getText();
		
		saved = controller.updateUserInformation(name, email, password, gender, age);
		if (saved) {
			incorrectInfoLabel.setText("information saved! ");
			incorrectInfoLabel.setVisible(true);
			
			// Fades out saved info label
			fadeOut.setNode(incorrectInfoLabel);
			fadeOut.setFromValue(1.0);
			fadeOut.setToValue(0.0);
	    	fadeOut.setCycleCount(1);
	    	fadeOut.setAutoReverse(false);
	    	fadeOut.playFromStart();
	    	return;
		}
		
		incorrectInfoLabel.setText("unknown error occurred");
	}
	// Event Listener on ImageView[#backButton].onMouseClicked
	@FXML
	public void backToMainMenu() {
		if (changed == false || showedWarning || saved)
			ViewNavigator.loadScene("Welcome to NutritionEffex", ViewNavigator.ALTERNATE_MAIN_MENU_SCENE);
		
		if (changed == true && saved == false) {
				incorrectInfoLabel.setText("changes not saved!");
				incorrectInfoLabel.setVisible(true);
				showedWarning = true;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		nameTF.setText(controller.getCurrentUser().getName());
		emailTF.setText(controller.getCurrentUser().getEmail());
		
		genderCB.setItems(controller.getAllGenders());
		ageCB.setItems(controller.getAllowableAges());
		
		// Prevents user from leaving if they haven't saved information
		
		nameTF.setOnKeyPressed(e -> setChanged());
		passwordTF.setOnKeyPressed(e -> setChanged());
		emailTF.setOnKeyPressed(e -> setChanged());
		
		incorrectInfoLabel.setVisible(false);
		
		// Shield for animations to stop attempting to trigger when the scene is transferred
		try {
			backButton.setStyle(NORMAL_SCALE);
			backButton.setOnMouseEntered(e -> backButton.setStyle(SCALE_UP));
			backButton.setOnMouseExited(e -> backButton.setStyle(NORMAL_SCALE));
			
			saveButton.setStyle(IDLE_BUTTON_STYLE);
			saveButton.setOnMouseEntered(e -> saveButton.setStyle(HOVERED_BUTTON_STYLE));
			saveButton.setOnMouseExited(e -> saveButton.setStyle(IDLE_BUTTON_STYLE));
			
			genderCB.setOnKeyPressed(e -> moveToSave(e));
			saveButton.setOnKeyPressed(e -> pressEnterToSave(e));
			
		}
		catch (NullPointerException e) {
			System.out.println("Transferring scenes");
		}
		
	}
	
	private void pressEnterToSave(KeyEvent e) {
		
		if (e.getCode() == KeyCode.ENTER) {
			saveButton.setStyle(IDLE_BUTTON_STYLE);
			save(); 
		}
	}
	private void moveToSave(KeyEvent e) {

		if (e.getCode() == KeyCode.ENTER) 
		{
			saveButton.setStyle(HOVERED_BUTTON_STYLE + "-fx-border-color: blue");
			saveButton.requestFocus();
		}
	}
	private void setChanged() {
		changed = true;
	}
	
	
}
