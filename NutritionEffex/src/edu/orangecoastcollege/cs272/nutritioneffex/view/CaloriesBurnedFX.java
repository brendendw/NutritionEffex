package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JComboBox;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CaloriesBurnedFX extends Application{
	
	  ObservableList<String> options = 
FXCollections.observableArrayList(
    		"Run",
    		"Walk",
    		"Swim", 
    		"Bike",
    		"Surf", 
    		"Standing",
    		"Rockclimbing"
    );
final ComboBox workoutTypesCB = new ComboBox(options);
	 
	
	
	
	
    private Slider mDurationSlider = new Slider(0,60,0);

	 private TextField mWorkoutTypeTF = new TextField();
	 private TextField mTotalCalsTF = new TextField();

	    
	    private Button mClearButton = new Button("Clear");
	    private Button mCalculateButton = new Button("Calculate");

	    private GridPane mGridPane = new GridPane();

	    public static void main(String[] args)
	    {

	        //to launch a java FX application
	        Application.launch(args);

	    }
	    public void start(Stage primaryStage) throws Exception{
	    	
	    	mTotalCalsTF.setEditable(false);
	    	
	    	mDurationSlider.setShowTickLabels(true);
		    mDurationSlider.setShowTickMarks(true);
		    
		    //change the increments of the tick marks
		    mDurationSlider.setBlockIncrement(5);
		    mDurationSlider.setMajorTickUnit(10);
		    
		//moves slider directly to individual ticks
		    mDurationSlider.setSnapToTicks(true);
		    
	        //Fill the GridPane with all the nodes.
	        mGridPane.add(new Label("Workout Type:"), 0, 0);
	        mGridPane.add(workoutTypesCB, 1, 0);

	        mGridPane.add(new Label("Duration (minutes):"), 0, 1);
	        mGridPane.add(mDurationSlider, 1, 1);
	        

	        mGridPane.add(new Label("Total Calories Burned:"), 0, 4);
	        mGridPane.add(mTotalCalsTF, 1, 4);


	        mGridPane.add(mClearButton, 0, 5);
	        mGridPane.add(mCalculateButton, 1, 5);

	        // Define Event Handler for each button when they are clicked
	        mClearButton.setOnAction(e -> clear());
	        mCalculateButton.setOnAction(e -> calculate());


	        //Align the GridPane to be center.
	        mGridPane.setAlignment(Pos.CENTER);
	        mGridPane.setHgap(5);
	        mGridPane.setVgap(5);

	        mWorkoutTypeTF.setAlignment(Pos.CENTER_RIGHT);
	        
	        mClearButton.setAlignment(Pos.CENTER_RIGHT);
	mCalculateButton.setAlignment(Pos.CENTER_RIGHT);


	        //After making the GridPane, add it to the new scene

	        Scene scene = new Scene(mGridPane,400,250 );
	        //add the scene to the stage~!
	        primaryStage.setTitle("Calories Burned");
	        primaryStage.setScene(scene);
	        primaryStage.show();

	    }
		private Object calculate() {
			//these calculations are based on average rigor.
			double totalcals = 0;
			double calsperhour = 0;
			String activity = workoutTypesCB.getValue().toString();
			double duration = mDurationSlider.getValue();
			
			
			//Standing - 114 calories per hour.
		if( activity.equalsIgnoreCase("Standing"))
			calsperhour = 114;
		
			//swimming- about 500 per hour and biking - about 500
		else if(activity.equalsIgnoreCase("Swimming") ||activity.equalsIgnoreCase("Biking") )
			calsperhour = 500;
		
			//walking- 170 per hour
		else if(activity.equalsIgnoreCase("Walking"))
			calsperhour = 170;
		
			//running- 400 an hour
		else if(activity.equalsIgnoreCase("Running"))
			calsperhour = 400;
		
		//surfing-about 350
		else if(activity.equalsIgnoreCase("Surfing")) 
			calsperhour = 350;
	
			//rockclimbing-500 to 900 calories per hour
		else
			calsperhour = 650;
		
		
		
			totalcals = calsperhour * duration/60;
			DecimalFormat twoDPs = new DecimalFormat("##.##");
mTotalCalsTF.setText(String.valueOf(twoDPs.format(totalcals)));
			 
			return null;
		}
		private Object clear() {
			mWorkoutTypeTF.clear();
			mTotalCalsTF.clear();
			
			mDurationSlider.setValue(0);
			
			return null;
		}
	}


