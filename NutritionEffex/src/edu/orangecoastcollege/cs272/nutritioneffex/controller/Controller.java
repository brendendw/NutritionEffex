package edu.orangecoastcollege.cs272.nutritioneffex.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.orangecoastcollege.cs272.nutritioneffex.model.*;
import edu.orangecoastcollege.cs272.sdowdle.capstone.model.Food;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * 
 * @author our names here...
 *
 */
public class Controller implements AutoCloseable
{
	private static Controller theOne;
	private Controller() {}

	/* ~~~~~~~~~~~~~~~~~~~~~ DIETARY RESTRICTIONS PORTION VARIABLES ~~~~~~~~~~~~~~~~~~~~~ */
		// Constants for the 3 databases
	private DBModel mFoodsDB;
	private DBModel mPreferencesDB;
	private DBModel mFavoriteFoodsDB;
	
	private ObservableList<Food> mAllFoodsList;
	private ObservableList<Food> mAllFavoriteFoodsList;
	private ObservableList<String> mAllPreferencesList;
	
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

		// Functions
	
	/* ~~~~~~~~~~~~~~~~~~~~~ END OF DIETARY RESTRICTIONS PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ END OF [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	/* ~~~~~~~~~~~~~~~~~~~~~ [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ END OF [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	public static Controller getInstance() 
	{
		if (theOne == null)
		{
			theOne = new Controller();
			theOne.mAllFoodsList = FXCollections.observableArrayList();
			theOne.mAllFavoriteFoodsList = FXCollections.observableArrayList();
			theOne.mAllPreferencesList = FXCollections.observableArrayList();
			// Add your ObservableLists below

			try 
			{
				/* ~~~~~~~~~~~~~~~~~~ Dietary Restrictions Databases ~~~~~~~~~~~~~~~~~~~~*/
					// Create the foods database
				theOne.mFoodsDB = new DBModel(FOODS_DB_NAME, FOODS_TABLE_NAME, FOODS_FIELD_NAMES, FOODS_FIELD_TYPES);
				// initialize the database
				ResultSet foodRS = theOne.mFoodsDB.getAllRecords();
				if(foodRS != null)
				{
					while(foodRS.next())
					{
						int id = foodRS.getInt(FOODS_FIELD_NAMES[0]);
					    String displayName = foodRS.getString(FOODS_FIELD_NAMES[1]);
					    String portionDisplay = foodRS.getString(FOODS_FIELD_NAMES[2]);
					    double vegetables = foodRS.getDouble(FOODS_FIELD_NAMES[3]);
					    double fruits = foodRS.getDouble(FOODS_FIELD_NAMES[4]);
					    double milk = foodRS.getDouble(FOODS_FIELD_NAMES[5]);
					    double meats = foodRS.getDouble(FOODS_FIELD_NAMES[6]);
					    double soy = foodRS.getDouble(FOODS_FIELD_NAMES[7]);
					    double solidFats = foodRS.getDouble(FOODS_FIELD_NAMES[8]);
					    double addedSugars = foodRS.getDouble(FOODS_FIELD_NAMES[9]);
					    double alcohol = foodRS.getDouble(FOODS_FIELD_NAMES[10]);
					    double calories = foodRS.getDouble(FOODS_FIELD_NAMES[11]);
					    double saturatedFats = foodRS.getDouble(FOODS_FIELD_NAMES[12]);
						theOne.mAllFoodsList.add(new Food(id, displayName, portionDisplay, vegetables, fruits, milk,
															meats, soy, solidFats, addedSugars, alcohol, calories, saturatedFats));
					}
				}
					// Create the user preferences database
				theOne.mFavoriteFoodsDB = new DBModel(FAVORITES_DB_NAME, FAVORITES_TABLE_NAME, FAVORITES_FIELD_NAMES, FAVORITES_FIELD_TYPES);
				// initialize the database
				ResultSet favoritesRS = theOne.mFavoriteFoodsDB.getAllRecords();
				if(favoritesRS != null)
				{
					while(foodRS.next())
					{
						int id = foodRS.getInt(FAVORITES_FIELD_NAMES[0]);
					    String displayName = foodRS.getString(FAVORITES_FIELD_NAMES[1]);
					    String portionDisplay = foodRS.getString(FOODS_FIELD_NAMES[2]);
					    double vegetables = foodRS.getDouble(FAVORITES_FIELD_NAMES[3]);
					    double fruits = foodRS.getDouble(FAVORITES_FIELD_NAMES[4]);
					    double milk = foodRS.getDouble(FAVORITES_FIELD_NAMES[5]);
					    double meats = foodRS.getDouble(FAVORITES_FIELD_NAMES[6]);
					    double soy = foodRS.getDouble(FAVORITES_FIELD_NAMES[7]);
					    double solidFats = foodRS.getDouble(FAVORITES_FIELD_NAMES[8]);
					    double addedSugars = foodRS.getDouble(FAVORITES_FIELD_NAMES[9]);
					    double alcohol = foodRS.getDouble(FAVORITES_FIELD_NAMES[10]);
					    double calories = foodRS.getDouble(FAVORITES_FIELD_NAMES[11]);
					    double saturatedFats = foodRS.getDouble(FAVORITES_FIELD_NAMES[12]);
						theOne.mAllFavoriteFoodsList.add(new Food(id, displayName, portionDisplay, vegetables, fruits, milk,
															meats, soy, solidFats, addedSugars, alcohol, calories, saturatedFats));
					}
				}
					// Create the favorite foods database
				theOne.mPreferencesDB = new DBModel(PREFERENCES_DB_NAME, PREFERENCES_TABLE_NAME, PREFERENCES_FIELD_NAMES, PREFERENCES_FIELD_TYPES);
				// initialize the database
				ResultSet preferencesRS = theOne.mPreferencesDB.getAllRecords();
				if(preferencesRS != null)
				{
					while(foodRS.next())
					{
						int id = foodRS.getInt(PREFERENCES_FIELD_NAMES[0]);
					    String preference = foodRS.getString(PREFERENCES_FIELD_NAMES[1]);
						theOne.mAllPreferencesList.add(preference);
					}
				}
				
				/* ~~~~~~~~~~~~~~~~~~ Other 3 Below Databases ~~~~~~~~~~~~~~~~~~~~*/
				//  Add your set up and initialization of the databases and observable lists
				
				/* ~~~~~~~~~~~~~~~~~~ Other 3 Below Databases ~~~~~~~~~~~~~~~~~~~~*/
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return theOne;
	}

	/* ~~~~~~~~~~~~~~~~~~~~~ DIETARY RESTRICTIONS PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	@Override
	public void close() throws Exception 
	{
		mFoodsDB.close();
		mFavoriteFoodsDB.close();
		mPreferencesDB.close();
		// Close the rest of the databases below
	}
}