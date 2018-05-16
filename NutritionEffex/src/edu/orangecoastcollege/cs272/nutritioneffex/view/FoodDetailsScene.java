package edu.orangecoastcollege.cs272.nutritioneffex.view;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class FoodDetailsScene 
{
	private static Controller controller = Controller.getInstance();
	
	@FXML
	private Button backButton;
	@FXML
	private Label name;
	@FXML
	private Label portion;
	@FXML
	private Label calories;
	@FXML
	private Label addedSugars;
	@FXML
	private Label saturatedFats;
	@FXML
	private Label solidFats;
	@FXML
	private Label alcohol;

	// Event Listener on Button[#backButton].onAction
	@FXML
	public void loadFavoriteFoodsScene(ActionEvent event) 
	{
		ViewNavigator.loadScene("Dietary Restictions", ViewNavigator.FAVORITE_FOODS_SCENE);
	}
	
	public void populateTextFieldData()
	{
		// TODO Populate the text field data from the database
	}
}
