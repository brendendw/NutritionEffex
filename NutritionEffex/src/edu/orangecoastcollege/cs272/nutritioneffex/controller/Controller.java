package edu.orangecoastcollege.cs272.nutritioneffex.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

import edu.orangecoastcollege.cs272.nutritioneffex.model.DBModel;
import edu.orangecoastcollege.cs272.nutritioneffex.model.User;
import edu.orangecoastcollege.cs272.nutritioneffex.view.ViewNavigator;
import edu.orangecoastcollege.cs272.nutritioneffex.model.*;
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
	//private Controller() {}

		// Constants for the 3 databases
		private DBModel mFoodsDB;
		private DBModel mPreferencesDB;
		private DBModel mFavoriteFoodsDB;
		
	
		private ObservableList<Food> mAllFoodsList;
		private ObservableList<Food> mAllFavoriteFoodsList;
		private ObservableList<Preference> mAllPreferencesList;
		private ObservableList<String> mAllPreferencesCBList;
		
		
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
															"REAL", "REAL", "REAL", "REAL" };
		private static final String FOODS_DATA_FILE = "Foods.csv";

		// Favorite Foods Database
		private static final String FAVORITES_TABLE_NAME = "favorite_foods";
		private static final String[] FAVORITES_FIELD_NAMES = { "_id", "name", "portion_display_name", "vegetables", "fruits", "milk", "meats", "soy",
																"solid_fats", "added_sugars", "alcohol", "calories", "saturated_fats" };
		private static final String[] FAVORITES_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "REAL", "REAL", "REAL", "REAL", "REAL", "REAL",
																"REAL", "REAL", "REAL", "REAL" };
		
		
		// ------ BRENDEN ------- \\
		private ObservableList<String> mAllGendersList;
		private ObservableList<Integer> mAllAgesList;
		private ObservableList<User> mAllUsersList;

		// DB Model for users
		private DBModel mUserDB;
		private User mCurrentUser;

		private static final String USER_DB = "user_names.db";
		private static final String USER_TABLE_NAME = "users";
		private static final String[] USER_FIELD_NAMES = {"_id", "name", "email", "age", "gender", "password"};
		private static final String[] USER_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "TEXT", "INTEGER", "TEXT", "TEXT"};
				
		// Age and gender options for ComboBoxes
		private static final String[] GENDER_TYPES = {"male", "female"};
		// decided not to add age array for the CB & will just fill with a loop
		
		public static Controller getInstance() 
		{
			if (theOne == null)
			{
				theOne = new Controller();
				theOne.mAllFoodsList = FXCollections.observableArrayList();
				theOne.mAllFavoriteFoodsList = FXCollections.observableArrayList();
				theOne.mAllPreferencesList = FXCollections.observableArrayList();
				theOne.mAllUsersList = FXCollections.observableArrayList();
				theOne.mAllOlympiansList = FXCollections.observableArrayList();
				//HELP: Hey guys, do we need to have to instantiate the filtered lists here?
				theOne.mFilteredOlympiansList = FXCollections.observableArrayList();
				try 
				{
					
					// -------------- Create the user table database ------------ \\
					/*theOne.mUserDB = new DBModel(USER_DB, USER_TABLE_NAME, USER_FIELD_NAMES, USER_FIELD_TYPES);
					ResultSet usersRS = theOne.mUserDB.getAllRecords();
					if (usersRS != null)
					{
						// USER_FIELD_NAMES = {"_id", "name", "email", "age", "gender", "password"};

						while (usersRS.next())
						{
							int userID = Integer.parseInt(USER_FIELD_NAMES[0]);
							String name = usersRS.getString(USER_FIELD_NAMES[1]);
							String email = usersRS.getString(USER_FIELD_NAMES[2]);
							String age = usersRS.getString(USER_FIELD_NAMES[3]);
							String gender = usersRS.getString(USER_FIELD_NAMES[4]);						
							theOne.mAllUsersList.add(new User(userID, name, gender, email));
						}
						*/
					theOne.mUserDB = new DBModel(USER_DB, USER_TABLE_NAME, USER_FIELD_NAMES, USER_FIELD_TYPES);
					ArrayList<ArrayList<String>> usersRS = theOne.mUserDB.getAllRecordsArrayList();
					for (ArrayList<String> values : usersRS)
					{
						int userID = Integer.parseInt(values.get(0));
						String name = values.get(1);
						String email = values.get(2);
						int age = Integer.parseInt(values.get(3));
						String gender = values.get(4);					
						theOne.mAllUsersList.add(new User(userID, name, gender, age, email));
					}
					
					
					
					// Create a relationship table between users and their preferences (sean's database)
					
						
					/* ~~~~~~~~~~~~~~~~~~ Dietary Restrictions Databases ~~~~~~~~~~~~~~~~~~~~*/
						// Create the foods database
					theOne.mFoodsDB = new DBModel(FOODS_DB_NAME, FOODS_TABLE_NAME, FOODS_FIELD_NAMES, FOODS_FIELD_TYPES);
					theOne.initializeFoodDBFromFile();
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
						// Create the favorite foods database
					theOne.mFavoriteFoodsDB = new DBModel(FAVORITES_DB_NAME, FAVORITES_TABLE_NAME, FAVORITES_FIELD_NAMES, FAVORITES_FIELD_TYPES);
					ResultSet favoritesRS = theOne.mFavoriteFoodsDB.getAllRecords();
					if(favoritesRS != null)
					{
						while(favoritesRS.next())
						{
							int id = favoritesRS.getInt(FAVORITES_FIELD_NAMES[0]);
						    String displayName = favoritesRS.getString(FAVORITES_FIELD_NAMES[1]);
						    String portionDisplay = favoritesRS.getString(FAVORITES_FIELD_NAMES[2]);
						    double vegetables = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[3]); // no such column 'vegetables'
						    double fruits = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[4]);
						    double milk = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[5]);
						    double meats = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[6]);
						    double soy = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[7]);
						    double solidFats = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[8]);
						    double addedSugars = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[9]);
						    double alcohol = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[10]);
						    double calories = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[11]);
						    double saturatedFats = favoritesRS.getDouble(FAVORITES_FIELD_NAMES[12]);
							theOne.mAllFavoriteFoodsList.add(new Food(id, displayName, portionDisplay, vegetables, fruits, milk,
																meats, soy, solidFats, addedSugars, alcohol, calories, saturatedFats));
						}
					}
						// Create the user preferences database	
					theOne.mPreferencesDB = new DBModel(PREFERENCES_DB_NAME, PREFERENCES_TABLE_NAME, PREFERENCES_FIELD_NAMES, PREFERENCES_FIELD_TYPES);
					ResultSet preferencesRS = theOne.mPreferencesDB.getAllRecords();
					if(preferencesRS != null)
					{
						while(preferencesRS.next())
						{
							int id = preferencesRS.getInt(PREFERENCES_FIELD_NAMES[0]);
						    String preference = preferencesRS.getString(PREFERENCES_FIELD_NAMES[1]);
							theOne.mAllPreferencesList.add(new Preference(id, preference));
						}
					}
					
					/* ~~~~~~~~~~~~~~~~~~ Other 3 Below Databases ~~~~~~~~~~~~~~~~~~~~*/
					//  Add your set up and initialization of the databases and observable lists
					// Create the olympians database
					theOne.mOlympiansDB = new DBModel(OLYMPIANS_DB_NAME, OLYMPIANS_TABLE_NAME, OLYMPIANS_FIELD_NAMES, OLYMPIANS_FIELD_TYPES);
					theOne.initializeFoodDBFromFile();
					ResultSet olympianRS = theOne.mOlympiansDB.getAllRecords();
					if(olympianRS != null)
					{
						while(olympianRS.next())
						{
							int id = olympianRS.getInt(OLYMPIANS_FIELD_NAMES[0]);
						    String name = olympianRS.getString(OLYMPIANS_FIELD_NAMES[1]);
						    String age = olympianRS.getString(OLYMPIANS_FIELD_NAMES[2]);
						    String sport = olympianRS.getString(OLYMPIANS_FIELD_NAMES[3]);
						    double height = olympianRS.getDouble(OLYMPIANS_FIELD_NAMES[4]);
						    double weight = olympianRS.getDouble(OLYMPIANS_FIELD_NAMES[5]);
						    boolean gender = olympianRS.getBoolean(OLYMPIANS_FIELD_NAMES[6]);
						    
							theOne.mAllOlympiansList.add(new Olympian(id,name,age,sport,height,weight,gender));
						}
						theOne.mFilteredOlympiansList = 
			                    FXCollections.observableArrayList(theOne.mAllOlympiansList);
					}
					
		
					/* ~~~~~~~~~~~~~~~~~~ Other 3 Below Databases ~~~~~~~~~~~~~~~~~~~~*/
					
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			return theOne;
		}

		// Functions
		private int initializeFoodDBFromFile() throws SQLException 
		{
			int recordsCreated = 0;
			if (theOne.mFoodsDB.getRecordCount() > 0)
				return recordsCreated;

			try 
			{
				Scanner fileScanner = new Scanner(new File(FOODS_DATA_FILE));
				// First read is for headings:
				fileScanner.nextLine();
				// All subsequent reads are for billionaire data
				while (fileScanner.hasNextLine())
				{
					String[] data = fileScanner.nextLine().split(",");
					String[] values = new String[FOODS_FIELD_NAMES.length - 1];
					values[0] = data[1]; // name [ Array Index out of bounds 1 ]
					values[1] = data[4]; // portion 
					values[2] = data[10]; // vegetables
					values[3] = data[15]; // fruits
					values[4] = data[16]; // milk
					values[5] = data[17]; // meats
					values[6] = data[18]; // soy
					values[7] = data[21]; // solid fats
					values[8] = data[22]; // added sugars
					values[9] = data[23]; // alcohol
					values[10] = data[24]; // calories
					values[11] = data[25]; // saturated fats
					theOne.mFoodsDB.createRecord(Arrays.copyOfRange(FOODS_FIELD_NAMES, 1, FOODS_FIELD_NAMES.length), values);
					recordsCreated++;
				}
				// All done with the CSV file, close the connection
				fileScanner.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			return recordsCreated;
		}
		
		
		/**
		 * Returns an ObservableList containing all of the Foods in the foods database.
		 * @return an ObservableList containing all of the Foods in the foods database
		 */
		public ObservableList<Food> getAllFoods()
		{
			return mAllFoodsList;
		}
		/**
		 * Returns an ObservableList containing all of the Preferences in the preferences database
		 * @return an ObservableList containing all of the Preferences in the preferences database
		 */
		public ObservableList<Preference> getAllPreferences()
		{
			return mAllPreferencesList;
		}
		/**
		 * Returns an ObservableList containing all of the users favorite Foods in the favorite foods database
		 * @return an ObservableList containing all of the users favorite Foods in the favorite foods database
		 */
		public ObservableList<Food> getAllFavoriteFoods()
		{
			return mAllFavoriteFoodsList;
		}
		/**
		 * Returns an ObservableList containing all of the pre-set preferences to be chosen from a ComboBox
		 * @return an ObservableList containing all of the pre-set preferences to be chosen from a ComboBox
		 */
		public ObservableList<String> getAllPreferencesCB()
		{
			if(mAllPreferencesCBList == null)
			{
				mAllPreferencesCBList = FXCollections.observableArrayList();
				mAllPreferencesCBList.addAll("--- Select ---", "No Meat", "No Dairy", "No Saturated Fats", "No Added Sugars", "No Solid Fats", "No Soy", "No Vegetables",
												"No Fruits", "No Alcohol");	
			}
			return mAllPreferencesCBList;
		}
		
		public ObservableList<String> getAllGenders()
		{
			if (mAllGendersList == null)
			{
				mAllGendersList = FXCollections.observableArrayList();
				mAllGendersList.addAll(GENDER_TYPES);
			}
			
			return mAllGendersList;
		}
		
		public ObservableList<Integer> getAllowableAges()
		{
			if (mAllAgesList == null)
			{
				mAllAgesList = FXCollections.observableArrayList();
				for (Integer min = 13; min < 60; min++)
					mAllAgesList.add(min);
			}
			return mAllAgesList;
			
			
		}
		/**
		 * Adds the chosen preference to the preferences database.
		 * @param preference The description of the preference
		 * @return a boolean based on if the addition to the database was successful or not.
		 */
		public boolean addPreferenceToPreferences(String preference)
		{
			ObservableList<Preference> preferences = getAllPreferences();
			for(int i = 0; i < preferences.size(); i++)
				if(preferences.get(i).getPreference().equals(preference))
					return false;
			String[] values = { preference };
			String[] fields = { PREFERENCES_FIELD_NAMES[1] };
			try
			{
				int id = theOne.mPreferencesDB.createRecord(fields, values);
				theOne.mAllPreferencesList.add(new Preference(id, preference));
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}
			return true;
		}
		/**
		 * Adds the selected Food item to the favorite foods database.
		 * @param selection The selected Food item
		 * @return a boolean based on whether or not the addition to the database was successful
		 */
		public boolean addFoodToFavorites(Food selection)
		{
			ObservableList<Food> favorites = getAllFavoriteFoods();
			if(favorites.contains(selection))
				return false;
			String[] values = {selection.getDisplayName(), selection.getPortionDisplay(), String.valueOf(selection.getVegetables()), String.valueOf(selection.getFruits()),
								String.valueOf(selection.getMilk()), String.valueOf(selection.getMeats()), String.valueOf(selection.getSoy()),
								String.valueOf(selection.getSolidFats()), String.valueOf(selection.getAddedSugars()), String.valueOf(selection.getAlcohol()),
								String.valueOf(selection.getCalories()), String.valueOf(selection.getSaturatedFats())};
			// "_id", "name", "portion_display_name", "vegetables", "fruits", "milk", "meats", "soy",
			// "solid_fats", "added_sugars", "alcohol", "calories", "saturated_fats"
			try
			{
				theOne.mFavoriteFoodsDB.createRecord(Arrays.copyOfRange(FAVORITES_FIELD_NAMES, 1, FAVORITES_FIELD_NAMES.length), values);
				theOne.mAllFavoriteFoodsList.add(selection);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}
			return true;
		}
		/**
		 * Deletes the selected Food item from the database.
		 * @param selection The selected Food item
		 * @return a boolean whether or not the deletion was successful
		 */
		public boolean deleteFromFavoriteFoods(Food selection)
		{
			theOne.mAllFavoriteFoodsList.remove(selection);
			try
			{
				theOne.mFavoriteFoodsDB.deleteRecord(String.valueOf(selection.getId()));
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}
			return true;
		}
		/**
		 * Deletes the selected preference from the user preference database.
		 * @param selection The selected preference
		 * @return a boolean whether or not the deletion was successful
		 */
		public boolean deletePreferencesFromPrefrenceDB(Preference selection)
		{
			theOne.mAllPreferencesList.remove(selection);
			try
			{
				theOne.mPreferencesDB.deleteRecord(String.valueOf(selection.getId()));
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}
			return true;
		}
		/**
		 * Filters through all of the Foods in the database and shows only
		 * the excluded items from the users diet.
		 * @param foods An ObservableList of Foods
		 * @param preferences An ObservableList of Preferences
		 * @return a filtered ObservableList of Food objects
		 */
		public ObservableList<Food> filterExcluded(ObservableList<Food> foods, ObservableList<Preference> preferences)
		{
			ObservableList<Food> filteredFoodsList = FXCollections.observableArrayList();
			if(preferences.size() > 0)
			{
				for(int i = 0; i < foods.size(); i++)
				{
					boolean canAdd = false;
					for(int j = 0; j < preferences.size(); j++)
					{
						// "No Meat", "No Saturated Fats", "No Added Sugars", "No Solid Fats", "No Soy", "No Vegetables",
						// "No Fruits", "No Alcohol"
						String prefrence = preferences.get(j).getPreference();
						if(!canAdd)
						{
							if(prefrence.equals("No Meat") && foods.get(i).getMeats() > 0.000000)
							{
								canAdd = true;
							}
							else if(prefrence.equals("No Dairy") && foods.get(i).getMilk() > 0.000000)
							{
								canAdd = true;
							}
							else if(prefrence.equals("No Saturated Fats") && foods.get(i).getSaturatedFats() > 0.000000)
							{
								canAdd = true;
							}
							else if(prefrence.equals("No Added Sugars") && foods.get(i).getAddedSugars() > 0.000000)
							{
								canAdd = true;
							}
							else if(prefrence.equals("No Solid Fats") && foods.get(i).getSolidFats() > 0.000000)
							{
								canAdd = true;
							}
							else if(prefrence.equals("No Soy") && foods.get(i).getSoy() > 0.000000)
							{
								canAdd = true;
							}
							else if(prefrence.equals("No Vegetables") && foods.get(i).getVegetables() > 0.000000)
							{
								canAdd = true;
							}
							else if(prefrence.equals("No Fruits") && foods.get(i).getFruits() > 0.000000)
							{
								canAdd = true;
							}
							else if(prefrence.equals("No Alcohol") && foods.get(i).getAlcohol() > 0.000000)
							{
								canAdd = true;
							}
						}
					}
					if(canAdd)
						filteredFoodsList.add(foods.get(i));
				}
			}
			else // there are no preferences, show all food
			{
				filteredFoodsList = theOne.mAllFoodsList;
			}
			return filteredFoodsList;
		}
		/**
		 * Filters through all of the Foods in the database and only shows
		 * the ones the user can eat based off of their preferences.
		 * @param foods An ObservableList of Foods
		 * @param preferences An ObservableList of Preferences
		 * @return a filtered ObservableList of Food objects
		 */
		public ObservableList<Food> filterOnPreferences(ObservableList<Food> foods, ObservableList<Preference> preferences)
		{
			ObservableList<Food> filteredFoodsList = FXCollections.observableArrayList();
			if(preferences.size() > 0)
			{
				for(int i = 0; i < foods.size(); i++)
				{
					int canAdd = 0;
					for(int j = 0; j < preferences.size(); j++)
					{
						// "No Meat", "No Saturated Fats", "No Added Sugars", "No Solid Fats", "No Soy", "No Vegetables",
						// "No Fruits", "No Alcohol"
						String prefrence = preferences.get(j).getPreference();
						if(prefrence.equals("No Meat") && foods.get(i).getMeats() == 0)
						{
							canAdd++;
						}
						else if(prefrence.equals("No Dairy") && foods.get(i).getMilk() == 0)
						{
							canAdd++;
						}
						else if(prefrence.equals("No Saturated Fats") && foods.get(i).getSaturatedFats() == 0)
						{
							canAdd++;
						}
						else if(prefrence.equals("No Added Sugars") && foods.get(i).getAddedSugars() == 0)
						{
							canAdd++;
						}
						else if(prefrence.equals("No Solid Fats") && foods.get(i).getSolidFats() == 0)
						{
							canAdd++;
						}
						else if(prefrence.equals("No Soy") && foods.get(i).getSoy() == 0)
						{
							canAdd++;
						}
						else if(prefrence.equals("No Vegetables") && foods.get(i).getVegetables() == 0)
						{
							canAdd++;
						}
						else if(prefrence.equals("No Fruits") && foods.get(i).getFruits() == 0)
						{
							canAdd++;
						}
						else if(prefrence.equals("No Alcohol") && foods.get(i).getAlcohol() == 0)
						{
							canAdd++;
						}
					}
					if(canAdd == preferences.size())
						filteredFoodsList.add(foods.get(i));
				}
			}
			else // there are no preferences, show all food
			{
				filteredFoodsList = theOne.mAllFoodsList;
			}
			return filteredFoodsList;
		}
	
	/* ~~~~~~~~~~~~~~~~~~~~~ END OF DIETARY RESTRICTIONS PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	// Constants for the 3 databases
		private DBModel mOlympiansDB;
		
		private ObservableList<Olympian> mAllOlympiansList;
		private ObservableList<Olympian> mFilteredOlympiansList;

		
		private static final String OLYMPIANS_DB_NAME = "olympians.db";

		// Olympians Database
		private static final String OLYMPIANS_TABLE_NAME = "olympians";
		private static final String[] OLYMPIANS_FIELD_NAMES = { "_id", "age","sport","height","weight","gender"};
		private static final String[] OLYMPIANS_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT","TEXT", "REAL", "REAL", "INTEGER"};
		private static final String OLYMPIANS_DATA_FILE = "athletes.csv";

		
		private int initializeOlympianDBFromFile() throws SQLException 
		{
			int recordsCreated = 0;
			if (theOne.mFoodsDB.getRecordCount() > 0)
				return recordsCreated;

			try 
			{
				Scanner fileScanner = new Scanner(new File(OLYMPIANS_DATA_FILE));
				// First read is for headings:
				fileScanner.nextLine();
				// All subsequent reads are for olympian data
				while (fileScanner.hasNextLine())
				{
					String[] data = fileScanner.nextLine().split(",");
					String[] values = new String[OLYMPIANS_FIELD_NAMES.length - 1];
					values[0] = data[1]; // name
					values[1] = data[4]; // age
					values[2] = data[7]; // sport
					values[3] = data[5]; // height
					values[4] = data[6]; // weight
					values[5] = data[3]; // gender
					
					theOne.mOlympiansDB.createRecord(Arrays.copyOfRange(OLYMPIANS_FIELD_NAMES, 1, OLYMPIANS_FIELD_NAMES.length), values);
					recordsCreated++;
				}
				// All done with the CSV file, close the connection
				fileScanner.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			return recordsCreated;
		}
		
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ END OF [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	/* ~~~~~~~~~~~~~~~~~~~~~ [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ END OF [Insert title] PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~ DIETARY RESTRICTIONS PORTION ~~~~~~~~~~~~~~~~~~~~~ */
	public ObservableList<Olympian> getAllOlympiansList()
	{
		return mAllOlympiansList;
	
	}
	
	public ObservableList<Olympian> getFilteredOlympiansList()
	{
		return mFilteredOlympiansList;
	}
				
	//Filter method
	public ObservableList<Olympian> filter(Predicate<Olympian> criteria){
	//clear filtered list.
	mFilteredOlympiansList.clear();
	for(Olympian o : mAllOlympiansList)
		if(criteria.test(o))
			mFilteredOlympiansList.add(o);
	return mFilteredOlympiansList;
	}

				
				
				
				
	/* ---------------- SIGNING UP NEW MEMBERS PORTION ------------- */
	public boolean isValidEmail(String email)
	{
		return email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}	
	
	public String signUpUser(String name, String email, String password, int age, String gender)
	{
		if (!isValidEmail(email))
			return "invalid e-mail address";
		if (theOne.mAllUsersList != null) {
			for (User u : theOne.mAllUsersList)
				if (email.equalsIgnoreCase(u.getEmail()))
					return "please try a different e-mail ";
		}
		//String[] USER_FIELD_NAMES = {"_id", "name", "email", "age", "gender", "password"};

		String[] values = {name, email, String.valueOf(age), gender, password};
		
		try {
			// mUserDB is null, and stays null--even with this addition of code
			if (theOne.mUserDB == null) theOne.getInstance();
			// Store the ID in the database
			int id = theOne.mUserDB.createRecord(Arrays.copyOfRange(USER_FIELD_NAMES, 1, USER_FIELD_NAMES.length), values);
			// Set the new user as the current user
			theOne.mCurrentUser = new User(id, name, gender, age, email);
			// Add the user to the database
			theOne.mAllUsersList.add(theOne.mCurrentUser);
		} catch (SQLException e) {
			e.printStackTrace();
			return "ERROR! please try again. ";
		}
		
		return "Success";
		
	}
	
	public String signInUser(String email, String password) {
		
		for (User user : theOne.mAllUsersList)
		{
			if (user.getEmail().equalsIgnoreCase(email))
			{
				// Check the database and retrieve the password 
				try {
					// Why is this not returning an array list of strings instead of a result set?
					ArrayList<ArrayList<String>> userResults = theOne.mUserDB.getRecordFromArrayList(String.valueOf(user.getID()));
					
					String storedPassword = userResults.get(0).get(5);
					
					// Check if the password is correct
					if (password.equals(storedPassword))
					{
						theOne.mCurrentUser = user;
						ViewNavigator.loadScene("Main Menu", ViewNavigator.ALTERNATE_MAIN_MENU_SCENE);
						return "Success!";
					}
					else 
						break;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "incorrect e-mail/password";
	}
	
	public void close() throws Exception 
	{
		mFoodsDB.close();
		mFavoriteFoodsDB.close();
		mPreferencesDB.close();
		
		mOlympiansDB.close();
	}
	
	
	
}