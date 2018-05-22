package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.text.DecimalFormat;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.control.Slider;

import javafx.scene.input.MouseEvent;

public class WaterIntakeCalculatorScene {
	@FXML
	private Label mWeightLabel;
	@FXML
	private TextField mWeightTF;
	@FXML
	private Label mActivenessLevelLabel;
	@FXML
	private Slider mActivenessLevelSlider;
	@FXML
	private Label mIdealWaterIntakeLabel;
	@FXML
	private TextField mIdealWaterIntakeTF;
	@FXML
	private Button mCalculateButton;
	@FXML
	private Button mBackButton;
	@FXML
	private Button mClearButton;

	// Event Listener on Button[#mCalculateButton].onMouseClicked
	@FXML
	public void calculateDailyWaterIntake(MouseEvent event) {
		double weight= Double.parseDouble(mWeightTF.getText());
		
		double activitylevel = mActivenessLevelSlider.getValue();
		
		double zeroEx = 2 *weight/3;
		double extra = activitylevel * 12;
		double ounces = zeroEx + extra;
		
		DecimalFormat oneDP = new DecimalFormat("#.#");
		
		mIdealWaterIntakeTF.setText(oneDP.format(ounces));
			}
	// Event Listener on Button[#mBackButton].onMouseClicked
	@FXML
	public void loadCalculators(MouseEvent event) {
		ViewNavigator.loadScene("Calculators Scene", ViewNavigator.CALCULATOR_MENU_SCENE);
	}
	// Event Listener on Button[#mClearButton].onMouseClicked
	@FXML
	public void clear(MouseEvent event) {
		mWeightTF.clear();
		mIdealWaterIntakeTF.clear();

		//reset the buttons.
		mActivenessLevelSlider.setValue(0);
		mWeightTF.requestFocus();
	}
}
