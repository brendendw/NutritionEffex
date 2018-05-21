package edu.orangecoastcollege.cs272.nutritioneffex.model;

public class Workout {
public String mWorkoutType;
public String mDuration;
public String mDate;
public Workout(String workoutType, String duration, String date) {
	super();
	mWorkoutType = workoutType;
	mDuration = duration;
	mDate = date;
}
public String getWorkoutType() {
	return mWorkoutType;
}
public void setWorkoutType(String workoutType) {
	mWorkoutType = workoutType;
}
public String getDuration() {
	return mDuration;
}
public void setDuration(String duration) {
	mDuration = duration;
}
public String getDate() {
	return mDate;
}
public void setDate(String date) {
	mDate = date;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((mDate == null) ? 0 : mDate.hashCode());
	result = prime * result + ((mDuration == null) ? 0 : mDuration.hashCode());
	result = prime * result + ((mWorkoutType == null) ? 0 : mWorkoutType.hashCode());
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
	Workout other = (Workout) obj;
	if (mDate == null) {
		if (other.mDate != null)
			return false;
	} else if (!mDate.equals(other.mDate))
		return false;
	if (mDuration == null) {
		if (other.mDuration != null)
			return false;
	} else if (!mDuration.equals(other.mDuration))
		return false;
	if (mWorkoutType == null) {
		if (other.mWorkoutType != null)
			return false;
	} else if (!mWorkoutType.equals(other.mWorkoutType))
		return false;
	return true;
}
@Override
public String toString() {
	return "Workout [Workout Type=" + mWorkoutType + ", Duration=" + mDuration + ", Date=" + mDate + "]";
}


}
