package com.app.data;

import java.util.Date;

public class Anniversary extends Event {

	public Anniversary(String person, Date eventDate, String remindDate, String remindTime, String remindMode) {
		super(EventType.ANNIVERSARY, person, eventDate, remindDate, remindTime, remindMode);
	}

	@Override
	public void setEvent( EventType type ){
		super.setEvent(EventType.ANNIVERSARY);
	}
}
