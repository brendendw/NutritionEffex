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

public class SignUpSceneController implements Initializable {
	
	private static Controller controller = Controller.getInstance();
	
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
	public void signUp(MouseEvent event) {
		if (emailTF.getText().isEmpty() || passwordTF.getText().isEmpty() || ageCB.getChildrenUnmodifiable().isEmpty()
				|| genderCB.getChildrenUnmodifiable().isEmpty() || nameTF.getText().isEmpty()) 
			incorrectInfoLabel.setVisible(true);
		
		String name = nameTF.getText();
		String email = emailTF.getText();
		String password = passwordTF.getText();
		String gender = (String) genderCB.getSelectionModel().getSelectedItem();
		int age = ageCB.getSelectionModel().getSelectedIndex() + 13;
		
		String result = controller.signUpUser(name, email, password, 24, "male");
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
			backButton.setStyle(IDLE_BACK_BUTTON_STYLE);
			backButton.setOnMouseEntered(e -> backButton.setStyle(HOVERED_BACK_BUTTON_STYLE));
			backButton.setOnMouseExited(e -> backButton.setStyle(IDLE_BACK_BUTTON_STYLE));
			
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
