package edu.orangecoastcollege.cs272.nutritioneffex.model;

import java.util.Comparator;
/**
 * A class that implements Comparator to sort
 * Food objects in alphabetical order
 * @author Sean Dowdle
 *
 */
public class SortFoodByName implements Comparator<Food>
{
	/**
	 * Compares the names of Food objects to sort
	 * in alphabetical order.
	 */
	@Override
	public int compare(Food food1, Food food2) 
	{
		return food1.getDisplayName().compareTo(food2.getDisplayName());
	}
}
