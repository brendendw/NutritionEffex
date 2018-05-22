package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import edu.orangecoastcollege.cs272.nutritioneffex.model.*;
import edu.orangecoastcollege.cs272.nutritioneffex.view.ViewNavigator;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
/**
 * This scene serves as a browser showing all the
 * available foods the user can consume based on their
 * preferences. The scene provides many different filtering
 * options.
 * @author Sean Dowdle
 *
 */
public class FoodScene implements Initializable
{
	private static Controller controller = Controller.getInstance();
	@FXML
	private ListView<Food> availableFoodsLV;
	@FXML
	private CheckBox excludedItemsCB;
	@FXML
	private CheckBox ulfilteredResultsCB;
	@FXML
	private CheckBox filterNameCB;
	@FXML
	private CheckBox filterCaloriesCB;
	@FXML
	private CheckBox filterSatFatsCB;
	@FXML
	private CheckBox filterAddedSugarsCB;
	@FXML
	private Button addToFavoritesButton;
	@FXML
	private Button backButton;

	/**
	 * Enables / Disables the the buttons based on
	 * if the ListView is focused or not.
	 */
	@FXML
	public void selectFood()
	{
		if(availableFoodsLV.isFocused())
			addToFavoritesButton.setDisable(false);
		else
			addToFavoritesButton.setDisable(true);
	}
	/**
	 * This method is responsible for filtering through all
	 * of the foods in the database and listing only those that
	 * were excluded from the users diet. It also disables all of
	 * the other checkboxes.
	 */
	@FXML
	public void filterExcludedItems()
	{
		ulfilteredResultsCB.setSelected(false);
		filterCaloriesCB.setSelected(false);
		filterSatFatsCB.setSelected(false);
		filterAddedSugarsCB.setSelected(false);
		filterNameCB.setSelected(false);
		ObservableList<Food> filteredFoods;
		filteredFoods = controller.filterExcluded(controller.getAllFoods(), controller.getAllPreferences());
		if(!excludedItemsCB.isSelected())
			filteredFoods = controller.filterOnPreferences(controller.getAllFoods(), controller.getAllPreferences());
		availableFoodsLV.setItems(filteredFoods);
	}
	/**
	 * This method is responsible for showing the user all of the foods
	 * in the database unfiltered. It also disabless all of the other
	 * checkboxes.
	 */
	@FXML
	public void unfilter() 
	{
		filterNameCB.setSelected(false);
		filterCaloriesCB.setSelected(false);
		filterSatFatsCB.setSelected(false);
		filterAddedSugarsCB.setSelected(false);
		excludedItemsCB.setSelected(false);
		ObservableList<Food> foods = controller.getAllFoods();
		if(!ulfilteredResultsCB.isSelected())
			foods = controller.filterOnPreferences(controller.getAllFoods(), controller.getAllPreferences());
		availableFoodsLV.setItems(foods);
	}
	/**
	 * This method is responsible for filtering through all of
	 * the available foods in alphabetical order by name.
	 */
	@FXML
	public void filterFoodsByName() 
	{
		ulfilteredResultsCB.setSelected(false);
		filterCaloriesCB.setSelected(false);
		filterSatFatsCB.setSelected(false);
		filterAddedSugarsCB.setSelected(false);
		excludedItemsCB.setSelected(false);
		ObservableList<Food> foods = controller.filterOnPreferences(controller.getAllFoods(), controller.getAllPreferences());
		
		if(filterNameCB.isSelected())
			Collections.sort(foods, new SortFoodByName());
		
		availableFoodsLV.setItems(foods);
	}
	/**
	 * This method is responsible for filtering through all of 
	 * the available foods in increasing order of calories.
	 */
	@FXML
	public void filterFoodsByCalories() 
	{
		filterNameCB.setSelected(false);
		ulfilteredResultsCB.setSelected(false);
		filterSatFatsCB.setSelected(false);
		filterAddedSugarsCB.setSelected(false);
		excludedItemsCB.setSelected(false);
		ObservableList<Food> foods = controller.filterOnPreferences(controller.getAllFoods(), controller.getAllPreferences());
		
		if(filterCaloriesCB.isSelected())
			Collections.sort(foods, new SortFoodByCalories());
		
		availableFoodsLV.setItems(foods);
	}
	/**
	 * This method is responsible for filter through all of 
	 * the available foods in increasing order of saturated fats.
	 */
	@FXML
	public void filterFoodsBySatFats() 
	{
		ulfilteredResultsCB.setSelected(false);
		filterCaloriesCB.setSelected(false);
		filterAddedSugarsCB.setSelected(false);
		excludedItemsCB.setSelected(false);
		filterNameCB.setSelected(false);
		ObservableList<Food> foods = controller.filterOnPreferences(controller.getAllFoods(), controller.getAllPreferences());
		
		if(filterSatFatsCB.isSelected())
			Collections.sort(foods, new SortFoodBySaturatedFats());
		
		availableFoodsLV.setItems(foods);
	}
	/**
	 * This method is responsible for filter through all of 
	 * the available foods in increasing order of added sugars.
	 */
	@FXML
	public void filterFoodsByAddedSugars() 
	{
		ulfilteredResultsCB.setSelected(false);
		filterCaloriesCB.setSelected(false);
		filterSatFatsCB.setSelected(false);
		excludedItemsCB.setSelected(false);
		filterNameCB.setSelected(false);
		ObservableList<Food> foods = controller.filterOnPreferences(controller.getAllFoods(), controller.getAllPreferences());
		
		if(filterAddedSugarsCB.isSelected())
			Collections.sort(foods, new SortFoodByAddedSugars());
		
		availableFoodsLV.setItems(foods);
	}
	/**
	 * Adds the selected Food item from the ListView and adds it
	 * to the FavoriteFoods database.
	 * @return a boolean based on whether or not the food item was successfully added
	 */
	@FXML
	public boolean addToFavoriteFoods() 
	{
		Food selected = availableFoodsLV.getSelectionModel().getSelectedItem();
		addToFavoritesButton.setDisable(false);
		
		return controller.addFoodToFavorites(selected);
	}
	/**
	 * Calls ViewNavigator to load and go back to
	 * the Dietary Restriction main menu.
	 */
	@FXML
	public void loadDRMainMenu() 
	{
		ViewNavigator.loadScene("Dietary Restictions", ViewNavigator.DR_MAIN_MENU_SCENE);
	}
	/**
	 * Initializes the scene's ListView when the scene is loaded.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		ObservableList<Food> filteredFoods = controller.filterOnPreferences(controller.getAllFoods(), controller.getAllPreferences());
		availableFoodsLV.setItems(filteredFoods);
	}
}
