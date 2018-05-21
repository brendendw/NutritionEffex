package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import edu.orangecoastcollege.cs272.nutritioneffex.model.*;
import javafx.scene.control.ListView;
/**
 * 
 * This scene shows the user their favorite
 * foods that they have added from the foods
 * browser. The user can delete their favorite
 * foods or view more information about the food
 * in a nice breakdown.
 * @author Sean Dowdle
 *
 */
public class FavoriteFoodsScene implements Initializable
{
	private static Controller controller = Controller.getInstance();
	public static Food toDetails;
	@FXML
	private Button backButton;
	@FXML
	private ListView<Food> favoriteFoodsLV;
	@FXML
	private Button deleteButton;
	@FXML
	private Button viewDetailsButton;

	/**
	 * Calls ViewNavigator to load and go back
	 * to the Dietary Restrictions main menu.
	 */
	@FXML
	public void loadDRMainMenu() 
	{
		ViewNavigator.loadScene("Dietary Restictions", ViewNavigator.DR_MAIN_MENU_SCENE);
	}
	/**
	 * Enables / Disables the two buttons based on
	 * if the ListView is focused. Also saves the selected
	 * favorite food to be used in the FoodDetails scene
	 * to populate the Labels.
	 */
	@FXML
	public void selectFood() 
	{
		if(favoriteFoodsLV.isFocused())
		{
			deleteButton.setDisable(false);
			viewDetailsButton.setDisable(false);
			toDetails = favoriteFoodsLV.getSelectionModel().getSelectedItem();
		}
		else
		{
			deleteButton.setDisable(true);
			viewDetailsButton.setDisable(true);
		}
	}
	/**
	 * Returns the selected Food object so that it can be retrieved
	 * from the FoodDetails scene.
	 * @return toDetails The selected Food object.
	 */
	public static Food getSelectedFood()
	{
		return toDetails;
	}
	/**
	 * Deletes the selected Food from the ListView and Database.
	 * @return a boolean based on if the deletion was successful or not.
	 */
	@FXML
	public boolean deleteFavoriteFood() 
	{
		Food selected = favoriteFoodsLV.getSelectionModel().getSelectedItem();
		deleteButton.setDisable(true);
		
		return controller.deleteFromFavoriteFoods(selected);
	}
	/**
	 * Calls ViewNavigator to load and go to the
	 * FoodDetails scene.
	 */
	@FXML
	public void loadFoodDetailsScene() 
	{
		ViewNavigator.loadScene("Food Details", ViewNavigator.FOOD_DETAILS_SCENE);
	}
	/**
	 * Initializes the scene's ListView when the scene is loaded.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		favoriteFoodsLV.setItems(controller.getAllFavoriteFoods());
		
	}
}
