package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator 
{
	/*~~~~~~~~~~~~~~~~~~~~~~~~ Dietary Restrictions Scenes ~~~~~~~~~~~~~~~~~~~~~~~~*/
	public static final String DR_MAIN_MENU_SCENE = "DRMainMenuScene.fxml";
	public static final String FAVORITE_FOODS_SCENE = "FavoriteFoodsScene.fxml";
	public static final String FOOD_DETAILS_SCENE = "FoodDetailsScene.fxml";
	public static final String FOOD_SCENE = "FoodScene.fxml";
	public static final String PREFERENCES_SCENE = "PreferencesScene.fxml";
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~ [  Sydney's Scenes ] ~~~~~~~~~~~~~~~~~~~~~~~~*/
	public static final String MAIN_MENU_SCENE = "MainMenuScene.fxml";
	public static final String CALCULATORS_SCENE = "CalculatorsScene.fxml";
	public static final String CALORIES_BURNED_SCENE = "CaloriesBurnedCalculatorScene.fxml";
	public static final String BMI_CALCULATOR_SCENE = "BMICalculatorScene.fxml";
	public static final String DAILY_WATER_INTAKE_SCENE = "WaterIntakeCalculatorScene.fxml";
	public static final String OLYMPIC_POTENTIAL_SCENE = "OlympicAthleticPotentialScene.fxml";


	/*~~~~~~~~~~~~~~~~~~~~~~~~ [ Brenden's Scenes] ~~~~~~~~~~~~~~~~~~~~~~~~*/

	/*~~~~~~~~~~~~~~~~~~~~~~~~ END OF CONSTANTS ~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static Stage mainStage;

	public static void setStage(Stage stage)
	{
		mainStage = stage;
	}

	public static void loadScene(String title, String sceneFXML) 
	{
		try 
		{
			mainStage.setTitle(title);
			Scene scene = new Scene(FXMLLoader.load(ViewNavigator.class.getResource(sceneFXML)));
			mainStage.setScene(scene);
			mainStage.show();
		} 
		catch (IOException e) 
		{
			System.err.println("Error loading: " + sceneFXML + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
}