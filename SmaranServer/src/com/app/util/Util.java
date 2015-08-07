package com.app.util;

import org.apache.commons.lang3.StringUtils;

import spark.Request;

public class Util {

	@SuppressWarnings("unchecked")
	public static String requestToString( Request request ){
		StringBuilder builder = new StringBuilder();
		builder.append( "  Host = " + request.host() );
		builder.append( ", Port = " + request.port() );
		builder.append( ", IP = " + request.ip() );
		builder.append( ", ContentType = " + request.contentType() );
		builder.append( ", Params = " + StringUtils.join( request.params() ) );
		builder.append( ", QueryParams = " + StringUtils.join( request.queryParams() ) );
		return builder.toString();
	}
}
