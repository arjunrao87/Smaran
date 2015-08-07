package com.app.model.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.app.data.Anniversary;
import com.app.data.Birthday;
import com.app.data.User;
import com.app.data.UserList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TextFileDatabase implements IDatabase{

	private final Map<String, User> session;
	
	public TextFileDatabase( String filepath ){
		this.session = this.init( filepath );
	}
	
	private Map<String, User> init(String filepath) {
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(filepath).getFile());
			BufferedReader br = new BufferedReader( new FileReader(file));
			UserList list =  gson.fromJson(br, UserList.class );
			Map<String, User> session = new ConcurrentHashMap<>();
			for( User user : list.getUsers() ){
				session.put(user.getUserID(), user);
			}
			return session;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(String userId) {
		return this.session.get(userId);
	}

	@Override
	public List<Birthday> getBirthdays(String userId) {
		return this.getUser(userId).getBirthdays();
	}

	@Override
	public List<Anniversary> getAnniversaries(String userId) {
		return this.getUser( userId ).getAnniversaries();
	}
}