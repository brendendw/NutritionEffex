package edu.orangecoastcollege.cs272.nutritioneffex.model;

public class Olympian {
	private int mId;
	private String mName;
	private String mAge;
	private String mSport;
	private double mHeight;
	private double mWeight;
	private boolean mGender;
	
	
	public Olympian(int id,String name, String age, String sport, double height, double weight, boolean gender) {
		super();
		mId = id;
		mName = name;
		mAge = age;
		mSport = sport;
		mHeight = height;
		mWeight = weight;
		mGender = gender;
	}
	public int getId() {
		return mId;
	}
	public void setId(int id) {
		mId = id;
	}
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		mName = name;
	}
	public String getAge() {
		return mAge;
	}
	public void setAge(String age) {
		mAge = age;
	}
	public String getSport() {
		return mSport;
	}
	public void setSport(String sport) {
		mSport = sport;
	}
	public double getHeight() {
		return mHeight;
	}
	public void setHeight(double height) {
		mHeight = height;
	}
	public double getWeight() {
		return mWeight;
	}
	public void setWeight(double weight) {
		mWeight = weight;
	}
	public boolean isGender() {
		return mGender;
	}
	public void setGender(boolean gender) {
		mGender = gender;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mAge == null) ? 0 : mAge.hashCode());
		result = prime * result + (mGender ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(mHeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + mId;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + ((mSport == null) ? 0 : mSport.hashCode());
		temp = Double.doubleToLongBits(mWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Olympian other = (Olympian) obj;
		if (mAge == null) {
			if (other.mAge != null)
				return false;
		} else if (!mAge.equals(other.mAge))
			return false;
		if (mGender != other.mGender)
			return false;
		if (Double.doubleToLongBits(mHeight) != Double.doubleToLongBits(other.mHeight))
			return false;
		if (mId != other.mId)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mSport == null) {
			if (other.mSport != null)
				return false;
		} else if (!mSport.equals(other.mSport))
			return false;
		if (Double.doubleToLongBits(mWeight) != Double.doubleToLongBits(other.mWeight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		
		
		return "Olympian [Id=" + mId + ", Name=" + mName + ", BirthDate=" + mAge + ", Sport=" + mSport + ", Height="
				+ mHeight + ", Weight=" + mWeight + ", Gender=" +(mGender==(true) ? "female": "male") + "]";
	}
	
	
	
}
