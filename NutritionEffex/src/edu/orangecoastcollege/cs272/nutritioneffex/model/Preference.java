package edu.orangecoastcollege.cs272.nutritioneffex.model;
/**
 * Represents a user's dietary preference.
 * A preference has a string representing what their
 * preference is and an id.
 * @author Sean Dowdle
 *
 */
public class Preference 
{
	private int mId;
	private String mPreference;
	/**
	 * Instantiates a user preference
	 * @param id The id of the preference.
	 * @param preference The text description of the preference.
	 */
	public Preference(int id, String preference)
	{
		mId = id;
		mPreference = preference;
	}
	/**
	 * Returns the id of the preference.
	 * @return the id of the preference
	 */
	public int getId()
	{
		return mId;
	}
	/**
	 * Returns the description of the preference.
	 * @return the description of the preference
	 */
	public String getPreference()
	{
		return mPreference;
	}
	/**
	 * Sets the preference based on the given data.
	 * @param preference The new preference to set
	 */
	public void setPreference(String preference)
	{
		mPreference = preference;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + mId;
		result = prime * result + ((mPreference == null) ? 0 : mPreference.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preference other = (Preference) obj;
		if (mId != other.mId)
			return false;
		if (mPreference == null) {
			if (other.mPreference != null)
				return false;
		} else if (!mPreference.equals(other.mPreference))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return mPreference;
	}
}