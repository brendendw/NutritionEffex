package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Slider;

import javafx.scene.control.ComboBox;

import javafx.scene.input.MouseEvent;

public class CaloriesBurnedCalculator extends CaloriesBurnedFX{
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox activityComboBox; 
	
	@FXML
	private Slider DurationSlider;
	@FXML
	private TextField totalCaloriesTF;
	@FXML
	private Button calculateButton;
	@FXML
	private Button clearButton;
	@FXML
	private Button backtoCalculatorsButton;

	// Event Listener on ComboBox[#activityComboBox].onAction
	@SuppressWarnings("unchecked")
	@FXML
	public void comboboxselected(ActionEvent event) {
		/*ObservableList<String> options = 
			FXCollections.observableArrayList(
			    		"Run",
			    		"Walk",
			    		"Swim", 
			    		"Bike",
			    		"Surf", 
			    		"Standing",
			    		"Rockclimbing"
			    );// 
		activityComboBox= new ComboBox<String>(options);
		*/
	}
	// Event Listener on Slider[#DurationSlider].onMouseDragged
	@FXML
	public void mousedragged(MouseEvent event) {
		
	}
	// Event Listener on Button[#calculateButton].onAction
	@FXML
	public void calculate(ActionEvent event) {
		double totalcals = 0;
		double calsperhour = 0;
		String activity = activityComboBox.getValue().toString();
		double duration = DurationSlider.getValue();
		
		/*
		 * switch (goalWeightCB.getSelectionModel().getSelectedIndex())
		{
		// lose weight
		case 0: 
			result-=500;
			break;
		// gain weight
		case 1:
			result += 500;
			break;
		default:
		// maintain weight
			break;
		}
		
		 */
		
		//Standing - 114 calories per hour.
	if( activity.equalsIgnoreCase("Standing"))
		calsperhour = 114;
	
		//swimming- about 500 per hour and biking - about 500
	else if(activity.equalsIgnoreCase("Swimming") ||activity.equalsIgnoreCase("Biking") )
		calsperhour = 500;
	
		//walking- 170 per hour
	else if(activity.equalsIgnoreCase("Walking"))
		calsperhour = 170;
	
		//running- 400 an hour
	else if(activity.equalsIgnoreCase("Running"))
		calsperhour = 400;
	
	//surfing-about 350
	else if(activity.equalsIgnoreCase("Surfing")) 
		calsperhour = 350;

		//rockclimbing-500 to 900 calories per hour
	else
		calsperhour = 650;
	
		totalcals = calsperhour * duration/60;
		DecimalFormat twoDPs = new DecimalFormat("##.##");
totalCaloriesTF.setText(String.valueOf(twoDPs.format(totalcals)));
		 	}
	
	// Event Listener on Button[#clearButton].onAction
	@FXML
	public void clear(ActionEvent event) {
	
		totalCaloriesTF.clear();
		
		DurationSlider.setValue(0);	}
	
	// Event Listener on Button[#backtoCalculatorsButton].onAction
	@FXML
	public void backtoCalculatorsMenu(ActionEvent event) {
ViewNavigator.loadScene("Calculators Main Menu", ViewNavigator.CALCULATOR_MENU_SCENE);
	}
}
