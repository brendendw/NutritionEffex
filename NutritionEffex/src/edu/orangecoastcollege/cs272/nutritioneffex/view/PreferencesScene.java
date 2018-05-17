package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import edu.orangecoastcollege.cs272.sdowdle.capstone.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class PreferencesScene 
{
	private static Controller controller = Controller.getInstance();
	
	@FXML
	private ListView preferencesLV;
	@FXML
	private ComboBox preferencesCB;
	@FXML
	private Button deletePreferenceButton;

	// Event Listener on Button.onAction
	@FXML
	public void loadDRMainMenu(ActionEvent event)
	{
		ViewNavigator.loadScene("Dietary Restictions", ViewNavigator.DR_MAIN_MENU_SCENE);
	}
	// Event Listener on ListView[#preferencesLV].onMouseClicked
	@FXML
	public void selectPreference(MouseEvent event)
	{
		// TODO Autogenerated
	}
	// Event Listener on ComboBox[#preferencesCB].onAction
	@FXML
	public void addPreference(ActionEvent event) 
	{
		// TODO Autogenerated
	}
	// Event Listener on Button[#deletePreferenceButton].onAction
	@FXML
	public void deletePreference(ActionEvent event) 
	{
		// TODO Autogenerated
	}
}
