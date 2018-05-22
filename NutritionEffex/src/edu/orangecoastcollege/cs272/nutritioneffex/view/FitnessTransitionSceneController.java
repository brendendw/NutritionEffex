package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

public class FitnessTransitionSceneController {
	@FXML
	private Button CaloriesBurnedButton;
	@FXML
	private Button workoutlogButton;
	@FXML
	private Button backButton;

	// Event Listener on Button[#CaloriesBurnedButton].onAction
	@FXML
	public void loadCaloriesBurnedCalculator(ActionEvent event) {
		ViewNavigator.loadScene("Calories Burned",ViewNavigator.CALORIES_BURNED_SCENE);
	}
		//ViewNavigator.loadScene("Calories Burned", ViewNavigator.CALORIES_BURNED_SCENE);	}
	// Event Listener on Button[#workoutlogButton].onAction
	@FXML
	public void loadWorkoutLogButton(ActionEvent event) {
		
	}
		//ViewNavigator.loadScene("Workout Log", ViewNavigator.WORKOUT_LOG_SCENE);	}
	// Event Listener on Button[#backButton].onAction
	@FXML
	public void loadCalculatorsMenu(ActionEvent event) {
		ViewNavigator.loadScene("Calculators Menu",ViewNavigator.CALCULATOR_MENU_SCENE);
	}
}
