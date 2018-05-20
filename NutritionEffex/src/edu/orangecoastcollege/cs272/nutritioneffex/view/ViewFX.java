package edu.orangecoastcollege.cs272.sdowdle.capstone.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class ViewFX extends Application 
{

	@Override
	public void start(Stage primaryStage) throws Exception 
	{		
		// Set stage only needs to be called once for the view navigator
		ViewNavigator.setStage(primaryStage);
		ViewNavigator.loadScene("Dietary Restrictions", ViewNavigator.DR_MAIN_MENU_SCENE);
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}