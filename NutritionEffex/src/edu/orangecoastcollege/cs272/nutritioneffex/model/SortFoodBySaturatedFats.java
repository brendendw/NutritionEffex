package edu.orangecoastcollege.cs272.nutritioneffex.model;

import java.util.Comparator;

/**
 * A class that implements Comparator to sort
 * Food objects in increasing order of saturated fats
 * @author Sean Dowdle
 *
 */
public class SortFoodBySaturatedFats implements Comparator<Food>
{
	/**
	 * Compares the names of Food objects to sort
	 * in order of saturated fats.
	 */
	public int compare(Food food1, Food food2) 
	{
		if(food1.getSaturatedFats() < food2.getSaturatedFats()) return -1;
		if(food1.getSaturatedFats() > food2.getSaturatedFats()) return 1;
		return 0;
	}
}