package edu.orangecoastcollege.cs272.nutritioneffex.model;

import java.util.Comparator;

/**
 * A class that implements Comparator to sort
 * Food objects in increasing order of calories
 * @author Sean Dowdle
 *
 */
public class SortFoodByCalories implements Comparator<Food>
{
	/**
	 * Compares the names of Food objects to sort
	 * in increasing order of calories
	 */
	public int compare(Food food1, Food food2) 
	{
		if(food1.getCalories() < food2.getCalories()) return -1;
		if(food1.getCalories() > food2.getCalories()) return 1;
		return 0;
	}
}