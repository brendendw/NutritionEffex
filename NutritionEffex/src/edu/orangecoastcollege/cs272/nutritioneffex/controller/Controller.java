package edu.orangecoastcollege.cs272.nutritioneffex.controller;
import edu.orangecoastcollege.cs272.nutritioneffex.model.*;
import javafx.collections.ObservableList;
/**
 * 
 * @author our names here...
 *
 */
public class Controller implements AutoCloseable
{
	private static Controller theOne;
	private DBModel mDB;
	private Controller() {}
	
	public static Controller getInstance() 
	{
		if (theOne == null)
		{
			theOne = new Controller();
		}
		return theOne;
		// This was temporary to test the ViewNavigator, will need to be fully implemented
	}

	/* ~~~~~~~~~~~~~~~~~~~~~ DIETARY RESTRICTIONS PORTION ~~~~~~~~~~~~~~~~~~~~~ */

	private ObservableList<Food> mAllFoodsList;

	// Constants for the 3 databases
	private static final String PREFERENCES_DB_NAME = "dietary_preferences.db";
	private static final String FOODS_DB_NAME = "foods.db";
	private static final String FAVORITES_DB_NAME = "favorite_foods.db";

	// Dietary Preferences Database
	private static final String PREFERENCES_TABLE_NAME = "dietary_preferences";
	private static final String[] PREFERENCES_FIELD_NAMES = { "_id", "preference"};
	private static final String[] PREFERENCES_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT"};

	// Foods Database
	private static final String FOODS_TABLE_NAME = "foods";
	private static final String[] FOODS_FIELD_NAMES = { "_id", "name", "portion_display_name", "vegetables", "fruits", "milk", "meats", "soy",
														"solid_fats", "added_sugars", "alcohol", "calories", "saturated_fats"};
	private static final String[] FOODS_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "REAL", "REAL", "REAL", "REAL", "REAL", "REAL",
														"REAL", "REAL", "REAL", "REAL", "REAL", "REAL" };
	private static final String FOODS_DATA_FILE = "foods.csv";

	// Favorite Foods Database
	private static final String FAVORITES_TABLE_NAME = "favorite_foods";
	private static final String[] FAVORITES_FIELD_NAMES = { "_id", "name", "portion_display_name", "solid_fats", "added_sugars", "alcohol", "calories", "saturated_fats"};
	private static final String[] FAVORITES_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "REAL", "REAL", "REAL", "REAL", "REAL", "REAL" };

	/* ~~~~~~~~~~~~~~~~~~~~~ END OF DIETARY RESTRICTIONS PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ END OF [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	/* ~~~~~~~~~~~~~~~~~~~~~ [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ END OF [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	@Override
	public void close() throws Exception 
	{
		mDB.close();
	}
}

