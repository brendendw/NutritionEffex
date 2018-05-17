package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator {
	
//sydney's scenes
	public static final String MAIN_MENU_SCENE = "MainMenuScene.fxml";
	public static final String CALCULATORS_SCENE = "CalculatorsScene.fxml";
	public static final String WATER_INTAKE_SCENE = "WaterIntakeCalculatorScene.fxml";
	public static final String CALORIES_BURNED_SCENE = "CaloriesBurnedScene.fxml";
	public static final String BMI_CALCULATOR_SCENE = "BMICalculatorScene.fxml";
//Brenden's scenes
		
	
//Sean's Scenes
		

		public static Stage mainStage;

		public static void setStage(Stage stage) {
			mainStage = stage;
		}

		public static void loadScene(String title, String sceneFXML) {

			try {
				mainStage.setTitle(title);
				Scene scene = new Scene(FXMLLoader.load(ViewNavigator.class.getResource(sceneFXML)));
				mainStage.setScene(scene);
				mainStage.show();
			} catch (IOException e) {
				System.err.println("Error loading: " + sceneFXML + "\n" + e.getMessage());
				e.printStackTrace();
			}
		}
}
