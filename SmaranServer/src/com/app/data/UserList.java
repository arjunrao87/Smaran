package com.app.data;

import java.util.List;

public class UserList {
	
	private List<User> users;
	
	public List<User> getUsers(){
		return this.users;
	}
	
	public void setUsers( List<User> objects ){
		this.users = objects;
	}

	@Override
	public String toString() {
		return "ModelCalendar [users=" + users + "]";
	}
}