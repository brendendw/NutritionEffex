package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * This class acts as the launching point of our application.
 * It is responsible for launching the application to our main
 * menu.
 * @author Sean Dowdle, . . .
 *
 */
public class ViewFX extends Application 
{
	/**
	 * Sets up the initial stage for the home sceen.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{		
		// Set stage only needs to be called once for the view navigator
		primaryStage.setMaxHeight(420);
		primaryStage.setMaxWidth(420);
		ViewNavigator.setStage(primaryStage);
		ViewNavigator.loadScene("Welcome to NutritionEffex", ViewNavigator.LAUNCH_SCREEN_SCENE);
		// Cannot get screen to show image; will be blank for now
		// LaunchSceneController launch = new LaunchSceneController();
		// launch.showImage();
	}
	/**
	 * Launches the application.
	 * @param args The arguments to pass to the main method.
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	
}