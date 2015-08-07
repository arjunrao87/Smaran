package com.app.data;

import java.util.Date;

public class Birthday extends Event {

	public Birthday(String person, Date eventDate,String remindDate, String remindTime, String remindMode) {
		super(EventType.BIRTHDAY, person, eventDate, remindDate, remindTime, remindMode);
	}

	@Override
	public void setEvent( EventType type ){
		super.setEvent(EventType.BIRTHDAY);
	}
}