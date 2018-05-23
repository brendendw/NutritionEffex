package edu.orangecoastcollege.cs272.nutritioneffex.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * Controller for the CalorieCalculator view that allows a user to retrieve their
 * recommended daily caloric intake. The information is then stored in a relational database
 * under the users ID.
 * @author brendendrew
 * 
 */
public class CalorieCalculatorController extends SeamlessViewFX implements Initializable {
	
	Controller controller = Controller.getInstance();
	public FadeTransition fadeOut = new FadeTransition(Duration.millis(3000));
	@FXML
	private ImageView backgroundImage;
	@FXML
	private ImageView viewHistoryButton;
	@FXML
	private Label calculateButton;
	@FXML
	private Label descriptionLabel;
	@FXML
	private TextField weightTF;
	@FXML
	private Label incorrectInfoLabel;
	@FXML
	private ImageView backButton;
	@FXML
	private TextField heightTF;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox goalWeightCB;
	
	@FXML
	private TextField recommendedIntake;

	// Event Listener on Label[#calculateButton].onMouseClicked
	@FXML
	public void calculate() 
	{
		if (heightTF.getText().isEmpty() || weightTF.getText().isEmpty() || goalWeightCB.getSelectionModel().isEmpty()) 
		{
			incorrectInfoLabel.setText("missing fields");
			incorrectInfoLabel.setVisible(true);
			fadeOut.setNode(incorrectInfoLabel);
			fadeOut.setFromValue(1.0);
			fadeOut.setToValue(0.0);
	    	fadeOut.setCycleCount(1);
	    	fadeOut.setAutoReverse(false);
	    	fadeOut.playFromStart();
			return;
		}
		double heightInCM = Double.parseDouble(heightTF.getText());
		double age = (double) controller.getCurrentUser().getAge();
		double result = 10 + (6.25 * heightInCM) - (5 * age + 5);
		
		switch (goalWeightCB.getSelectionModel().getSelectedIndex())
		{
		// lose weight
		case 0: 
			result-=500;
			break;
		// gain weight
		case 1:
			result += 500;
			break;
		default:
		// maintain weight
			break;
		}
		
		recommendedIntake.setText(String.valueOf(result + 1000));
		recommendedIntake.setVisible(true);
		incorrectInfoLabel.setVisible(false);
		// Adds caloric intake to database to store history
		controller.addCaloricIntake(result);
		viewHistoryButton.setVisible(true);
		
		controller.addCaloricIntake(result);
	}
	
	
	
	
	// Event Listener on ImageView[#backButton].onMouseClicked
	@FXML
	public void backToCalculatorMenu(MouseEvent event) 
	{
		ViewNavigator.loadScene("Calculator Menu", ViewNavigator.CALCULATOR_MENU_SCENE);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		goalWeightCB.setItems(controller.getGoalWeights());
		incorrectInfoLabel.setVisible(false);
		
		try {
			backButton.setStyle(NORMAL_SCALE);
			backButton.setOnMouseEntered(e -> backButton.setStyle(SCALE_UP));
			backButton.setOnMousePressed(e -> backButton.setStyle(NORMAL_SCALE));
			backButton.setOnMouseExited(e -> backButton.setStyle(NORMAL_SCALE));
			
			calculateButton.setStyle(IDLE_BUTTON_STYLE);
			calculateButton.setOnMouseEntered(e -> calculateButton.setStyle(HOVERED_BUTTON_STYLE));
			calculateButton.setOnMouseExited(e -> calculateButton.setStyle(IDLE_BUTTON_STYLE));
			
			weightTF.setOnKeyPressed(e -> enterKeyHandler(e));
			heightTF.setOnKeyPressed(e -> enterKeyHandler(e));
			goalWeightCB.setOnKeyPressed(e -> submissionKeyListener(e));
			goalWeightCB.setOnKeyReleased(e -> keyExited(e));
			weightTF.setOnMouseClicked(e -> highlightText());
			heightTF.setOnMouseClicked(e -> highlightText());
			
			descriptionLabel.setVisible(false);
			viewHistoryButton.setVisible(false);
			
		}
		catch (NullPointerException e) {
			System.out.println("Transferring scenes");
		}
		

		
	}


private void keyExited(KeyEvent e) {
		// TODO Auto-generated method stub
		calculateButton.setStyle(IDLE_BUTTON_STYLE);
		calculate();
	}
@FXML
private void showDescriptionLabel()
{
	descriptionLabel.setVisible(true);
	viewHistoryButton.setScaleX(1.2);
	viewHistoryButton.setScaleY(1.2);
	// Fade in
	fadeOut.setDuration(Duration.millis(1000));
	fadeOut.setNode(descriptionLabel);
	fadeOut.setFromValue(0.0);
	fadeOut.setToValue(1.0);
	fadeOut.setCycleCount(1);
	fadeOut.setAutoReverse(false);
	fadeOut.playFromStart();
}

@FXML
private void hideDescriptionLabel()
{

	fadeOut.setNode(descriptionLabel);
	fadeOut.setFromValue(1.0);
	fadeOut.setToValue(0.0);
	fadeOut.setCycleCount(1);
	fadeOut.setAutoReverse(false);
	fadeOut.playFromStart();
	fadeOut.setDuration(Duration.millis(3000));
	descriptionLabel.setVisible(false);
	viewHistoryButton.setScaleX(1.0);
	viewHistoryButton.setScaleY(1.0);
	
}

@FXML
private void showCaloricHistory()
{
	ViewNavigator.loadScene("Caloric History", ViewNavigator.CALORIC_HISTORY_SCENE);
}

@FXML
private void historyButtonClicked()
{
	viewHistoryButton.setScaleX(1.0);
	viewHistoryButton.setScaleY(1.0);
}

private void submissionKeyListener(KeyEvent e) {
	if (e.getCode() == KeyCode.ENTER) {
		calculateButton.setStyle(HOVERED_BUTTON_STYLE);
	}
}



	private void highlightText() {
		// TODO Auto-generated method stub
		if (heightTF.isFocused()) 
		{
			if (heightTF.getText().contains("height (cm)") || heightTF.getText().isEmpty()) heightTF.setText("height (cm)");
			heightTF.selectAll();
			if (weightTF.getText().contains("weight (kg)")) weightTF.clear();
		}
		
		
		else if (weightTF.isFocused()) 
		{
			if (weightTF.getText().contains("weight (kg)") || weightTF.getText().isEmpty()) weightTF.setText("weight (kg)");
			weightTF.selectAll();
			if (heightTF.getText().contains("height (cm)")) heightTF.clear();
		}
	}


	private void enterKeyHandler(KeyEvent e) {
	
		if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.TAB)
		{
			
			if (weightTF.isFocused())
			{
				if (weightTF.getText().contains("weight (kg)") || weightTF.getText().isEmpty())
				{
					weightTF.clear();
					heightTF.setText("height (cm)");
					
				}
				heightTF.requestFocus();
				return;
				
			}
			else if (heightTF.isFocused())
			{
				if (heightTF.getText().contains("height (cm)") || heightTF.getText().isEmpty())
				{
					heightTF.clear();
					
				}
				goalWeightCB.requestFocus();
				return;
				
			}
			else
			{
				calculate();
			}
		}
	}
}
