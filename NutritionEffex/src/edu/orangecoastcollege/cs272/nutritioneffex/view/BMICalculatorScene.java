package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.text.DecimalFormat;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.event.ActionEvent;

public class BMICalculatorScene {
	private static Controller controller = Controller.getInstance();

	@FXML
	private Button backButton;
	@FXML
	private Button CalculateButton;
	@FXML
	private Button clearButton;
	@FXML
	private TextField weightTF;
	@FXML
	private TextField heightTF;
	@FXML
	private TextField BMITF;

	// Event Listener on Button[#backButton].onAction
	@FXML
	public void back(ActionEvent event) {
	ViewNavigator.loadScene("Calculators",ViewNavigator.CALCULATOR_MENU_SCENE);
	}
	// Event Listener on Button[#CalculateButton].onAction
	@FXML
	public void calculate(ActionEvent event) {
		/*How to calculate BMI:
		 * 1.Multiply the weight in pounds by 0.45 (the metric conversion factor)
2. Multiply the height in inches by 0.025 (the metric conversion factor)
3. Square the answer from step 2
4.Divide the answer from step 1 by the answer from step 3
		 */
		double weight= Double.parseDouble(weightTF.getText());
		double height = Double.parseDouble(heightTF.getText());
		
		double tokg = weight * 0.45;
		double tometers = height *0.025;
		double actualBMI = tokg/tometers/tometers;
		

		DecimalFormat oneDP = new DecimalFormat("#.#");

		
		BMITF.setText(oneDP.format(actualBMI));
	}
	// Event Listener on Button[#clearButton].onAction
	@FXML
	public void clear(ActionEvent event) {
		weightTF.clear();
		 heightTF.clear();
		BMITF.clear();
	}
}
