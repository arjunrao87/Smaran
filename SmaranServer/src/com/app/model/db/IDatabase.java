package com.app.model.db;

import java.util.List;

import com.app.data.Anniversary;
import com.app.data.Birthday;
import com.app.data.User;

public interface IDatabase {

	//GET 
	public User getUser( String userId );
	
	public List<Birthday> getBirthdays( String userId );
	
	public List<Anniversary> getAnniversaries( String userId );
	
	//PUT
	
}