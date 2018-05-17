package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

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

	@FXML
	public void loadMainMenuScene(ActionEvent event) 
	{
		// TODO Need to use the ViewNavigator with the constant for the main menu scene once it is done.
	}
	@FXML
	public void loadUpdatePreferences()
	{
		ViewNavigator.loadScene("User Preferences", ViewNavigator.PREFERENCES_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public void loadFoods()
	{
		ViewNavigator.loadScene("Foods", ViewNavigator.FOOD_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public void loadFavoriteFoods()
	{
		ViewNavigator.loadScene("Favorite Foods", ViewNavigator.FAVORITE_FOODS_SCENE);
	}
}
