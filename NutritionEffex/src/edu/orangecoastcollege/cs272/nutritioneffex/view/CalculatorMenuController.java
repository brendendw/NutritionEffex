package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

/**
 * Allows user to traverse through different nutrition calculators.
 * @author brendendrew
 *
 */
public class CalculatorMenuController  extends SeamlessViewFX implements Initializable {
	
	Controller controller = Controller.getInstance();
	@FXML
	private ImageView backgroundImage;
	@FXML
	private Label WaterIntakeButton;
	@FXML
	private Label CalorieCalculatorButton;
	@FXML
	private Label BMIButton;
	@FXML
	private Label FitnessButton;
	@FXML
	private ImageView backButton;

	// Event Listener on Label[#WaterIntakeButton].onMouseClicked
	@FXML
	public void loadWaterIntakeScene(MouseEvent event) {
		ViewNavigator.loadScene("Daily Water Intake", ViewNavigator.DAILY_WATER_INTAKE_SCENE);
	}
	// Event Listener on Label[#CalorieCalculatorButton].onMouseClicked
	@FXML
	public void loadCalorieCalculator(MouseEvent event) {
		
		ViewNavigator.loadScene("Calorie Calculator", ViewNavigator.CALORIE_CALCULATOR_SCENE);
	}
	// Event Listener on Label[#BMIButton].onMouseClicked
	@FXML
	public void loadBMIScene(MouseEvent event) {
ViewNavigator.loadScene("BMI Calculator", ViewNavigator.BMI_CALCULATOR_SCENE);
	}
	// Event Listener on Label[#FitnessButton].onMouseClicked
	@FXML
	public void loadFitnessOptions(MouseEvent event) {
		ViewNavigator.loadScene("Fitness Options",ViewNavigator.CALORIES_BURNED_SCENE);
	}
	
	// Scales a button up when a mouse is hovered over
		@FXML
		public void scaleUp(MouseEvent event) {
			
			if (WaterIntakeButton.isHover())  
			{
				WaterIntakeButton.setScaleX(1.05);
				WaterIntakeButton.setScaleY(1.05);
			}
			
			if (CalorieCalculatorButton.isHover())  
			{
				CalorieCalculatorButton.setScaleX(1.05);
				CalorieCalculatorButton.setScaleY(1.05);
			}
			
			if (BMIButton.isHover())  
			{
				BMIButton.setScaleX(1.05);
				BMIButton.setScaleY(1.05);
			}
			
			if (FitnessButton.isHover())  
			{
				FitnessButton.setScaleX(1.05);
				FitnessButton.setScaleY(1.05);
			}
			
			if (backButton.isHover())  
			{
				backButton.setScaleX(1.2);
				backButton.setScaleY(1.2);
			}
			
		}
		
		// Scales a button down when the mouse exits
		@FXML
		public void scaleDown(MouseEvent event) {

			WaterIntakeButton.setScaleX(1.00);
			WaterIntakeButton.setScaleY(1.00);
		
			CalorieCalculatorButton.setScaleX(1.00);
			CalorieCalculatorButton.setScaleY(1.00);
			
			BMIButton.setScaleX(1.00);
			BMIButton.setScaleY(1.00);

			FitnessButton.setScaleX(1.00);
			FitnessButton.setScaleY(1.00);

			backButton.setScaleX(1.00);
			backButton.setScaleY(1.00);

			
		}
	@FXML
	public void backToMainMenu() 
	{
		ViewNavigator.loadScene("Main Menu", ViewNavigator.ALTERNATE_MAIN_MENU_SCENE);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			backButton.setStyle(NORMAL_SCALE);
			backButton.setOnMouseEntered(e -> backButton.setStyle(SCALE_UP));
			backButton.setOnMouseExited(e -> backButton.setStyle(NORMAL_SCALE));
			backButton.setOnMousePressed(e -> backButton.setStyle(NORMAL_SCALE));

			
		}
		catch (NullPointerException e) {
			System.out.println("Transferring scenes");
		}
		
	}
	
	
	
}
