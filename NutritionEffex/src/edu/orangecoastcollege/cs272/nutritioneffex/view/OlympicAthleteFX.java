package edu.orangecoastcollege.cs272.nutritioneffex.view;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import edu.orangecoastcollege.cs272.nutritioneffex.model.Olympian;
import javafx.application.Application;
	import javafx.collections.ObservableList;
	import javafx.scene.Scene;
	import javafx.scene.control.Label;
	import javafx.scene.control.ListView;
	import javafx.scene.control.Slider;

	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;

	public class OlympicAthleteFX extends Application {
	    //Define a controller.
	    Controller controller; 

		Slider HeightSlider = new Slider(0.0, 80, 0.0);
		Slider WeightSlider = new Slider(0.0, 250, 0.0);

		ObservableList<Olympian> OlympiansList;
		ListView<Olympian> OlympiansLV = new ListView<>();

		@Override
		public void start(Stage primaryStage) throws Exception {
	controller = Controller.getInstance();
		    //Fill the observable list with the controller.
	OlympiansList = controller.getAllOlympiansList();
			// Associate the employeesLV with the observable list
	OlympiansLV.setItems(OlympiansList);
	OlympiansLV.setPrefWidth(800);

			WeightSlider.setShowTickMarks(true);
			WeightSlider.setShowTickLabels(true);
			WeightSlider.setMajorTickUnit(10.0f);
			WeightSlider.setBlockIncrement(1.0f);
			WeightSlider.setOnMouseDragged(e-> filterathlete());

			HeightSlider.setShowTickMarks(true);
			HeightSlider.setShowTickLabels(true);
			HeightSlider.setMajorTickUnit(5.0f);
			HeightSlider.setBlockIncrement(100.0f);
			HeightSlider.setOnMouseDragged(e->filterathlete());
			
			GridPane pane = new GridPane();
			pane.setHgap(10.0);
			
			pane.add(new Label("Filter: "), 0, 0);
			
			pane.add(new Label("Weight (lbs):"), 0, 3);
			pane.add(WeightSlider, 1, 3);

			pane.add(new Label("Height (inches):"), 0, 4);
			pane.add(HeightSlider, 1, 4);

			pane.add(OlympiansLV, 0, 5, 2, 1);

			Scene scene = new Scene(pane, 800, 400);
			primaryStage.setTitle("The World's Olympians");
			primaryStage.setScene(scene);
			primaryStage.show();
		}

		private void filterathlete() {
			//need to convert to metric to match the csv.
		    double inkg,inmeters;
		    double Weight = WeightSlider.getValue();
		   //1 lb = 0.453592 kg
		    inkg = Weight*.45359;
		    
		    //1 inch = 0.0254 meters.
		    double Height = HeightSlider.getValue();
		    inmeters = Height*.0254;
		    
		    //Margin of error
		    OlympiansList = controller.filterathlete(b -> ( b.getWeight() < (inkg + 4)
		    		&& b.getWeight()> (inkg - 4) 
		    		&& b.getHeight() >(inmeters-0.2) 
		    		&& b.getHeight() <(inmeters+ 0.2 )));
		           
		    //reset the LV
		    OlympiansLV.setItems(OlympiansList);
		}

		public static void main(String[] args) {
			Application.launch(args);

		}

	}


