package com.app.data;

import java.util.List;

public class User {
	
	private String userName;
	private String userID;
	private List<Birthday> birthdays;
	private List<Anniversary> anniversaries;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public List<Birthday> getBirthdays() {
		return birthdays;
	}
	public void setBirthdays(List<Birthday> birthdays) {
		this.birthdays = birthdays;
	}
	public List<Anniversary> getAnniversaries() {
		return anniversaries;
	}
	public void setAnniversaries(List<Anniversary> anniversaries) {
		this.anniversaries = anniversaries;
	}
	@Override
	public String toString() {
		return "UserObj [userName=" + userName + ", userID=" + userID
				+ ", birthdays=" + birthdays + ", anniversaries="
				+ anniversaries + "]";
	}
}