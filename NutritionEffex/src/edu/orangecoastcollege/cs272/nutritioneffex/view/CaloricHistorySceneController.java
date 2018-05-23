package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

public class CaloricHistorySceneController implements Initializable {
	
	Controller controller = Controller.getInstance();
	@FXML
	private ImageView backgroundImage;
	@FXML
	private ImageView backButton;
	@SuppressWarnings("rawtypes")
	@FXML
	private ListView caloricHistoryLV;

	// Event Listener on ImageView[#backButton].onMouseClicked
	@FXML
	public void backToCalculatorMenu(MouseEvent event) {
		ViewNavigator.loadScene("Calorie Calculator", ViewNavigator.CALORIE_CALCULATOR_SCENE);
	}
	
	@FXML
	public void scaleUp(MouseEvent event) {
		backButton.setScaleX(1.2);
		backButton.setScaleY(1.2);
	}

	@FXML
	public void scaleDown(MouseEvent event) {
		backButton.setScaleX(1.0);
		backButton.setScaleY(1.0);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		caloricHistoryLV.setItems(controller.getCaloricHistoryList());
		caloricHistoryLV.setStyle("list-cell {\n" + 
				"    -fx-alignment: center;");
	}
}


