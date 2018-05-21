package edu.orangecoastcollege.cs272.nutritioneffex.view;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import edu.orangecoastcollege.cs272.nutritioneffex.model.*;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
/**
 * This scene is responsible for showing the user 
 * all of their saved preferences. It also allows them
 * to add or delete preferences.
 * @author Sean Dowdle
 *
 */
public class PreferencesScene implements Initializable
{
	private static Controller controller = Controller.getInstance();
	
	@FXML
	private ListView<Preference> preferencesLV;
	@FXML
	private ComboBox<String> preferencesCB;
	@FXML
	private Button deletePreferenceButton;
	
	
	/**
	 * Calls ViewNavigator to load and go back to
	 * the Dietary Restrictions main menu.
	 */
	@FXML
	public void loadDRMainMenu()
	{
		ViewNavigator.loadScene("Dietary Restictions", ViewNavigator.DR_MAIN_MENU_SCENE);
	}
	/**
	 * Enables / Disables the delete button based on if
	 * the ListView is focused or not.
	 */
	@FXML
	public void selectPreference()
	{
		if(preferencesLV.isFocused())
			deletePreferenceButton.setDisable(false);
		else
			deletePreferenceButton.setDisable(true);
	}
	/**
	 * Adds the selected preference to the preferences database and ListView.
	 * @return a boolean based on if the preference was successfully added
	 */
	@FXML
	public boolean addPreference() 
	{
		String selection = preferencesCB.getSelectionModel().getSelectedItem();
		if(!selection.equals("--- Select ---"))
			return controller.addPreferenceToPreferences(selection);
		else
			return false;
	}
	/**
	 * Deletes the selected preference from the ListView and preferences database.
	 * @return a boolean based on if the preference was successfully deleted.
	 */
	@FXML
	public boolean deletePreference() 
	{
		Preference selected = preferencesLV.getSelectionModel().getSelectedItem();
		deletePreferenceButton.setDisable(true);
		
		return controller.deletePreferencesFromPrefrenceDB(selected);
	}
	/**
	 * Initializes the scene's ListView when the scene is loaded.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		preferencesLV.setItems(controller.getAllPreferences());
		preferencesCB.setItems(controller.getAllPreferencesCB());
		preferencesCB.getSelectionModel().selectFirst();
	}
}
