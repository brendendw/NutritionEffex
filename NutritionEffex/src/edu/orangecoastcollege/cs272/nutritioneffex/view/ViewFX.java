package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.application.Application;
import javafx.stage.Stage;
/*
 * ViewFX is responsible for launching the
 * application and bringing it to our main menu.
 */
public class ViewFX extends Application 
{

	@Override
	public void start(Stage primaryStage) throws Exception 
	{		
		// Set stage only needs to be called once for the view navigator
		ViewNavigator.setStage(primaryStage);
		ViewNavigator.loadScene("Main Menu", ViewNavigator.DR_MAIN_MENU_SCENE); // Change the .DR_MAIN_MENU_SCENE to the actual main menu constant when done. That should be the only the we have to do to this file.
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}