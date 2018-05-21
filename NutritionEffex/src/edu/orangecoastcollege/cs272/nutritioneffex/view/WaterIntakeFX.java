package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WaterIntakeFX extends Application{

	 private Slider mActivityLevelSlider = new Slider(0,4,1);

	 private TextField mWeightTF = new TextField();
	 private TextField mWaterTF = new TextField();

	    
	    private Button mClearButton = new Button("Clear");
	    private Button mCalculateButton = new Button("Calculate");

	    private GridPane mGridPane = new GridPane();

	    public static void main(String[] args)
	    {

	        //to launch a java FX application
	        Application.launch(args);

	    }
	    public void start(Stage WaterIntakeStage) throws Exception{
	    	mActivityLevelSlider.setShowTickLabels(true);
	    	mActivityLevelSlider.setShowTickMarks(true);
		    //change the increments of the tick marks
	    	mActivityLevelSlider.setBlockIncrement(1);
	    	mActivityLevelSlider.setMajorTickUnit(1);
		//moves slider directly to individual ticks
	    	mActivityLevelSlider.setSnapToTicks(true);
	        //Fill the GridPane with all the nodes.
	        mGridPane.add(new Label("Enter Weight(lbs):"), 0, 0);
	        mGridPane.add(mWeightTF, 1, 0);

	        mGridPane.add(new Label("Activeness(30 minute intervals)"), 0, 1);
	        mGridPane.add(mActivityLevelSlider, 1, 1);


	        

	        mGridPane.add(new Label("Ideal Daily Water Intake:(oz)"), 0, 4);
	        mGridPane.add(mWaterTF, 1, 4);


	        mGridPane.add(mClearButton, 0, 5);
	        mGridPane.add(mCalculateButton, 1, 5);

	        // Define Event Handler for each button when they are clicked
	        mClearButton.setOnAction(e -> clear());
	        mCalculateButton.setOnAction(e -> calculate());


	        //Align the GridPane to be center.
	        mGridPane.setAlignment(Pos.CENTER);
	        mGridPane.setHgap(5);
	        mGridPane.setVgap(5);

	        mWeightTF.setAlignment(Pos.CENTER_RIGHT);
	        
	        mClearButton.setAlignment(Pos.CENTER_RIGHT);
	        mCalculateButton.setAlignment(Pos.CENTER_RIGHT);



	        mWaterTF.setEditable(false);
	        mWaterTF.setFocusTraversable(false);
	        //After making the GridPane, add it to the new scene

	        Scene scene = new Scene(mGridPane,400,250 );
	        //add the scene to the stage~!
	        WaterIntakeStage.setTitle("Water Intake Calculator for Optimal Health");
	        WaterIntakeStage.setScene(scene);
	        WaterIntakeStage.show();

	    }
		private Object calculate() {
/*Activity Level: Finally you will want to adjust that 
 * number based on how often you work out, since you are 
 * expelling water when you sweat. You should add 12 ounces of 
 * water to your daily total for every 30 minutes that you work
 *  out.
 */
			double weight= Double.parseDouble(mWeightTF.getText());
		
			double activitylevel = mActivityLevelSlider.getValue();
			
			double zeroEx = 2 *weight/3;
			double extra = activitylevel * 12;
			double ounces = zeroEx + extra;
			
			DecimalFormat oneDP = new DecimalFormat("#.#");
			
			mWaterTF.setText(oneDP.format(ounces));
			
			return null;
		}
		private Object clear() {
mWeightTF.clear();
mWaterTF.clear();

//reset the buttons.
mActivityLevelSlider.setValue(0);
mWeightTF.requestFocus();

			return null;
		}
	    
	




}
