package edu.orangecoastcollege.cs272.nutritioneffex.test;

import static org.junit.Assert.assertEquals;
import java.util.Collections;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.orangecoastcollege.cs272.nutritioneffex.controller.Controller;
import edu.orangecoastcollege.cs272.nutritioneffex.model.Food;
import edu.orangecoastcollege.cs272.nutritioneffex.model.Preference;
import edu.orangecoastcollege.cs272.nutritioneffex.model.SortFoodByAddedSugars;
import edu.orangecoastcollege.cs272.nutritioneffex.model.SortFoodByCalories;
import edu.orangecoastcollege.cs272.nutritioneffex.model.SortFoodByName;
import edu.orangecoastcollege.cs272.nutritioneffex.model.SortFoodBySaturatedFats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * This JUnit test is responsible for testing all of the filtering 
 * functions in the FoodScene.java class in the View. Since I cannot call
 * the methods without problems due to the enabling / disabling of buttons and
 * JavaFX stuff, I am essentially using the exact same code from the FoodScene
 * responsible for doing the filtering without the JavaFX code.
 * @author Sean Dowdle
 *
 */
class TestFoodScene 
{
	private static Controller controller = Controller.getInstance();
	private static ObservableList<Food> allFoods = FXCollections.observableArrayList();
	private static ObservableList<Preference> preferences = FXCollections.observableArrayList();
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		preferences.add(new Preference(1, "No Dairy"));
		preferences.add(new Preference(2, "No Meat"));
		allFoods = controller.filterOnPreferences(controller.getAllFoods(), preferences);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		controller.close();
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
	}

	@Test
	void testFilterExcludedItems()
	{
		ObservableList<Food> filteredFoods = allFoods;
		assertEquals("Testing list of foods before being unfiltered", 1026, filteredFoods.size());
		filteredFoods = controller.filterExcluded(controller.getAllFoods(), controller.getAllPreferences());
		assertEquals("Testing list of foods is filtered on excluded items", 988, filteredFoods.size());
	}
	@Test
	void testUnfilter()
	{
		ObservableList<Food> unfilteredFoods = allFoods;
		assertEquals("Testing list of foods before being unfiltered", 1026, unfilteredFoods.size());
		unfilteredFoods = controller.getAllFoods();
		assertEquals("Testing list of foods is unfiltered", 2014, unfilteredFoods.size());
	}
	@Test
	void testFilterFoodsByName()
	{
		Collections.sort(allFoods, new SortFoodByName());
		boolean isOutOfOrder = false;
		String previous = allFoods.get(0).getDisplayName();
		for(int i = 1; i < allFoods.size(); i++)
		{
			if(previous.compareTo(allFoods.get(i).getDisplayName()) <= 0)
			{
				previous = allFoods.get(i).getDisplayName();
			}
			else
			{
				isOutOfOrder = true;
				i = allFoods.size();
			}
		}
		assertEquals("Testing list of foods is in order by name", false, isOutOfOrder);
	}
	@Test
	void testFilterFoodsByCalories()
	{
		Collections.sort(allFoods, new SortFoodByCalories());
		boolean isOutOfOrder = false;
		double min = 0.0000000;
		for(int i = 0; i < allFoods.size(); i++)
		{
			if(allFoods.get(i).getCalories() >= min)
			{
				min = allFoods.get(i).getCalories();
			}
			else
			{
				isOutOfOrder = true;
				i = allFoods.size();
			}
		}
		assertEquals("Testing list of foods is in order by calories", false, isOutOfOrder);
	}
	@Test
	void testFilterFoodsBySatFats()
	{
		Collections.sort(allFoods, new SortFoodBySaturatedFats());
		boolean isOutOfOrder = false;
		double min = 0.0000000;
		for(int i = 0; i < allFoods.size(); i++)
		{
			if(allFoods.get(i).getSaturatedFats() >= min)
			{
				min = allFoods.get(i).getSaturatedFats();
			}
			else
			{
				isOutOfOrder = true;
				i = allFoods.size();
			}
		}
		assertEquals("Testing list of foods is in order by calories", false, isOutOfOrder);
	}
	@Test
	void testFilterFoodsByAddedSugars()
	{
		Collections.sort(allFoods, new SortFoodByAddedSugars());
		boolean isOutOfOrder = false;
		double min = 0.0000000;
		for(int i = 0; i < allFoods.size(); i++)
		{
			if(allFoods.get(i).getAddedSugars() >= min)
			{
				min = allFoods.get(i).getAddedSugars();
			}
			else
			{
				isOutOfOrder = true;
				i = allFoods.size();
			}
		}
		assertEquals("Testing list of foods is in order by calories", false, isOutOfOrder);
	}

}