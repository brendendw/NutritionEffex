package edu.orangecoastcollege.cs272.nutritioneffex.model;
/**
 *
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
     * @return the mId
     */
    public int getId()
    {
        return mId;
    }

    /**
     * @param mId the mId to set
     */
    public void setId(int id)
    {
        mId = id;
    }

    /**
     * @return the mPortionDisplay
     */
    public String getPortionDisplay()
    {
        return mPortionDisplay;
    }

    /**
     * @param mPortionDisplay the mPortionDisplay to set
     */
    public void setPortionDisplay(String portionDisplay)
    {
        mPortionDisplay = portionDisplay;
    }

    /**
     * @return the mDisplayName
     */
    public String getDisplayName()
    {
        return mDisplayName;
    }

    /**
     * @param mDisplayName the mDisplayName to set
     */
    public void setDisplayName(String displayName)
    {
        mDisplayName = displayName;
    }

    /**
     * @return the mVegetables
     */
    public double getVegetables()
    {
        return mVegetables;
    }

    /**
     * @param mVegetables the mVegetables to set
     */
    public void setVegetables(double vegetables)
    {
        mVegetables = vegetables;
    }

    /**
     * @return the mFruits
     */
    public double getFruits()
    {
        return mFruits;
    }

    /**
     * @param mFruits the mFruits to set
     */
    public void setFruits(double fruits)
    {
        mFruits = fruits;
    }

    /**
     * @return the mMilk
     */
    public double getMilk()
    {
        return mMilk;
    }

    /**
     * @param mMilk the mMilk to set
     */
    public void setMilk(double milk)
    {
        mMilk = milk;
    }

    /**
     * @return the mMeats
     */
    public double getMeats()
    {
        return mMeats;
    }

    /**
     * @param mMeats the mMeats to set
     */
    public void setMeats(double meats)
    {
        mMeats = meats;
    }

    /**
     * @return the mSoy
     */
    public double getSoy()
    {
        return mSoy;
    }

    /**
     * @param mSoy the mSoy to set
     */
    public void setSoy(double soy)
    {
        mSoy = soy;
    }

    /**
     * @return the mSolidFats
     */
    public double getSolidFats()
    {
        return mSolidFats;
    }

    /**
     * @param mSolidFats the mSolidFats to set
     */
    public void setSolidFats(double solidFats)
    {
        mSolidFats = solidFats;
    }

    /**
     * @return the mAddedSugars
     */
    public double getAddedSugars()
    {
        return mAddedSugars;
    }

    /**
     * @param mAddedSugars the mAddedSugars to set
     */
    public void setAddedSugars(double addedSugars)
    {
        mAddedSugars = addedSugars;
    }

    /**
     * @return the mAlcohol
     */
    public double getmlcohol()
    {
        return mAlcohol;
    }

    /**
     * @param mAlcohol the mAlcohol to set
     */
    public void setAlcohol(double alcohol)
    {
        mAlcohol = alcohol;
    }

    /**
     * @return the mCalories
     */
    public double getCalories()
    {
        return mCalories;
    }

    /**
     * @param mCalories the mCalories to set
     */
    public void setCalories(double calories)
    {
        mCalories = calories;
    }

    /**
     * @return the mSaturatedFats
     */
    public double getSaturatedFats()
    {
        return mSaturatedFats;
    }

    /**
     * @param mSaturatedFats the mSaturatedFats to set
     */
    public void setSaturatedFats(double saturatedFats)
    {
        mSaturatedFats = saturatedFats;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Food [mId=" + mId + ", Display Name=" + mDisplayName + ", Portion Display=" + mPortionDisplay
                + ", Vegetables=" + mVegetables + ", Fruits=" + mFruits + ", Milk=" + mMilk + ", Meats=" + mMeats
                + ", Soy=" + mSoy + ", Solid Fats=" + mSolidFats + ", Added Sugars=" + mAddedSugars + ", Alcohol="
                + mAlcohol + ", Calories=" + mCalories + ", Saturated Fats=" + mSaturatedFats + "]";
    }

}
