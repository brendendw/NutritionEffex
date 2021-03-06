package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

/**
 * Main menu that is shown when a user successfully logs in. Menu allows 
 * user to traverse through the applications features.
 * @author brendendrew
 *
 */
public class AlternateMainMenuController extends SeamlessViewFX implements Initializable {
	
	Controller controller = Controller.getInstance();
	@FXML
	private Label DietaryRestrictionsButton;
	@FXML
	private Label NutritionCalculatorButton;
	@FXML
	private Label FindYourOlympicAthleteButton;
	@FXML
	private Label LogOffButton;
	@FXML
	private Label UpdateAccountInfoButton;
	@FXML
	private ImageView backgroundImage;

	// Event Listener on Label[#DietaryRestrictionsButton].onMouseClicked
	@FXML
	public void loadDietaryRestrictionsMenu(MouseEvent event) 
	{
		ViewNavigator.loadScene("Dietary Restriction Main Menu", ViewNavigator.DR_MAIN_MENU_SCENE);
	}
	// Event Listener on Label[#NutritionCalculatorButton].onMouseClicked
	@FXML
	public void loadNutritionCalculatorMenu(MouseEvent event) {
		ViewNavigator.loadScene("Nutrition Calculator", ViewNavigator.CALCULATOR_MENU_SCENE);
	}
	// Event Listener on Label[#FindYourOlympicAthleteButton].onMouseClicked
	@FXML
	public void loadOlympicAthletesMenu(MouseEvent event) {
ViewNavigator.loadScene("Olympic Athletes", ViewNavigator.OLYMPIC_POTENTIAL_SCENE);
	}
	// Event Listener on Label[#LogOffButton].onMouseClicked
	@FXML
	public void logOff(MouseEvent event) {
		controller.logOffUser();		
	}
	// Scales a button up when a mouse is hovered over
	@FXML
	public void scaleUp(MouseEvent event) {
		
		if (UpdateAccountInfoButton.isHover())  
		{
			UpdateAccountInfoButton.setScaleX(1.03);
			UpdateAccountInfoButton.setScaleY(1.03);
		}
		
		if (NutritionCalculatorButton.isHover())  
		{
			NutritionCalculatorButton.setScaleX(1.03);
			NutritionCalculatorButton.setScaleY(1.03);
		}
		
		if (FindYourOlympicAthleteButton.isHover())  
		{
			FindYourOlympicAthleteButton.setScaleX(1.03);
			FindYourOlympicAthleteButton.setScaleY(1.03);
		}
		
		if (DietaryRestrictionsButton.isHover())  
		{
			DietaryRestrictionsButton.setScaleX(1.03);
			DietaryRestrictionsButton.setScaleY(1.03);
		}
		
		if (LogOffButton.isHover())  
		{
			LogOffButton.setScaleX(1.03);
			LogOffButton.setScaleY(1.03);
		}
		
	}
	
	// Scales a button down when the mouse exits
	@FXML
	public void scaleDown(MouseEvent event) {

		UpdateAccountInfoButton.setScaleX(1.00);
		UpdateAccountInfoButton.setScaleY(1.00);
	
		NutritionCalculatorButton.setScaleX(1.00);
		NutritionCalculatorButton.setScaleY(1.00);
		
		FindYourOlympicAthleteButton.setScaleX(1.00);
		FindYourOlympicAthleteButton.setScaleY(1.00);

		DietaryRestrictionsButton.setScaleX(1.00);
		DietaryRestrictionsButton.setScaleY(1.00);

		LogOffButton.setScaleX(1.00);
		LogOffButton.setScaleY(1.00);

		
	}
	// Event Listener on Label[#UpdateAccountInfoButton].onMouseClicked
	@FXML
	public void loadUpdateAccountInfoScene(MouseEvent event) {
		ViewNavigator.loadScene("Account Settings", "AccountSettings.fxml");
	}
	// Event Listener on ImageView[#backgroundImage].onMouseClicked
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			
	        Image image = new Image("welcome_background.jpeg");
	    	//this.backgroundImage = new ImageView(new Image(getClass().getResourceAsStream("/assets/imgsrc/welcome_background.jpeg")));
	        backgroundImage.setImage(image);
	        backgroundImage.setCache(true);
	        
	    } catch (Exception e) {
	        System.out.println("Couldn't find image");
	        e.printStackTrace();
	    }
		
	}
	
	
	
}
