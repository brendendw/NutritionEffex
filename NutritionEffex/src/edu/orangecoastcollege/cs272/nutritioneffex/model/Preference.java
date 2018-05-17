package edu.orangecoastcollege.cs272.nutritioneffex.model;

public class Preference 
{
	private int mId;
	private String mPreference;
	
	public Preference(int id, String preference)
	{
		mId = id;
		mPreference = preference;
	}
	
	public int getId()
	{
		return mId;
	}
	public String getPreference()
	{
		return mPreference;
	}
	public void setPreference(String preference)
	{
		mPreference = preference;
	}
	
}