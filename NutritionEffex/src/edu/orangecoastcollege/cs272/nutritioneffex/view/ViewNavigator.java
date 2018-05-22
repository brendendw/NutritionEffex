package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * This class is responsible for loading scenes in order
 * for the user to navigate through multiple scenes.
 * @author Sean Dowdle, . . .
 *
 */
public class ViewNavigator 
{
	/*~~~~~~~~~~~~~~~~~~~~~~~~ Sean's Scenes ~~~~~~~~~~~~~~~~~~~~~~~~*/
	public static final String DR_MAIN_MENU_SCENE = "DRMainMenuScene.fxml";
	public static final String FAVORITE_FOODS_SCENE = "FavoriteFoodsScene.fxml";
	public static final String FOOD_DETAILS_SCENE = "FoodDetailsScene.fxml";
	public static final String FOOD_SCENE = "FoodScene.fxml";
	public static final String PREFERENCES_SCENE = "PreferencesScene.fxml";
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~ [  Sydney's Scenes ] ~~~~~~~~~~~~~~~~~~~~~~~~*/
	//public static final String MAIN_MENU_SCENE = "MainMenuScene.fxml";
	public static final String CALORIES_BURNED_SCENE = "CaloriesBurnedFX.java";
	public static final String BMI_CALCULATOR_SCENE = "BMICalculatorScene.fxml";
	public static final String DAILY_WATER_INTAKE_SCENE = "WaterIntakeFX.java";
	public static final String OLYMPIC_POTENTIAL_SCENE = "OlympicAthleteFX.fxml";
	public static final String WORKOUT_LOG_SCENE = "WorkoutLogFX.java";


	/*~~~~~~~~~~~~~~~~~~~~~~~~ [ Brenden's Scenes] ~~~~~~~~~~~~~~~~~~~~~~~~*/
	public static final String LAUNCH_SCREEN_SCENE = "LaunchScene.fxml";
	public static final String CALCULATOR_MENU_SCENE = "CalculatorMenu.fxml"; // Sydney did this one as well
	public static final String ACCOUNT_SETTINGS_SCENE = "AccountSettings.fxml";
	public static final String CALORIE_CALCULATOR_SCENE = "CalorieCalculator.fxml";
	public static final String CALORIE_CALCULATOR_RESULTS_SCENE = "CalorieResults.fxml";
	public static final String SIGN_UP_SCENE = "SignUpScene.fxml";
	public static final String SIGN_IN_SCENE = "SignInScene.fxml";
	public static final String ALTERNATE_MAIN_MENU_SCENE = "AlternateMainMenu.fxml";

	/*~~~~~~~~~~~~~~~~~~~~~~~~ END OF CONSTANTS ~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static Stage mainStage;
	/**
	 * Sets the stage for the GUI application.
	 * @param stage The new stage to set.
	 */
	public static void setStage(Stage stage)
	{
		mainStage = stage;
	}
	/**
	 * Loads the scene from the fxml file and sets the 
	 * window title.
	 * @param title The title to set on the window
	 * @param sceneFXML The fxml file to load from
	 */
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