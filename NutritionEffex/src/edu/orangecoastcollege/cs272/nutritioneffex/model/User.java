package edu.orangecoastcollege.cs272.nutritioneffex.model;

public class User {
	
	private int mID;
	private int mAge;
	private String mName;
	private String mGender;
	private String mEmail;
	
	
	public User(int id, String name, String gender, int age, String email)
	{
		super();
		mName = name;
		mID = id;
		mAge = age;
		mGender = gender;
		mEmail = email;
	}


	public String getName() {
		return mName;
	}
	
	public void setName(String name)
	{
		mName = name;
	}
	public int getAge() {
		return mAge;
	}


	public void setAge(int age) {
		mAge = age;
	}


	public String getGender() {
		return mGender;
	}


	public void setGender(String gender) {
		mGender = gender;
	}


	public String getEmail() {
		return mEmail;
	}


	public void setEmail(String email) {
		mEmail = email;
	}
	
	public int getID() {
		return mID;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mAge;
		result = prime * result + ((mEmail == null) ? 0 : mEmail.hashCode());
		result = prime * result + ((mGender == null) ? 0 : mGender.hashCode());
		result = prime * result + mID;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (mAge != other.mAge)
			return false;
		if (mEmail == null) {
			if (other.mEmail != null)
				return false;
		} else if (!mEmail.equals(other.mEmail))
			return false;
		if (mGender == null) {
			if (other.mGender != null)
				return false;
		} else if (!mGender.equals(other.mGender))
			return false;
		if (mID != other.mID)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserID: " + mID + "\nName: " + mName + "\nAge: " + mAge + "\nGender: " + mGender + "\nE-maiL: " + mEmail;
	}
	
	

}
