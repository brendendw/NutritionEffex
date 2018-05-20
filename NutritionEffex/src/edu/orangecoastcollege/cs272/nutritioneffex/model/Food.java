package edu.orangecoastcollege.cs272.nutritioneffex.model;

/**
 * This class represents an item of Food.
 * Food contains many descriptors such as
 * a name, calories, added sugars, etc.
 * @author Sean Dowdle
 *
 */
public class Food
{
    private int mId;
    private String mDisplayName;
    private String mPortionDisplay;
    private double mVegetables;
    private double mFruits;
    private double mMilk;
    private double mMeats;
    private double mSoy;
    private double mSolidFats;
    private double mAddedSugars;
    private double mAlcohol;
    private double mCalories;
    private double mSaturatedFats;
    /**
     * Instantiates a new Food object.
     * @param id The id of the Food
     * @param displayName The name of the Food.
     * @param portionDisplay The description of the Food's portion size.
     * @param vegetables How many vegetables are in the Food.
     * @param fruits How many fruits are in the Food.
     * @param milk How much dairy is in the Food.
     * @param meats How much meat is in the Food.
     * @param soy How much soy is in the Food.
     * @param solidFats How much solid fats are in the Food.
     * @param addedSugars How much added sugar is in the Food.
     * @param alcohol How much alcohol is in the Food.
     * @param calories How many calories are in the Food.
     * @param saturatedFats How many saturated fats are in the Food.
     */
    public Food(int id, String displayName, String portionDisplay, double vegetables,
                double fruits, double milk, double meats, double soy, double solidFats,
                double addedSugars, double alcohol, double calories, double saturatedFats)
    {
        mId = id;
        mDisplayName = displayName;
        mPortionDisplay = portionDisplay;
        mVegetables = vegetables;
        mFruits = fruits;
        mMilk = milk;
        mMeats = meats;
        mSoy = soy;
        mSolidFats = solidFats;
        mAddedSugars = addedSugars;
        mAlcohol = alcohol;
        mCalories = calories;
        mSaturatedFats = saturatedFats;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return mId;
    }

    /**
     * Sets the id of the Food.
     * @param mId The id to set
     */
    public void setId(int id)
    {
        mId = id;
    }

    /**
     * @return the portion description
     */
    public String getPortionDisplay()
    {
        return mPortionDisplay;
    }

    /**
     * Sets the portion description.
     * @param portionDisplay The portion description to set.
     */
    public void setPortionDisplay(String portionDisplay)
    {
        mPortionDisplay = portionDisplay;
    }

    /**
     * @return the display name
     */
    public String getDisplayName()
    {
        return mDisplayName;
    }

    /**
     * Sets the name of the Food.
     * @param displayName The name of the Food to set.
     */
    public void setDisplayName(String displayName)
    {
        mDisplayName = displayName;
    }

    /**
     * @return the amount of vegetables in the Food
     */
    public double getVegetables()
    {
        return mVegetables;
    }

    /**
     * Sets the amount of vegetables in the Food.
     * @param vegetables The amount of vegetables in the Food.
     */
    public void setVegetables(double vegetables)
    {
        mVegetables = vegetables;
    }

    /**
     * @return the amount of fruits in the Food.
     */
    public double getFruits()
    {
        return mFruits;
    }

    /**
     * Sets the amount of fruit in the Food.
     * @param fruits the amount of fruits in the Food.
     */
    public void setFruits(double fruits)
    {
        mFruits = fruits;
    }

    /**
     * @return the amount of dairy in the Food.
     */
    public double getMilk()
    {
        return mMilk;
    }

    /**
     * Sets the amount of dairy in the Food.
     * @param milk The amount of dairy in the Food
     */
    public void setMilk(double milk)
    {
        mMilk = milk;
    }

    /**
     * @return the amount of meat in the Food
     */
    public double getMeats()
    {
        return mMeats;
    }

    /**
     * Sets the amount of meat in the Food.
     * @param meats The amount of meat in the Food.
     */
    public void setMeats(double meats)
    {
        mMeats = meats;
    }

    /**
     * @return the amount of soy in the Food
     */
    public double getSoy()
    {
        return mSoy;
    }

    /**
     * Sets the amount of soy in the Food.
     * @param soy The amount of soy in the Food.
     */
    public void setSoy(double soy)
    {
        mSoy = soy;
    }

