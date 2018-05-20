package edu.orangecoastcollege.cs272.nutritioneffex.view;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import edu.orangecoastcollege.cs272.nutritioneffex.view.FavoriteFoodsScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * This scene provides a breakdown of the selected
 * Food data from the FavoriteFoods scene.
 * @author Sean Dowdle
 *
 */
public class FoodDetailsScene implements Initializable
{
	@FXML
	private Button backButton;
	@FXML
	private Label name;
	@FXML
	private Label portion;
	@FXML
	private Label calories;
	@FXML
	private Label addedSugars;
	@FXML
	private Label saturatedFats;
	@FXML
	private Label alcohol;
	@FXML
	private Label dairy;
	@FXML
	private Label meat;

	/**
	 * Calls ViewNavigator to load and go back to
	 * the FavoriteFoods scene.
	 */
	@FXML
	public void loadFavoriteFoodsScene() 
	{
		ViewNavigator.loadScene("Favorite Foods", ViewNavigator.FAVORITE_FOODS_SCENE);
	}
	
	/**
	 * Initializes the scene's ListView when the scene is loaded.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		DecimalFormat twoDP = new DecimalFormat();
		name.setText(FavoriteFoodsScene.getSelectedFood().getDisplayName());
		portion.setText(FavoriteFoodsScene.getSelectedFood().getPortionDisplay());
		calories.setText(String.valueOf(twoDP.format(FavoriteFoodsScene.getSelectedFood().getCalories())));
		addedSugars.setText(twoDP.format(FavoriteFoodsScene.getSelectedFood().getAddedSugars()) + "g");
		saturatedFats.setText(twoDP.format(FavoriteFoodsScene.getSelectedFood().getSaturatedFats()) + "g");
		alcohol.setText( (FavoriteFoodsScene.getSelectedFood().getAlcohol() > 0.0000000) ? "Yes" : "No");
		dairy.setText( (FavoriteFoodsScene.getSelectedFood().getMilk() > 0.0000000) ? "Yes" : "No");
		meat.setText( (FavoriteFoodsScene.getSelectedFood().getMeats() > 0.0000000) ? "Yes" : "No");
	}
}
