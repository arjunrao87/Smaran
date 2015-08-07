package com.app;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.put;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Request;
import spark.Response;

import com.app.data.EventType;
import com.app.model.db.IDatabase;
import com.app.model.db.TextFileDatabase;
import com.app.util.JsonTransformer;
import com.app.util.Util;

/**
 * 
 * @author arjunrao
 *
 */
public class SmaranServer {
    
	private static final Logger LOG = LoggerFactory.getLogger( SmaranServer.class );
	private final IDatabase database;
	
	public SmaranServer(){
		this.database = new TextFileDatabase("com/app/database/db.json");
	}
	
	public static void main(String[] args) {
		SmaranServer server = new SmaranServer();
		server.defineRoutes();
		LOG.info( "************** SMARAN IS UP AND RUNNING *************" );
    }

	public void defineRoutes(){
		// Index page
		get("/", "application/json", (req, res) -> "You are accessing the Smaran WebServer" );

		// Get events of a particular type for a particular ID
		//TODO : Change all these requests to POST type
		get("/events/:id"              , "application/json", (req, res) -> getEvents( req, res, req.params(":id"), null ), new JsonTransformer() );
		get("/events/birthdays/:id"    , "application/json", (req, res) -> getEvents( req, res, req.params(":id"), EventType.BIRTHDAY ), new JsonTransformer() );
		get("/events/anniversaries/:id", "application/json", (req, res) -> getEvents( req, res, req.params(":id"), EventType.ANNIVERSARY ), new JsonTransformer() );
		
		// Add or delete birthdays for an id
		put("/events/birthdays/add/:fromId/:toId", (req, res) -> putEvent( req, res, req.params( ":fromId" ), req.params( ":toId" ), EventType.BIRTHDAY ) );
		delete("/events/birthdays/delete/:id", (req, res) -> "");
		
		// Add or delete anniversaries for an id
		put("/events/anniversaries/add/:fromId/:toId", (req, res) -> putEvent( req, res, req.params( ":fromId" ), req.params( ":toId" ), EventType.BIRTHDAY ) );
		delete("/events/anniversaries/delete/:id", (req, res) -> "");
	}

	// ----------------------------------- DATABASE ACTIONS -------------------------------------//

	private Object getEvents(Request req, Response res, String userId, EventType type) {
		LOG.info( "Request made : " + Util.requestToString( req ) + ", User ID = " + userId + ", Event type = " + type );
		if( type == null ){
			return this.database.getUser(userId);
		} else if ( type.equals(EventType.ANNIVERSARY)){
			return this.database.getUser(userId).getAnniversaries();
		} else if ( type.equals(EventType.BIRTHDAY)){
			return this.database.getUser(userId).getBirthdays();
		}
		return null;
	}
	
	private Void putEvent(Request req, Response res, String fromId, String toId, EventType type) {
		LOG.info( "Request made : " + Util.requestToString( req ) + ", From User ID = " + fromId + ", To User ID = " + toId + ", Event type = " + type );
		return null;
	}
}