    /**
     * @return the amount of solid fats in the Food.
     */
    public double getSolidFats()
    {
        return mSolidFats;
    }
    /**
     * @return the amount of alcohol in the Food.
     */
    public double getAlcohol()
    {
    	return mAlcohol;
    }
    /**
     * Sets the amount of solid fats in the Food.
     * @param solidFats the amount of solid fats in the Food.
     */
    public void setSolidFats(double solidFats)
    {
        mSolidFats = solidFats;
    }

    /**
     * @return the addedSugars
     */
    public double getAddedSugars()
    {
        return mAddedSugars;
    }

    /**
     * Sets the amount of added sugars in the Food.
     * @param addedSugars The amount of added sugars in the Food
     */
    public void setAddedSugars(double addedSugars)
    {
        mAddedSugars = addedSugars;
    }
    
    /**
     * Sets the amount of alcohol in the Food.
     * @param alcohol The amount of alcohol in the Food.
     */
    public void setAlcohol(double alcohol)
    {
        mAlcohol = alcohol;
    }

    /**
     * @return the amount of calories in the Food.
     */
    public double getCalories()
    {
        return mCalories;
    }

    /**
     * Sets the amount of calories in the Food.
     * @param calories The amount of calories in the Food.
     */
    public void setCalories(double calories)
    {
        mCalories = calories;
    }

    /**
     * @return the amount of saturated fats in the Food.
     */
    public double getSaturatedFats()
    {
        return mSaturatedFats;
    }

    /**
     * Sets the amount of saturated fats in the Food.
     * @param saturatedFats The amount of saturated fats in the Food.
     */
    public void setSaturatedFats(double saturatedFats)
    {
        mSaturatedFats = saturatedFats;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(mAddedSugars);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mAlcohol);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mCalories);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mDisplayName == null) ? 0 : mDisplayName.hashCode());
		temp = Double.doubleToLongBits(mFruits);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + mId;
		temp = Double.doubleToLongBits(mMeats);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mMilk);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mPortionDisplay == null) ? 0 : mPortionDisplay.hashCode());
		temp = Double.doubleToLongBits(mSaturatedFats);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mSolidFats);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mSoy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mVegetables);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (Double.doubleToLongBits(mAddedSugars) != Double.doubleToLongBits(other.mAddedSugars))
			return false;
		if (Double.doubleToLongBits(mAlcohol) != Double.doubleToLongBits(other.mAlcohol))
			return false;
		if (Double.doubleToLongBits(mCalories) != Double.doubleToLongBits(other.mCalories))
			return false;
		if (mDisplayName == null) {
			if (other.mDisplayName != null)
				return false;
		} else if (!mDisplayName.equals(other.mDisplayName))
			return false;
		if (Double.doubleToLongBits(mFruits) != Double.doubleToLongBits(other.mFruits))
			return false;
		if (mId != other.mId)
			return false;
		if (Double.doubleToLongBits(mMeats) != Double.doubleToLongBits(other.mMeats))
			return false;
		if (Double.doubleToLongBits(mMilk) != Double.doubleToLongBits(other.mMilk))
			return false;
		if (mPortionDisplay == null) {
			if (other.mPortionDisplay != null)
				return false;
		} else if (!mPortionDisplay.equals(other.mPortionDisplay))
			return false;
		if (Double.doubleToLongBits(mSaturatedFats) != Double.doubleToLongBits(other.mSaturatedFats))
			return false;
		if (Double.doubleToLongBits(mSolidFats) != Double.doubleToLongBits(other.mSolidFats))
			return false;
		if (Double.doubleToLongBits(mSoy) != Double.doubleToLongBits(other.mSoy))
			return false;
		if (Double.doubleToLongBits(mVegetables) != Double.doubleToLongBits(other.mVegetables))
			return false;
		return true;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return  "id= " + mId + " | " + mDisplayName + " | Portion = " + mPortionDisplay
                + " | Vegetables = " + mVegetables + " | Fruits = " + mFruits + " | Milk = " + mMilk + " | Meats = " + mMeats
                + " | Soy = " + mSoy + " | Solid Fats = " + mSolidFats + " | Added Sugars = " + mAddedSugars + " | Alcohol = "
                + mAlcohol + " | Calories = " + mCalories + " | Saturated Fats = " + mSaturatedFats + "]";
    }
}
