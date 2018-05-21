package edu.orangecoastcollege.cs272.nutritioneffex.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Brenden Williams
 * Class to be extended for ViewControllers that allows for better user
 * interface design.
 */
public abstract class SeamlessViewFX {

	protected static final String SCALE_UP = 
			"-fx-scale-x: 1.2; -fx-scale-y: 1.2; -fx-scale-z: 1.2;";
	protected static final String NORMAL_SCALE = 
			"-fx-scale-x: 1.0; -fx-scale-y: 1.0; -fx-scale-z: 1.0;";
	
	
	protected static final String HOVERED_BUTTON_STYLE = 
    		"-fx-background-color: white; -fx-border-color: white; "
    		+ "-fx-background-radius: 100, 100, 100, 100; -fx-border-radius: 100 100 100 100;"
    		+ "-fx-scale-x: 1.05; -fx-scale-y: 1.05; -fx-scale-z: 1.05;";
	
	protected static final String IDLE_BUTTON_STYLE = 
    		"-fx-background-color: white; -fx-background-radius: 30, 30, 30, 30; -fx-border-radius: 10 10 0 0;"
    		+ "-fx-scale-x: 1.0; -fx-scale-y: 1.0; -fx-scale-z: 1.0;";
	/*
	public boolean showImage(ImageView backgroundImage) {
	    try {
	        Image image = new Image("welcome_background.jpeg");
	    	//this.backgroundImage = new ImageView(new Image(getClass().getResourceAsStream("/assets/imgsrc/welcome_background.jpeg")));
	        backgroundImage.setImage(image);
	        backgroundImage.setCache(true);
	        return true;
	    } catch (Exception e) {
	        System.out.println("Couldn't find image");
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	*/
	
}