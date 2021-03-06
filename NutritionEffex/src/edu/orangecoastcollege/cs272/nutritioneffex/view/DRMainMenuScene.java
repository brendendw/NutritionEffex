package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * This is the main menu scene for the
 * Dietary Restictions portion of the app.
 * It has buttons to navigate you to different
 * pages.
 * @author Sean Dowdle
 *
 */
public class DRMainMenuScene 
{
	@FXML
	private Button backToMainMenuButton;
	@FXML
	private Button preferencesSceneButton;
	@FXML
	private Button foodSceneButton;
	@FXML
	private Button favoriteFoodsSceneButton;
	/**
	 * Calls ViewNavigator to load and go back to
	 * the main menu.
	 */
	@FXML
	public void loadMainMenuScene() 
	{
		ViewNavigator.loadScene("Main Menu", ViewNavigator.ALTERNATE_MAIN_MENU_SCENE); // Might need to change if this is a temporary main menu.
	}
	/**
	 * Calls ViewNavigator to load and go to the
	 * user preferences scene.
	 */
	@FXML
	public void loadUpdatePreferences()
	{
		ViewNavigator.loadScene("User Preferences", ViewNavigator.PREFERENCES_SCENE);
	}
	/**
	 * Calls ViewNavigator to load and go to the
	 * foods browser scene.
	 */
	@FXML
	public void loadFoods()
	{
		ViewNavigator.loadScene("Foods", ViewNavigator.FOOD_SCENE);
	}
	/**
	 * Calls ViewNavigator to load and go to the
	 * favorite foods scene.
	 */
	@FXML
	public void loadFavoriteFoods()
	{
		ViewNavigator.loadScene("Favorite Foods", ViewNavigator.FAVORITE_FOODS_SCENE);
	}
}
