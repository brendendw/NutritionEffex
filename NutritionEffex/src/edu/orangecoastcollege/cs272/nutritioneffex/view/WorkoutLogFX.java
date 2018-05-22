package edu.orangecoastcollege.cs272.nutritioneffex.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.orangecoastcollege.cs272.nutritioneffex.model.Workout;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class WorkoutLogFX extends Application{
	 private ListView<String> mWorkoutsLV = new ListView<>();
	    private ObservableList<String> mWorkoutsList;
		private TextField mWorkoutTF = new TextField();
		
		//added
		private TextField mDurationTF = new TextField();
		private TextField mDateTF = new TextField();
		
		private Button mAddWorkoutButton = new Button("Add Workout");

		@Override
		public void start(Stage primaryStage) throws Exception {
		    //Observable List automatically updates the list view connectd to it.
	mWorkoutsList = FXCollections.observableArrayList();
	//connect listview with observable list
	mWorkoutsLV.setItems(mWorkoutsList);

		    createDBTable();
		    
			GridPane pane = new GridPane();
			pane.add(new Label("Workouts:"), 0, 0);		
			pane.add(mWorkoutsLV, 0, 1);
			
			
			// You can Configure the size of the list view
			//mPeopleLV.setPrefWidth(500);
			
			HBox labelBox = new HBox();
			labelBox.getChildren().add(new Label("Workout Type                            "));
			labelBox.getChildren().add(new Label("Duration                                "));
			labelBox.getChildren().add(new Label("Date"));

			pane.add(labelBox, 0, 2);
			
			HBox hBox = new HBox();
			hBox.getChildren().add(mWorkoutTF);
			hBox.getChildren().add(mDurationTF);
			hBox.getChildren().add(mDateTF);
			hBox.getChildren().add(mAddWorkoutButton);
			hBox.setSpacing(25.0);
			pane.add(hBox, 0, 3);		
			
			//create event for button
			mAddWorkoutButton.setOnAction(e-> handleAddWorkout());
			
			Scene scene = new Scene(pane);			
			primaryStage.setTitle("Here are your logged Workouts");
			primaryStage.setScene(scene);
			primaryStage.show();
		}	

		private Object handleAddWorkout()
	    {
	//read the textfield
		    String workoutType = mWorkoutTF.getText();
		    String duration = mDurationTF.getText();
		    String date = mDateTF.getText();
		    
		    Workout workout = new Workout(workoutType,duration,date);
		    addWorkoutToDB(workout);
		    
		    
		    mWorkoutsList.add(workout.toString());
		    
		    //clear out textfields
		    mWorkoutTF.clear();
		    mDurationTF.clear();
		    mDateTF.clear();
		    mWorkoutTF.requestFocus();
		    return null;
	    }

	    public static void main(String[] args) {
			Application.launch(args);
		}
		
		private void createDBTable(){
		    //Load the classes for SQLite from JAR file
		   try
	    {
	        Class.forName("org.sqlite.JDBC");
	    }
	    catch (ClassNotFoundException e)
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		   
		   //establish a connection to the database
		   //try-with-resources = auto close the database
		   try(
		   Connection connection = DriverManager.getConnection("jdbc:sqlite:workouts.db");
		   Statement stmt = connection.createStatement();)
		   {
		    //Create Statement
		    StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS workouts(");
		    sb.append("_id INTEGER PRIMARY KEY,");
		    sb.append("workouttype TEXT,");
		    sb.append("duration TEXT,");
		    sb.append("date TEXT)");
		    
		    System.out.println(sb.toString());
		    //execute update
		       stmt.executeUpdate(sb.toString());
		       
		       //if the table exists, populate the observable List with all records.
		       sb = new StringBuilder("SELECT * FROM workouts");
		       //result set are the records returned if any.
		       ResultSet rs =stmt.executeQuery(sb.toString());
		       while(rs.next())
		       {
		    	   
		           String workouttype = rs.getString("workouttype");
		           String duration = rs.getString("duration");
		           String date = rs.getString("date");
		           
		           //add to observable List
		           Workout workout = new Workout(workouttype,duration,date);
		           mWorkoutsList.add(workout.toString());
		           
		       }
		   }
		   catch(SQLException e){
		       System.err.println(e.getMessage());
		   }
		}
		private void addWorkoutToDB(Workout workout){
		    
		    try
		    {
		        Class.forName("org.sqlite.JDBC");
		    }
		    catch (ClassNotFoundException e)
		    {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		       
		       //establish a connection to the database
		       //try-with-resources = quto-close the database
		       try(
		       Connection connection = DriverManager.getConnection("jdbc:sqlite:workouts.db");
		       Statement stmt = connection.createStatement();)
		       {
		    	   
		    	   String workouttype = mWorkoutTF.getText();
		    	   String duration = mDurationTF.getText();
		    	   String date = mDateTF.getText();
		    	   
		    	   Workout workout2 = new Workout(workouttype,duration,date);
		    	   
		    	   
		        //Create Statement
		        StringBuilder sb = new StringBuilder("INSERT INTO workouts(workouttype, duration, date) VALUES('");
		        sb.append(workouttype).append("','");
		        sb.append(duration).append("','");
		        sb.append(date).append("')");
		        
		        System.out.println(sb.toString());
		        //execute the update
		           stmt.executeUpdate(sb.toString());
		       }
		       catch(SQLException e){
		           System.err.println(e.getMessage());
		       }
		}
}
