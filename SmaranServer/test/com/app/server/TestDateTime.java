package com.app.server;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class TestDateTime {

	public static void main( String... strings ){
		DateTime datetime = new DateTime();
		System.err.println( "Datetime = " + datetime );
		System.err.println( "date part = " + datetime.toDate() );
		LocalDate date = new LocalDate();
		System.err.println( "Date = " + date );
		LocalTime time = new LocalTime();
		System.err.println( "Time = " + time );
		DateTime dateTime = new DateTime( date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), time.getHourOfDay(), time.getMinuteOfHour(), time.getSecondOfMinute() );
		System.err.println( "Composed datetime = " + dateTime );
	}
}
