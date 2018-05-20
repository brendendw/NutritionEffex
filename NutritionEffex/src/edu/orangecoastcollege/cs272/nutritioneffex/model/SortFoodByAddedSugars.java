package edu.orangecoastcollege.cs272.nutritioneffex.model;

import java.util.Comparator;

/**
 * A class that implements Comparator to sort
 * Food objects in increasing order of added sugars
 * @author Sean Dowdle
 *
 */
public class SortFoodByAddedSugars implements Comparator<Food>
{
	/**
	 * Compares the names of Food objects to sort
	 * in increasing order of added sugars
	 */
	@Override
	public int compare(Food food1, Food food2) 
	{
		if(food1.getAddedSugars() < food2.getAddedSugars()) return -1;
		if(food1.getAddedSugars() > food2.getAddedSugars()) return 1;
		return 0;
	}
}